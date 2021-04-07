package com.crazydog.apiutils.poi;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.InputStream;
import java.util.List;

/**
 * @description: 百万数量的excel导入
 * @author:
 * @since: 2021-01-27 10:33:25
 */
public class ExcelImportMillionUtils {
    private Class clazz;
    private int rowIndex;

    public ExcelImportMillionUtils(Class clazz, int rowIndex) {
        this.clazz = clazz;
        this.rowIndex = rowIndex;
    }

    public List parse(InputStream stream) throws Exception {
        OPCPackage pkg = OPCPackage.open(stream);
        try {
            //2.创建XSSFReader对象
            XSSFReader reader = new XSSFReader(pkg);
            //3.获取SharedStringsTable对象
            SharedStringsTable sst = reader.getSharedStringsTable();
            //4.获取StylesTable对象
            StylesTable styles = reader.getStylesTable();
            //5.创建Sax的XmlReader对象
            XMLReader parser = XMLReaderFactory.createXMLReader();
            SheetHandler sheetHandler = new SheetHandler(clazz, rowIndex);
            //6.设置处理器
            parser.setContentHandler(new XSSFSheetXMLHandler(styles, sst, sheetHandler, false));
            XSSFReader.SheetIterator sheets = (XSSFReader.SheetIterator) reader.getSheetsData();
            //7.逐行读取
            while (sheets.hasNext()) {
                InputStream sheetstream = sheets.next();
                InputSource sheetSource = new InputSource(sheetstream);
                try {
                    parser.parse(sheetSource);
                } finally {
                    sheetstream.close();
                }
            }
            return sheetHandler.list;
        } finally {
            pkg.close();
        }
    }
}
