package com.crazydog.apiutils.poi;

import lombok.SneakyThrows;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFComment;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 当导入数据量非常大, 采用此种方式.
 * @author:
 * @since: 2021-01-27 10:34:55
 */
public class SheetHandler<T> implements XSSFSheetXMLHandler.SheetContentsHandler {
    private Class clazz;
    private List<Field> fields = new ArrayList<>();
    public List<T> list = new ArrayList<>();
    private T entry;
    private final String STRING = "String";
    private final String DATE = "Date";
    private final String INT = "int";
    private final String INTEGER = "Integer";
    private final String DOUBLE = "double";
    private final String DOUBLE_B = "Double";
    private final String ZERO = ".0";
    private int currentRow;
    private int rowNumber;

    public SheetHandler(Class clazz, int rowIndex) {
        this.clazz = clazz;
        this.rowNumber = rowIndex;
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(ExcelAttribute.class)) {
                field.setAccessible(true);
                fields.add(field);
            }
        }
    }

    @SneakyThrows
    @Override
    public void startRow(int rowNum) {
        currentRow = rowNum;
        if (rowNum >= rowNumber) {
            try {
                entry = (T) clazz.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new Exception("上传接收的entry需要无参构造函数");
            }
        }
    }

    @SneakyThrows
    @Override
    public void endRow(int rowNum) {
        if (entry != null) {
            list.add(entry);
        } else if (rowNum >= rowNumber) {
            throw new Exception("第" + rowNum + "行格式错误,数据解析失败");
        }

    }

    @SneakyThrows
    @Override
    public void cell(String cellReference, String formattedValue, XSSFComment comment) {
        if (entry != null) {
            setField(cellReference.substring(0, 1).getBytes()[0] - 65, formattedValue);
        }
    }

    private void setField(int index, String formattedValue) throws Exception {
        for (Field field : fields) {
            ExcelAttribute ea = field.getAnnotation(ExcelAttribute.class);
            if (ea.sort() == index) {
                field.set(entry, covertAttrType(field, formattedValue));
            }
        }
    }

    /**
     * 类型转换 将cell 单元格格式转为 字段类型
     */
    private Object covertAttrType(Field field, String value) throws Exception {
        try {
            String fieldType = field.getType().getSimpleName();
            if (STRING.equals(fieldType)) {
                return value;
            } else if (DATE.equals(fieldType)) {
                return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(value);
            } else if (INT.equals(fieldType) || INTEGER.equals(fieldType)) {
                return Integer.parseInt(value);
            } else if (DOUBLE.equals(fieldType) || DOUBLE_B.equals(fieldType)) {
                return Double.parseDouble(value);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception("第" + currentRow + "行,属性:" + field.getName() + "解析异常");
        }
    }
}
