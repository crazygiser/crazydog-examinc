package com.crazydog.apiutils.poi;

import lombok.Data;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: excel导出的工具类
 * @author: cc
 * @since: 2021-01-27 10:20:02
 */
@Data
public class ExcelExportUtil<T> {
    /**
     * 从第几行开始导入
     */
    private int rowIndex;

    /**
     * 以哪一行为样式模板
     */
    private int styleIndex;

    /**
     * 报表模板路径
     */
    private String templatePath;

    /**
     * 报表对应实体类的class
     */
    private Class clazz;

    /**
     * 实体类中添加了@ExcelAttribute属性集合
     */
    private List<Field> fields = new ArrayList<>();

    public ExcelExportUtil(Class clazz, int rowIndex, int styleIndex) {
        this.clazz = clazz;
        this.rowIndex = rowIndex;
        this.styleIndex = styleIndex;
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(ExcelAttribute.class)) {
                field.setAccessible(true);
                fields.add(field);
            }
        }
    }

    public ExcelExportUtil(Class clazz, int rowIndex) {
        this(clazz, rowIndex, -1);
    }

    /**
     * 基于模板的导出
     */
    public void exportWithTemplate(HttpServletResponse response, InputStream is, List<T> objs, String fileName) throws Exception {
        XSSFWorkbook wb = new XSSFWorkbook(is);
        // 百万计数据的处理
        SXSSFWorkbook workbook = new SXSSFWorkbook(wb);
        Sheet sheet = workbook.getSheetAt(0);
        if (styleIndex >= 0) {
            CellStyle[] styles = getTemplateStyles(wb.getSheetAt(0).getRow(styleIndex));
            // 移除掉styleIndex的row 不然会报错
            wb.getSheetAt(0).removeRow(wb.getSheetAt(0).getRow(styleIndex));
            AtomicInteger datasAi = new AtomicInteger(rowIndex);
            for (T t : objs) {
                org.apache.poi.ss.usermodel.Row row = sheet.createRow(datasAi.getAndIncrement());
                for (int i = 0; i < styles.length; i++) {
                    Cell cell = row.createCell(i);
                    cell.setCellStyle(styles[i]);
                    for (Field field : fields) {
                        ExcelAttribute ea = field.getAnnotation(ExcelAttribute.class);
                        if (i == ea.sort()) {
                            cell.setCellValue(field.get(t).toString());
                        }
                    }
                }
            }
        } else {
            org.apache.poi.ss.usermodel.Row indexRow = wb.getSheetAt(0).getRow(rowIndex);
            if (indexRow != null) {
                wb.getSheetAt(0).removeRow(indexRow);
            }
            AtomicInteger datasAi = new AtomicInteger(rowIndex);
            for (T t : objs) {
                org.apache.poi.ss.usermodel.Row row = sheet.createRow(datasAi.getAndIncrement());
                for (int i = 0; i < fields.size(); i++) {
                    Cell cell = row.createCell(i);
                    for (Field field : fields) {
                        ExcelAttribute ea = field.getAnnotation(ExcelAttribute.class);
                        if (i == ea.sort()) {
                            cell.setCellValue(field.get(t).toString());
                        }
                    }
                }
            }
        }
        fileName = URLEncoder.encode(fileName, "UTF-8");
        response.setContentType("application/octet-stream");
        response.setHeader("content-disposition", "attachment;filename=" + new String(fileName.getBytes("ISO8859-1")));
        response.setHeader("filename", fileName);
        workbook.write(response.getOutputStream());
    }

    /**
     * 不需要模板的导出
     */
    public void export(HttpServletResponse response, List<T> objs, String fileName) throws Exception {
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        List<String> titles = new ArrayList<>();
        for (Field field : fields) {
            ExcelAttribute ea = field.getAnnotation(ExcelAttribute.class);
            titles.add(ea.sort(), ea.name());
        }
        Sheet sheet = workbook.createSheet();
        org.apache.poi.ss.usermodel.Row row = sheet.createRow(0);
        AtomicInteger headersAi = new AtomicInteger();
        for (String title : titles) {
            Cell cell = row.createCell(headersAi.getAndIncrement());
            cell.setCellValue(title);
        }
        AtomicInteger datasAi = new AtomicInteger(1);
        for (T t : objs) {
            org.apache.poi.ss.usermodel.Row dataRow = sheet.createRow(datasAi.getAndIncrement());
            for (int i = 0; i < titles.size(); i++) {
                Cell cell = dataRow.createCell(i);
                for (Field field : fields) {
                    ExcelAttribute ea = field.getAnnotation(ExcelAttribute.class);
                    if (i == ea.sort()) {
//                        if (!Strings.isNullOrEmpty(String.valueOf(field.get(t)))) {
//                            cell.setCellValue(field.get(t).toString());
//                        }
                        cell.setCellValue(String.valueOf(field.get(t)));
                    }
                }
            }

        }
        fileName = URLEncoder.encode(fileName, "UTF-8");
        response.setContentType("application/octet-stream");
        response.setHeader("content-disposition", "attachment;filename=" + new String(fileName.getBytes("ISO8859-1")));
        response.setHeader("filename", fileName);
        workbook.write(response.getOutputStream());
    }

    /**
     * 根据某一行获取单元格样式
     *
     * @param row
     * @return
     */
    public CellStyle[] getTemplateStyles(XSSFRow row) {
        CellStyle[] styles = new CellStyle[row.getLastCellNum()];
        for (int i = 0; i < row.getLastCellNum(); i++) {
            styles[i] = row.getCell(i).getCellStyle();
        }
        return styles;
    }
}
