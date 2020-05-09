/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.HelperClasses;

import fxreportmanagement.Report2.Entitates.CustomerTab;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.FontWeight;

import org.apache.poi.hssf.record.CFRuleRecord.ComparisonOperator;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.FontFormatting;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PatternFormatting;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;

import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExporter {

    private final static Workbook workbook = new XSSFWorkbook();
    private static FileOutputStream fileOutputStream;
    private final static Sheet sheet = workbook.createSheet();

    public static void exportCustomer(CustomerTab customer) {
        
        //Setting Header Style
        Font headerFont = workbook.createFont();
        headerFont.setColor(IndexedColors.RED.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        
        //Creating Cell And Row
        Cell[] cell = new Cell[6];
        Row row = sheet.createRow(0);
        //Merging Row(!Data Assaign)
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 1));
        cell[0] = row.createCell(0);
        cell[0].setCellValue("Logo");
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 2, 5));
        cell[1] = row.createCell(0);
        cell[1].setCellValue("report");
        
        
        //Row 3
        row = sheet.createRow(2);
        for (int i = 0; i < 6; i++) {
            cell[i] = row.createCell(i);
        }

        cell[0].setCellValue("Customer");
        cell[0].setCellStyle(headerCellStyle);//SET STYLE
        cell[1].setCellValue(customer.getCustomer());
        cell[2].setCellValue("Inspection Procedure");
        cell[2].setCellStyle(headerCellStyle);//SET STYLE
        cell[3].setCellValue(customer.getInspectionProcedure());
        cell[4].setCellValue("Page");
        cell[4].setCellStyle(headerCellStyle);//SET STYLE
        cell[5].setCellValue(customer.getPage());

        //Row 4
        row = sheet.createRow(3);
        for (int i = 0; i < 6; i++) {
            cell[i] = row.createCell(i);
        }
        cell[0].setCellValue("ProjectName");
        cell[0].setCellStyle(headerCellStyle);//SET STYLE
        cell[1].setCellValue(customer.getProjectNanme());
        cell[2].setCellValue("Inspection Scope");
        cell[2].setCellStyle(headerCellStyle);//SET STYLE
        cell[3].setCellValue(customer.getInspectionScope());
        cell[4].setCellValue("Report No");
        cell[4].setCellStyle(headerCellStyle);//SET STYLE
        cell[5].setCellValue(customer.getReportNo());

        //Row 5
        row = sheet.createRow(4);
        for (int i = 0; i < 6; i++) {
            cell[i] = row.createCell(i);
        }
        cell[0].setCellValue("Inspection Place");
        cell[0].setCellStyle(headerCellStyle);//SET STYLE
        cell[1].setCellValue(customer.getInspectionPlace());
        cell[2].setCellValue("Drawing No");
        cell[2].setCellStyle(headerCellStyle);//SET STYLE
        cell[3].setCellValue(customer.getDrawingNo());
        cell[4].setCellValue("Report Date");
        cell[4].setCellStyle(headerCellStyle);//SET STYLE
        cell[5].setCellValue(customer.getReportDate());

        //Row 6
        row = sheet.createRow(5);
        for (int i = 0; i < 6; i++) {
            cell[i] = row.createCell(i);
        }
        cell[0].setCellValue("Inspection Standart");
        cell[0].setCellStyle(headerCellStyle);//SET STYLE
        cell[1].setCellValue(customer.getInspectionStandart());
        cell[2].setCellValue("Surface Condition");
        cell[2].setCellStyle(headerCellStyle);//SET STYLE
        cell[3].setCellValue(customer.getSurfaceCondition());
        cell[4].setCellValue("Job Order No");
        cell[4].setCellStyle(headerCellStyle);//SET STYLE
        cell[5].setCellValue(customer.getJobOrderNo());

        //Row 7
        row = sheet.createRow(6);
        for (int i = 0; i < 6; i++) {
            cell[i] = row.createCell(i);
        }
        cell[0].setCellValue("Evaluation Standart");
        cell[0].setCellStyle(headerCellStyle);//SET STYLE
        cell[1].setCellValue(customer.getEvaluationStandart());
        cell[2].setCellValue("Stage Of Examination");
        cell[2].setCellStyle(headerCellStyle);//SET STYLE
        cell[3].setCellValue(customer.getStageOfExamination());
        cell[4].setCellValue("Offer No");
        cell[4].setCellStyle(headerCellStyle);//SET STYLE
        cell[5].setCellValue(customer.getOfferNo());

        for (int colNum = 0; colNum < 6; colNum++) {
            workbook.getSheetAt(0).autoSizeColumn(colNum);
        }

//        Row row = sheet.createRow(2);
//        
//        Cell cell =row.createCell(0);
//        cell.setCellValue("Customer");
//        cell = row.createCell(1);
//        cell.setCellValue(customer.getCustomer());
//        //Row 3
//        sheet.createRow(2).createCell(0).setCellValue("Customer");
//        sheet.createRow(2).createCell(1).setCellValue(customer.getCustomer());
//        sheet.createRow(2).createCell(2).setCellValue("Inspection Procedure");
//        sheet.createRow(2).createCell(3).setCellValue(customer.getInspectionProcedure());
//        sheet.createRow(2).createCell(4).setCellValue("Page");
//        sheet.createRow(2).createCell(5).setCellValue(customer.getPage());
//        //Row 4
//        sheet.createRow(3).createCell(0).setCellValue("ProjectName");
//        sheet.createRow(3).createCell(1).setCellValue(customer.getProjectNanme());
//        sheet.createRow(3).createCell(2).setCellValue("Inspection Scope");
//        sheet.createRow(3).createCell(3).setCellValue(customer.getInspectionScope());
//        sheet.createRow(3).createCell(4).setCellValue("Report No");
//        sheet.createRow(3).createCell(5).setCellValue(customer.getReportNo());
//        //Row 5
//        sheet.createRow(4).createCell(0).setCellValue("Inspection Place");
//        sheet.createRow(4).createCell(1).setCellValue(customer.getInspectionPlace());
//        sheet.createRow(4).createCell(2).setCellValue("Drawing No");
//        sheet.createRow(4).createCell(3).setCellValue(customer.getDrawingNo());
//        sheet.createRow(4).createCell(4).setCellValue("Report Date");
//        sheet.createRow(4).createCell(5).setCellValue(customer.getReportDate());
//        //Row 6
//        sheet.createRow(5).createCell(0).setCellValue("Inspection Standart");
//        sheet.createRow(5).createCell(1).setCellValue(customer.getInspectionStandart());
//        sheet.createRow(5).createCell(2).setCellValue("Surface Condition");
//        sheet.createRow(5).createCell(3).setCellValue(customer.getSurfaceCondition());
//        sheet.createRow(5).createCell(4).setCellValue("Job Order No");
//        sheet.createRow(5).createCell(5).setCellValue(customer.getJobOrderNo()); 
// 
//        //Row 7
//        sheet.createRow(6).createCell(0).setCellValue("Evaluation Standart");
//        sheet.createRow(6).createCell(1).setCellValue(customer.getEvaluationStandart());
//        sheet.createRow(6).createCell(2).setCellValue("Stage Of Examination");
//        sheet.createRow(6).createCell(3).setCellValue(customer.getStageOfExamination());
//        sheet.createRow(6).createCell(4).setCellValue("Offer No");
//        sheet.createRow(6).createCell(5).setCellValue(customer.getOfferNo()); 
        try {
            fileOutputStream = new FileOutputStream("Customer.xlsx");
            workbook.write(fileOutputStream);
            fileOutputStream.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelExporter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExcelExporter.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Succeed");

    }

}
