/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.HelperClasses;

import fxreportmanagement.Report2.Entitates.CustomerTab;
import fxreportmanagement.Report2.Entitates.EquipmentTab;
import fxreportmanagement.Report2.Entitates.InspectionResults;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Vector;
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
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ExcelExporter {

    private final static XSSFWorkbook workbook = new XSSFWorkbook();
    private static FileOutputStream fileOutputStream;
    private final static XSSFSheet sheet = workbook.createSheet();
    private static Row row;
    private final static Cell[] cell = new Cell[14];
    private static CustomerTab customerTab;
    private static EquipmentTab equipmentTab;
    private static Vector<InspectionResults> inspectionResultses;

    private static String operator;
    private static String evaluated;
    private static String confirmation;
    private static String date;

    private static int index = 1;

    public static void setCustomerTab(CustomerTab customerTab) {
        ExcelExporter.customerTab = customerTab;
        System.out.println(ExcelExporter.customerTab.getDrawingNo());
    }

    public static void setEquitmentTab(EquipmentTab equipmentTab) {
        ExcelExporter.equipmentTab = equipmentTab;
        System.out.println(ExcelExporter.equipmentTab.getCurrentType());
    }

    public static void setInspectionResults(Vector<InspectionResults> vector) {

        ExcelExporter.inspectionResultses = vector;
        System.out.println(ExcelExporter.inspectionResultses.get(0).getDefectLoc());
    }

    public static void setOperator(String operator) {
        ExcelExporter.operator = operator;
    }

    public static void setEvaluated(String evaluated) {
        ExcelExporter.evaluated = evaluated;
    }

    public static void setConfirmation(String confirmation) {
        ExcelExporter.confirmation = confirmation;
        System.out.println(ExcelExporter.confirmation);
    }

    public static void setDate(String date) {
        ExcelExporter.date = date;
    }

    private static void setDefaulthWidth() {

        sheet.setDefaultColumnWidth(500);

        sheet.setColumnWidth(3, 200);
        sheet.setColumnWidth(11, 200);
        sheet.setColumnWidth(18, 200);
    }

    public static void exportCustomer() {

        CustomerTab customer = ExcelExporter.customerTab;

        //Row  1
        row = sheet.createRow(0);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }
        cell[0] = row.createCell(0);
        cell[0].setCellValue("Logo");
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 2));
        cell[3].setCellValue("OVERSIGHT INSPECTION AND TRAINING SERVICES");

        sheet.addMergedRegion(new CellRangeAddress(0, 0, 3, 13));
        cell[3].setCellStyle(setHeaderFont());
        //Row 2
        row = sheet.createRow(1);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }
        cell[3].setCellValue("MAGNETIC PARTICLE INSPECTION REPORT");

        sheet.addMergedRegion(new CellRangeAddress(1, 1, 3, 13));
        cell[3].setCellStyle(setHeaderFont());

        //Row 3
        row = sheet.createRow(2);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("Customer");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 1));//MERGE

        cell[2].setCellValue(customer.getCustomer());
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 2, 5));//MERGE

        cell[6].setCellValue("Inspection Procedure");
        cell[6].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 6, 7));//MERGE

        cell[8].setCellValue(customer.getInspectionProcedure());
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 8, 9));//MERGE

        cell[10].setCellValue("Page");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 10, 11));//MERGE

        cell[12].setCellValue(customer.getPage());
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 12, 13));//MERGE

        //Row 4
        row = sheet.createRow(3);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }
        cell[0].setCellValue("ProjectName");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 1));//MERGE

        cell[2].setCellValue(customer.getProjectNanme());
        sheet.addMergedRegion(new CellRangeAddress(3, 3, 2, 5));//MERGE

        cell[6].setCellValue("Inspection Scope");
        cell[6].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(3, 3, 6, 7));//MERGE

        cell[8].setCellValue(customer.getInspectionScope());
        sheet.addMergedRegion(new CellRangeAddress(3, 3, 8, 9));//MERGE

        cell[10].setCellValue("Report No");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(3, 3, 10, 11));//MERGE

        cell[12].setCellValue(customer.getReportNo());
        sheet.addMergedRegion(new CellRangeAddress(3, 3, 12, 13));//MERGE

        //Row 5
        row = sheet.createRow(4);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }
        cell[0].setCellValue("Inspection Place");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 0, 1));//MERGE

        cell[2].setCellValue(customer.getInspectionPlace());
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 2, 5));//MERGE

        cell[6].setCellValue("Drawing No");
        cell[6].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 6, 7));//MERGE

        cell[8].setCellValue(customer.getDrawingNo());
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 8, 9));//MERGE

        cell[10].setCellValue("Report Date");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 10, 11));//MERGE

        cell[12].setCellValue(customer.getReportDate());
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 12, 13));//MERGE
        //Row 6
        row = sheet.createRow(5);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }
        cell[0].setCellValue("Inspection Standart");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 0, 1));//MERGE

        cell[2].setCellValue(customer.getInspectionStandart());
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 2, 5));//MERGE

        cell[6].setCellValue("Surface Condition");
        cell[6].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 6, 7));//MERGE

        cell[8].setCellValue(customer.getSurfaceCondition());
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 8, 9));//MERGE

        cell[10].setCellValue("Job Order No");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 10, 11));//MERGE

        cell[12].setCellValue(customer.getJobOrderNo());
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 12, 13));//MERGE
        //Row 7
        row = sheet.createRow(6);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("Evaluation Standart");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(6, 6, 0, 1));//MERGE

        cell[2].setCellValue(customer.getEvaluationStandart());
        sheet.addMergedRegion(new CellRangeAddress(6, 6, 2, 5));//MERGE

        cell[6].setCellValue("Stage Of Examination");
        cell[6].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(6, 6, 6, 7));//MERGE

        cell[8].setCellValue(customer.getStageOfExamination());
        sheet.addMergedRegion(new CellRangeAddress(6, 6, 8, 9));//MERGE

        cell[10].setCellValue("Offer No");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(6, 6, 10, 11));//MERGE

        cell[12].setCellValue(customer.getOfferNo());
        sheet.addMergedRegion(new CellRangeAddress(6, 6, 12, 13));//MERGE

        //Auto Size Collum
//        for (int colNum = 0; colNum < 14; colNum++) {
//            workbook.getSheetAt(0).autoSizeColumn(colNum);
//        }
//        createXlsxFile("Customer");
    }

    public static void exportEquipment() {
        EquipmentTab equipment = ExcelExporter.equipmentTab;
        //Row 8
        row = sheet.createRow(7);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }
        cell[0].setCellValue("Equipment");
        cell[0].setCellStyle(setHeaderFont());
        sheet.addMergedRegion(new CellRangeAddress(7, 7, 0, 13));

        //Row 9
        row = sheet.createRow(8);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("Pole Distance");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(8, 8, 0, 1));//MERGE

        cell[2].setCellValue(equipment.getPoleDistance());
        sheet.addMergedRegion(new CellRangeAddress(8, 8, 2, 4));//MERGE

        cell[5].setCellValue("Stage Of Examination");
        cell[5].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(8, 8, 5, 6));//MERGE

        cell[7].setCellValue(equipment.getExaminationArea());
        sheet.addMergedRegion(new CellRangeAddress(8, 8, 7, 9));//MERGE

        cell[10].setCellValue("Surface Temperature");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(8, 8, 10, 11));//MERGE

        cell[12].setCellValue(equipment.getSurfaceTemparature());
        sheet.addMergedRegion(new CellRangeAddress(8, 8, 12, 13));//MERGE

        //Row 10
        row = sheet.createRow(9);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("Equipment");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(9, 9, 0, 1));//MERGE

        cell[2].setCellValue(equipment.getEquipment());
        sheet.addMergedRegion(new CellRangeAddress(9, 9, 2, 4));//MERGE

        cell[5].setCellValue("Current Type");
        cell[5].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(9, 9, 5, 6));//MERGE

        cell[7].setCellValue(equipment.getCurrentType());
        sheet.addMergedRegion(new CellRangeAddress(9, 9, 7, 9));//MERGE

        cell[10].setCellValue("Gauss Field Strength");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(9, 10, 10, 11));//MERGE

        cell[12].setCellValue(equipment.getGaussFieldStrength());
        sheet.addMergedRegion(new CellRangeAddress(9, 10, 12, 13));//Merge Cell

        //Row 11
        row = sheet.createRow(10);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("Mp Carrier Medium");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(10, 10, 0, 1));//MERGE

        cell[2].setCellValue(equipment.getMpCarrierMedium());
        sheet.addMergedRegion(new CellRangeAddress(10, 10, 2, 4));//MERGE

        cell[5].setCellValue("Luxmeter");
        cell[5].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(10, 10, 5, 6));//MERGE

        cell[7].setCellValue(equipment.getLuxmeter());
        sheet.addMergedRegion(new CellRangeAddress(10, 10, 7, 9));//MERGE

        //Row 12
        row = sheet.createRow(11);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("Mag Tech");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(11, 11, 0, 1));//MERGE

        cell[2].setCellValue(equipment.getMagTech());
        sheet.addMergedRegion(new CellRangeAddress(11, 11, 2, 4));//MERGE

        cell[5].setCellValue("Test Medium");
        cell[5].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(11, 11, 5, 6));//MERGE

        cell[7].setCellValue(equipment.getTestMedium());
        sheet.addMergedRegion(new CellRangeAddress(11, 11, 7, 9));//MERGE

        cell[10].setCellValue("Surface Condition");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(11, 11, 10, 11));//MERGE

        cell[12].setCellValue(equipment.getSurfaceCondition());
        sheet.addMergedRegion(new CellRangeAddress(11, 11, 12, 13));//MERGE

        //Row 13
        row = sheet.createRow(12);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("UV Light Intencity");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(12, 12, 0, 1));//MERGE

        cell[2].setCellValue(equipment.getUvLightIntesity());
        sheet.addMergedRegion(new CellRangeAddress(12, 12, 2, 4));//MERGE

        cell[5].setCellValue("Demagnetization");
        cell[5].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(12, 12, 5, 6));//MERGE

        cell[7].setCellValue(equipment.getDemagnetization());
        sheet.addMergedRegion(new CellRangeAddress(12, 12, 7, 9));//MERGE

        cell[10].setCellValue("Identification of Light Equipment");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(12, 12, 10, 11));//MERGE

        cell[12].setCellValue(equipment.getIdenticationOfLightEquipment());
        sheet.addMergedRegion(new CellRangeAddress(12, 12, 12, 13));//MERGE

        //Row 14
        row = sheet.createRow(13);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("Distance Of Light");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(13, 13, 0, 1));//MERGE

        cell[2].setCellValue(equipment.getDistanceOfLight());
        sheet.addMergedRegion(new CellRangeAddress(13, 13, 2, 4));//MERGE

        cell[5].setCellValue("Heat Treatment");
        cell[5].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(13, 13, 5, 6));//MERGE

        cell[7].setCellValue(equipment.getHeatTreatment());
        sheet.addMergedRegion(new CellRangeAddress(13, 13, 7, 9));//MERGE

        cell[10].setCellValue("Lifting Test Date / Number");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(13, 13, 10, 11));//MERGE

        cell[12].setCellValue(equipment.getLiftingTestDateNo());
        sheet.addMergedRegion(new CellRangeAddress(13, 13, 12, 13));//MERGE

        //Row 15-19
        row = sheet.createRow(14);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());

        }
        cell[0].setCellValue("Butt weld");

        cell[3].setCellValue("Fillet Weld");

        cell[7].setCellValue("Location of Discontinuity");
        cell[7].setCellStyle(setHeaderFont());

        //Row 16
        row = sheet.createRow(15);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());

        }
        cell[7].setCellValue("BM");
        cell[7].setCellStyle(setHeaderFont());
        cell[9].setCellValue("Base Metal");
        cell[9].setCellStyle(setHeaderFont());

        //Row 17
        row = sheet.createRow(16);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());

        }

        cell[7].setCellValue("BM");
        cell[7].setCellStyle(setHeaderFont());
        cell[9].setCellValue("Base Metal");
        cell[9].setCellStyle(setHeaderFont());

        //Row 18
        row = sheet.createRow(17);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());

        }

        cell[7].setCellValue("HAZ");
        cell[7].setCellStyle(setHeaderFont());
        cell[9].setCellValue("Heat affected zone");
        cell[9].setCellStyle(setHeaderFont());

        //Row 19
        row = sheet.createRow(18);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());

        }

        cell[7].setCellValue("W");
        cell[7].setCellStyle(setHeaderFont());
        cell[9].setCellValue("Weld");
        cell[9].setCellStyle(setHeaderFont());

        try {
            addImage(14, 19, 0, 3);
        } catch (IOException ex) {
            Logger.getLogger(ExcelExporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        sheet.addMergedRegion(new CellRangeAddress(14, 18, 0, 2));//Merge Cell
        sheet.addMergedRegion(new CellRangeAddress(14, 18, 3, 6));//Merge Cell
        sheet.addMergedRegion(new CellRangeAddress(14, 14, 7, 13));//Merge Cell

        sheet.addMergedRegion(new CellRangeAddress(15, 15, 7, 8));//Merge Cell
        sheet.addMergedRegion(new CellRangeAddress(15, 15, 9, 13));//Merge Cell

        sheet.addMergedRegion(new CellRangeAddress(16, 16, 7, 8));//Merge Cell
        sheet.addMergedRegion(new CellRangeAddress(16, 16, 9, 13));//Merge Cell

        sheet.addMergedRegion(new CellRangeAddress(17, 17, 7, 8));//Merge Cell
        sheet.addMergedRegion(new CellRangeAddress(17, 17, 9, 13));//Merge Cell

        sheet.addMergedRegion(new CellRangeAddress(18, 18, 7, 8));//Merge Cell
        sheet.addMergedRegion(new CellRangeAddress(18, 18, 9, 13));//Merge Cell

        //Row 20
        row = sheet.createRow(19);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("Standart Derivations");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(19, 19, 0, 1));//Merge Cell
        cell[2].setCellValue(equipment.getStandartDevitions());
        sheet.addMergedRegion(new CellRangeAddress(19, 19, 2, 13));//Merge Cell

        //Row 21
        row = sheet.createRow(20);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("Inspection Dates");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(20, 20, 0, 1));//Merge Cell
        cell[2].setCellValue(equipment.getInspectionDates());
        sheet.addMergedRegion(new CellRangeAddress(20, 20, 2, 13));//Merge Cell

        //Row 22
        row = sheet.createRow(21);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("Description ");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(21, 21, 0, 1));//Merge Cell
        cell[2].setCellValue(equipment.getDescription());
        sheet.addMergedRegion(new CellRangeAddress(21, 21, 2, 13));//Merge Cell

//        Auto Size Collum
//        for (int colNum = 0; colNum < 14; colNum++) {
//           
//           sheet.autoSizeColumn(colNum, true);
//           
//            
//      }
        createXlsxFile("Equipment");
    }

    public static void exportGUI() {

        CustomerTab customer = ExcelExporter.customerTab;

        //Row  1
        row = sheet.createRow(0);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }
        cell[0] = row.createCell(0);
        cell[0].setCellValue("Logo");
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 2));
        cell[3].setCellValue("OVERSIGHT INSPECTION AND TRAINING SERVICES");

        sheet.addMergedRegion(new CellRangeAddress(0, 0, 3, 13));
        cell[3].setCellStyle(setHeaderFont());
        //Row 2
        row = sheet.createRow(1);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }
        cell[3].setCellValue("MAGNETIC PARTICLE INSPECTION REPORT");

        sheet.addMergedRegion(new CellRangeAddress(1, 1, 3, 13));
        cell[3].setCellStyle(setHeaderFont());

        //Row 3
        row = sheet.createRow(2);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("Customer");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 1));//MERGE

        cell[2].setCellValue(customer.getCustomer());
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 2, 5));//MERGE

        cell[6].setCellValue("Inspection Procedure");
        cell[6].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 6, 7));//MERGE

        cell[8].setCellValue(customer.getInspectionProcedure());
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 8, 9));//MERGE

        cell[10].setCellValue("Page");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 10, 11));//MERGE

        cell[12].setCellValue(customer.getPage());
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 12, 13));//MERGE

        //Row 4
        row = sheet.createRow(3);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }
        cell[0].setCellValue("ProjectName");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 1));//MERGE

        cell[2].setCellValue(customer.getProjectNanme());
        sheet.addMergedRegion(new CellRangeAddress(3, 3, 2, 5));//MERGE

        cell[6].setCellValue("Inspection Scope");
        cell[6].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(3, 3, 6, 7));//MERGE

        cell[8].setCellValue(customer.getInspectionScope());
        sheet.addMergedRegion(new CellRangeAddress(3, 3, 8, 9));//MERGE

        cell[10].setCellValue("Report No");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(3, 3, 10, 11));//MERGE

        cell[12].setCellValue(customer.getReportNo());
        sheet.addMergedRegion(new CellRangeAddress(3, 3, 12, 13));//MERGE

        //Row 5
        row = sheet.createRow(4);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }
        cell[0].setCellValue("Inspection Place");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 0, 1));//MERGE

        cell[2].setCellValue(customer.getInspectionPlace());
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 2, 5));//MERGE

        cell[6].setCellValue("Drawing No");
        cell[6].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 6, 7));//MERGE

        cell[8].setCellValue(customer.getDrawingNo());
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 8, 9));//MERGE

        cell[10].setCellValue("Report Date");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 10, 11));//MERGE

        cell[12].setCellValue(customer.getReportDate());
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 12, 13));//MERGE
        //Row 6
        row = sheet.createRow(5);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }
        cell[0].setCellValue("Inspection Standart");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 0, 1));//MERGE

        cell[2].setCellValue(customer.getInspectionStandart());
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 2, 5));//MERGE

        cell[6].setCellValue("Surface Condition");
        cell[6].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 6, 7));//MERGE

        cell[8].setCellValue(customer.getSurfaceCondition());
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 8, 9));//MERGE

        cell[10].setCellValue("Job Order No");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 10, 11));//MERGE

        cell[12].setCellValue(customer.getJobOrderNo());
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 12, 13));//MERGE
        //Row 7
        row = sheet.createRow(6);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("Evaluation Standart");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(6, 6, 0, 1));//MERGE

        cell[2].setCellValue(customer.getEvaluationStandart());
        sheet.addMergedRegion(new CellRangeAddress(6, 6, 2, 5));//MERGE

        cell[6].setCellValue("Stage Of Examination");
        cell[6].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(6, 6, 6, 7));//MERGE

        cell[8].setCellValue(customer.getStageOfExamination());
        sheet.addMergedRegion(new CellRangeAddress(6, 6, 8, 9));//MERGE

        cell[10].setCellValue("Offer No");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(6, 6, 10, 11));//MERGE

        cell[12].setCellValue(customer.getOfferNo());
        sheet.addMergedRegion(new CellRangeAddress(6, 6, 12, 13));//MERGE

        //---------------------Equipment Part---------------------------------//
        EquipmentTab equipment = ExcelExporter.equipmentTab;
        //Row 8
        row = sheet.createRow(7);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }
        cell[0].setCellValue("Equipment");
        cell[0].setCellStyle(setHeaderFont());
        sheet.addMergedRegion(new CellRangeAddress(7, 7, 0, 13));

        //Row 9
        row = sheet.createRow(8);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("Pole Distance");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(8, 8, 0, 1));//MERGE

        cell[2].setCellValue(equipment.getPoleDistance());
        sheet.addMergedRegion(new CellRangeAddress(8, 8, 2, 4));//MERGE

        cell[5].setCellValue("Stage Of Examination");
        cell[5].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(8, 8, 5, 6));//MERGE

        cell[7].setCellValue(equipment.getExaminationArea());
        sheet.addMergedRegion(new CellRangeAddress(8, 8, 7, 9));//MERGE

        cell[10].setCellValue("Surface Temperature");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(8, 8, 10, 11));//MERGE

        cell[12].setCellValue(equipment.getSurfaceTemparature());
        sheet.addMergedRegion(new CellRangeAddress(8, 8, 12, 13));//MERGE

        //Row 10
        row = sheet.createRow(9);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("Equipment");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(9, 9, 0, 1));//MERGE

        cell[2].setCellValue(equipment.getEquipment());
        sheet.addMergedRegion(new CellRangeAddress(9, 9, 2, 4));//MERGE

        cell[5].setCellValue("Current Type");
        cell[5].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(9, 9, 5, 6));//MERGE

        cell[7].setCellValue(equipment.getCurrentType());
        sheet.addMergedRegion(new CellRangeAddress(9, 9, 7, 9));//MERGE

        cell[10].setCellValue("Gauss Field Strength");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(9, 10, 10, 11));//MERGE

        cell[12].setCellValue(equipment.getGaussFieldStrength());
        sheet.addMergedRegion(new CellRangeAddress(9, 10, 12, 13));//Merge Cell

        //Row 11
        row = sheet.createRow(10);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("Mp Carrier Medium");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(10, 10, 0, 1));//MERGE

        cell[2].setCellValue(equipment.getMpCarrierMedium());
        sheet.addMergedRegion(new CellRangeAddress(10, 10, 2, 4));//MERGE

        cell[5].setCellValue("Luxmeter");
        cell[5].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(10, 10, 5, 6));//MERGE

        cell[7].setCellValue(equipment.getLuxmeter());
        sheet.addMergedRegion(new CellRangeAddress(10, 10, 7, 9));//MERGE

        //Row 12
        row = sheet.createRow(11);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("Mag Tech");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(11, 11, 0, 1));//MERGE

        cell[2].setCellValue(equipment.getMagTech());
        sheet.addMergedRegion(new CellRangeAddress(11, 11, 2, 4));//MERGE

        cell[5].setCellValue("Test Medium");
        cell[5].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(11, 11, 5, 6));//MERGE

        cell[7].setCellValue(equipment.getTestMedium());
        sheet.addMergedRegion(new CellRangeAddress(11, 11, 7, 9));//MERGE

        cell[10].setCellValue("Surface Condition");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(11, 11, 10, 11));//MERGE

        cell[12].setCellValue(equipment.getSurfaceCondition());
        sheet.addMergedRegion(new CellRangeAddress(11, 11, 12, 13));//MERGE

        //Row 13
        row = sheet.createRow(12);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("UV Light Intencity");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(12, 12, 0, 1));//MERGE

        cell[2].setCellValue(equipment.getUvLightIntesity());
        sheet.addMergedRegion(new CellRangeAddress(12, 12, 2, 4));//MERGE

        cell[5].setCellValue("Demagnetization");
        cell[5].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(12, 12, 5, 6));//MERGE

        cell[7].setCellValue(equipment.getDemagnetization());
        sheet.addMergedRegion(new CellRangeAddress(12, 12, 7, 9));//MERGE

        cell[10].setCellValue("Identification of Light Equipment");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(12, 12, 10, 11));//MERGE

        cell[12].setCellValue(equipment.getIdenticationOfLightEquipment());
        sheet.addMergedRegion(new CellRangeAddress(12, 12, 12, 13));//MERGE

        //Row 14
        row = sheet.createRow(13);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("Distance Of Light");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(13, 13, 0, 1));//MERGE

        cell[2].setCellValue(equipment.getDistanceOfLight());
        sheet.addMergedRegion(new CellRangeAddress(13, 13, 2, 4));//MERGE

        cell[5].setCellValue("Heat Treatment");
        cell[5].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(13, 13, 5, 6));//MERGE

        cell[7].setCellValue(equipment.getHeatTreatment());
        sheet.addMergedRegion(new CellRangeAddress(13, 13, 7, 9));//MERGE

        cell[10].setCellValue("Lifting Test Date / Number");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(13, 13, 10, 11));//MERGE

        cell[12].setCellValue(equipment.getLiftingTestDateNo());
        sheet.addMergedRegion(new CellRangeAddress(13, 13, 12, 13));//MERGE

        //Row 15-19
        row = sheet.createRow(14);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());

        }
        cell[0].setCellValue("Butt weld");

        cell[3].setCellValue("Fillet Weld");

        cell[7].setCellValue("Location of Discontinuity");
        cell[7].setCellStyle(setHeaderFont());

        //Row 16
        row = sheet.createRow(15);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());

        }
        cell[7].setCellValue("BM");
        cell[7].setCellStyle(setHeaderFont());
        cell[9].setCellValue("Base Metal");
        cell[9].setCellStyle(setHeaderFont());

        //Row 17
        row = sheet.createRow(16);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());

        }

        cell[7].setCellValue("BM");
        cell[7].setCellStyle(setHeaderFont());
        cell[9].setCellValue("Base Metal");
        cell[9].setCellStyle(setHeaderFont());

        //Row 18
        row = sheet.createRow(17);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());

        }

        cell[7].setCellValue("HAZ");
        cell[7].setCellStyle(setHeaderFont());
        cell[9].setCellValue("Heat affected zone");
        cell[9].setCellStyle(setHeaderFont());

        //Row 19
        row = sheet.createRow(18);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());

        }

        cell[7].setCellValue("W");
        cell[7].setCellStyle(setHeaderFont());
        cell[9].setCellValue("Weld");
        cell[9].setCellStyle(setHeaderFont());

//        try {
//            addImage(14, 19, 0, 3);
//        } catch (IOException ex) {
//            Logger.getLogger(ExcelExporter.class.getName()).log(Level.SEVERE, null, ex);
//        }
        sheet.addMergedRegion(new CellRangeAddress(14, 18, 0, 2));//Merge Cell
        sheet.addMergedRegion(new CellRangeAddress(14, 18, 3, 6));//Merge Cell
        sheet.addMergedRegion(new CellRangeAddress(14, 14, 7, 13));//Merge Cell

        sheet.addMergedRegion(new CellRangeAddress(15, 15, 7, 8));//Merge Cell
        sheet.addMergedRegion(new CellRangeAddress(15, 15, 9, 13));//Merge Cell

        sheet.addMergedRegion(new CellRangeAddress(16, 16, 7, 8));//Merge Cell
        sheet.addMergedRegion(new CellRangeAddress(16, 16, 9, 13));//Merge Cell

        sheet.addMergedRegion(new CellRangeAddress(17, 17, 7, 8));//Merge Cell
        sheet.addMergedRegion(new CellRangeAddress(17, 17, 9, 13));//Merge Cell

        sheet.addMergedRegion(new CellRangeAddress(18, 18, 7, 8));//Merge Cell
        sheet.addMergedRegion(new CellRangeAddress(18, 18, 9, 13));//Merge Cell

        //Row 20
        row = sheet.createRow(19);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("Standart Derivations");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(19, 19, 0, 1));//Merge Cell
        cell[2].setCellValue(equipment.getStandartDevitions());
        sheet.addMergedRegion(new CellRangeAddress(19, 19, 2, 13));//Merge Cell

        //Row 21
        row = sheet.createRow(20);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("Inspection Dates");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(20, 20, 0, 1));//Merge Cell
        cell[2].setCellValue(equipment.getInspectionDates());
        sheet.addMergedRegion(new CellRangeAddress(20, 20, 2, 13));//Merge Cell

        //Row 22
        row = sheet.createRow(21);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }

        cell[0].setCellValue("Description ");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(21, 21, 0, 1));//Merge Cell
        cell[2].setCellValue(equipment.getDescription());
        sheet.addMergedRegion(new CellRangeAddress(21, 21, 2, 13));//Merge Cell

        //--------------------End Of Equipment Part---------------------------//
        //Row 23
        row = sheet.createRow(22);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }
        cell[0].setCellValue("Inspection Results");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(22, 22, 0, 13));//Merge Cell

        //Row 24
        row = sheet.createRow(23);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }
        cell[0].setCellValue("Serial No");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE

        cell[1].setCellValue("Weld/Piece No");
        cell[1].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(23, 23, 1, 3));//Merge Cell 3

        cell[4].setCellValue("Test Length");
        cell[4].setCellStyle(setHeaderFont());//SET STYLE

        cell[5].setCellValue("Welding Process");
        cell[5].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(23, 23, 5, 6));//Merge Cell 2

        cell[7].setCellValue("Thickness");
        cell[7].setCellStyle(setHeaderFont());//SET STYLE

        cell[8].setCellValue("Diaemter");
        cell[8].setCellStyle(setHeaderFont());//SET STYLE

        cell[9].setCellValue("Defect Type");
        cell[9].setCellStyle(setHeaderFont());//SET STYLE

        cell[10].setCellValue("Defect Loc");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(23, 23, 10, 12));//Merge Cell

        cell[13].setCellValue("Result");
        cell[13].setCellStyle(setHeaderFont());//SET STYLE

        //ROW 25
        int rowNo = 24;
        row = sheet.createRow(rowNo);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
        }

        if (verifyVector(inspectionResultses, index)) {

            for (int i = 0; i < 14; i++) {

                cell[i].setCellStyle(setBorder());
            }

            cell[0].setCellValue(index);

            cell[1].setCellValue(inspectionResultses.get(index - 1).getWeldNo());

            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 1, 3));//Merge Cell

            cell[4].setCellValue(inspectionResultses.get(index - 1).getTestLength());

            cell[5].setCellValue(inspectionResultses.get(index - 1).getWeldingProcess());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 5, 6));//Merge Cell

            cell[7].setCellValue(inspectionResultses.get(index - 1).getThickness());

            cell[8].setCellValue(inspectionResultses.get(index - 1).getDiameter());

            cell[9].setCellValue(inspectionResultses.get(index - 1).getDefectType());

            cell[10].setCellValue(inspectionResultses.get(index - 1).getDefectLoc());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 10, 12));//Merge Cell

            cell[13].setCellValue(inspectionResultses.get(index - 1).getResult());

            index++;
        } else {
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 0, 13));//Default Merge Cell
        }

        //ROW 26
        rowNo = 25;
        row = sheet.createRow(rowNo);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
        }

        if (verifyVector(inspectionResultses, index)) {

            for (int i = 0; i < 14; i++) {

                cell[i].setCellStyle(setBorder());
            }

            cell[0].setCellValue(index);

            cell[1].setCellValue(inspectionResultses.get(index - 1).getWeldNo());

            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 1, 3));//Merge Cell

            cell[4].setCellValue(inspectionResultses.get(index - 1).getTestLength());

            cell[5].setCellValue(inspectionResultses.get(index - 1).getWeldingProcess());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 5, 6));//Merge Cell

            cell[7].setCellValue(inspectionResultses.get(index - 1).getThickness());

            cell[8].setCellValue(inspectionResultses.get(index - 1).getDiameter());

            cell[9].setCellValue(inspectionResultses.get(index - 1).getDefectType());

            cell[10].setCellValue(inspectionResultses.get(index - 1).getDefectLoc());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 10, 12));//Merge Cell

            cell[13].setCellValue(inspectionResultses.get(index - 1).getResult());

            index++;
        } else {
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 0, 13));//Default Merge Cell
        }

        //ROW 27
        rowNo = 26;

        row = sheet.createRow(rowNo);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
        }

        if (verifyVector(inspectionResultses, index)) {

            for (int i = 0; i < 14; i++) {

                cell[i].setCellStyle(setBorder());
            }

            cell[0].setCellValue(index);

            cell[1].setCellValue(inspectionResultses.get(index - 1).getWeldNo());

            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 1, 3));//Merge Cell

            cell[4].setCellValue(inspectionResultses.get(index - 1).getTestLength());

            cell[5].setCellValue(inspectionResultses.get(index - 1).getWeldingProcess());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 5, 6));//Merge Cell

            cell[7].setCellValue(inspectionResultses.get(index - 1).getThickness());

            cell[8].setCellValue(inspectionResultses.get(index - 1).getDiameter());

            cell[9].setCellValue(inspectionResultses.get(index - 1).getDefectType());

            cell[10].setCellValue(inspectionResultses.get(index - 1).getDefectLoc());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 10, 12));//Merge Cell

            cell[13].setCellValue(inspectionResultses.get(index - 1).getResult());

            index++;
        } else {
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 0, 13));//Default Merge Cell
        }

        //ROW 28
        rowNo = 27;
        row = sheet.createRow(rowNo);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
        }

        if (verifyVector(inspectionResultses, index)) {

            for (int i = 0; i < 14; i++) {

                cell[i].setCellStyle(setBorder());
            }

            cell[0].setCellValue(index);

            cell[1].setCellValue(inspectionResultses.get(index - 1).getWeldNo());

            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 1, 3));//Merge Cell

            cell[4].setCellValue(inspectionResultses.get(index - 1).getTestLength());

            cell[5].setCellValue(inspectionResultses.get(index - 1).getWeldingProcess());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 5, 6));//Merge Cell

            cell[7].setCellValue(inspectionResultses.get(index - 1).getThickness());

            cell[8].setCellValue(inspectionResultses.get(index - 1).getDiameter());

            cell[9].setCellValue(inspectionResultses.get(index - 1).getDefectType());

            cell[10].setCellValue(inspectionResultses.get(index - 1).getDefectLoc());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 10, 12));//Merge Cell

            cell[13].setCellValue(inspectionResultses.get(index - 1).getResult());

            index++;
        } else {
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 0, 13));//Default Merge Cell
        }

        //ROW 29
        rowNo = 28;

        row = sheet.createRow(rowNo);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
        }

        if (verifyVector(inspectionResultses, index)) {

            for (int i = 0; i < 14; i++) {

                cell[i].setCellStyle(setBorder());
            }

            cell[0].setCellValue(index);

            cell[1].setCellValue(inspectionResultses.get(index - 1).getWeldNo());

            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 1, 3));//Merge Cell

            cell[4].setCellValue(inspectionResultses.get(index - 1).getTestLength());

            cell[5].setCellValue(inspectionResultses.get(index - 1).getWeldingProcess());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 5, 6));//Merge Cell

            cell[7].setCellValue(inspectionResultses.get(index - 1).getThickness());

            cell[8].setCellValue(inspectionResultses.get(index - 1).getDiameter());

            cell[9].setCellValue(inspectionResultses.get(index - 1).getDefectType());

            cell[10].setCellValue(inspectionResultses.get(index - 1).getDefectLoc());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 10, 12));//Merge Cell

            cell[13].setCellValue(inspectionResultses.get(index - 1).getResult());

            index++;
        } else {
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 0, 13));//Default Merge Cell
        }

        //ROW 30
        rowNo = 29;
        row = sheet.createRow(rowNo);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
        }

        if (verifyVector(inspectionResultses, index)) {

            for (int i = 0; i < 14; i++) {

                cell[i].setCellStyle(setBorder());
            }

            cell[0].setCellValue(index);

            cell[1].setCellValue(inspectionResultses.get(index - 1).getWeldNo());

            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 1, 3));//Merge Cell

            cell[4].setCellValue(inspectionResultses.get(index - 1).getTestLength());

            cell[5].setCellValue(inspectionResultses.get(index - 1).getWeldingProcess());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 5, 6));//Merge Cell

            cell[7].setCellValue(inspectionResultses.get(index - 1).getThickness());

            cell[8].setCellValue(inspectionResultses.get(index - 1).getDiameter());

            cell[9].setCellValue(inspectionResultses.get(index - 1).getDefectType());

            cell[10].setCellValue(inspectionResultses.get(index - 1).getDefectLoc());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 10, 12));//Merge Cell

            cell[13].setCellValue(inspectionResultses.get(index - 1).getResult());

            index++;
        } else {
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 0, 13));//Default Merge Cell
        }

        //ROW 31
        rowNo = 30;
        row = sheet.createRow(rowNo);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
        }

        if (verifyVector(inspectionResultses, index)) {

            for (int i = 0; i < 14; i++) {

                cell[i].setCellStyle(setBorder());
            }

            cell[0].setCellValue(index);

            cell[1].setCellValue(inspectionResultses.get(index - 1).getWeldNo());

            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 1, 3));//Merge Cell

            cell[4].setCellValue(inspectionResultses.get(index - 1).getTestLength());

            cell[5].setCellValue(inspectionResultses.get(index - 1).getWeldingProcess());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 5, 6));//Merge Cell

            cell[7].setCellValue(inspectionResultses.get(index - 1).getThickness());

            cell[8].setCellValue(inspectionResultses.get(index - 1).getDiameter());

            cell[9].setCellValue(inspectionResultses.get(index - 1).getDefectType());

            cell[10].setCellValue(inspectionResultses.get(index - 1).getDefectLoc());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 10, 12));//Merge Cell

            cell[13].setCellValue(inspectionResultses.get(index - 1).getResult());

            index++;
        } else {
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 0, 13));//Default Merge Cell
        }

        //ROW 32
        rowNo = 31;
        row = sheet.createRow(rowNo);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
        }

        if (verifyVector(inspectionResultses, index)) {

            for (int i = 0; i < 14; i++) {

                cell[i].setCellStyle(setBorder());
            }

            cell[0].setCellValue(index);

            cell[1].setCellValue(inspectionResultses.get(index - 1).getWeldNo());

            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 1, 3));//Merge Cell

            cell[4].setCellValue(inspectionResultses.get(index - 1).getTestLength());

            cell[5].setCellValue(inspectionResultses.get(index - 1).getWeldingProcess());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 5, 6));//Merge Cell

            cell[7].setCellValue(inspectionResultses.get(index - 1).getThickness());

            cell[8].setCellValue(inspectionResultses.get(index - 1).getDiameter());

            cell[9].setCellValue(inspectionResultses.get(index - 1).getDefectType());

            cell[10].setCellValue(inspectionResultses.get(index - 1).getDefectLoc());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 10, 12));//Merge Cell

            cell[13].setCellValue(inspectionResultses.get(index - 1).getResult());

            index++;
        } else {
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 0, 13));//Default Merge Cell
        }

        //ROW 33
        rowNo = 32;
        row = sheet.createRow(rowNo);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
        }

        if (verifyVector(inspectionResultses, index)) {

            for (int i = 0; i < 14; i++) {

                cell[i].setCellStyle(setBorder());
            }

            cell[0].setCellValue(index);

            cell[1].setCellValue(inspectionResultses.get(index - 1).getWeldNo());

            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 1, 3));//Merge Cell

            cell[4].setCellValue(inspectionResultses.get(index - 1).getTestLength());

            cell[5].setCellValue(inspectionResultses.get(index - 1).getWeldingProcess());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 5, 6));//Merge Cell

            cell[7].setCellValue(inspectionResultses.get(index - 1).getThickness());

            cell[8].setCellValue(inspectionResultses.get(index - 1).getDiameter());

            cell[9].setCellValue(inspectionResultses.get(index - 1).getDefectType());

            cell[10].setCellValue(inspectionResultses.get(index - 1).getDefectLoc());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 10, 12));//Merge Cell

            cell[13].setCellValue(inspectionResultses.get(index - 1).getResult());

            index++;
        } else {
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 0, 13));//Default Merge Cell
        }
        //ROW 34
        rowNo = 33;
        row = sheet.createRow(rowNo);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
        }

        if (verifyVector(inspectionResultses, index)) {

            for (int i = 0; i < 14; i++) {

                cell[i].setCellStyle(setBorder());
            }

            cell[0].setCellValue(index);

            cell[1].setCellValue(inspectionResultses.get(index - 1).getWeldNo());

            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 1, 3));//Merge Cell

            cell[4].setCellValue(inspectionResultses.get(index - 1).getTestLength());

            cell[5].setCellValue(inspectionResultses.get(index - 1).getWeldingProcess());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 5, 6));//Merge Cell

            cell[7].setCellValue(inspectionResultses.get(index - 1).getThickness());

            cell[8].setCellValue(inspectionResultses.get(index - 1).getDiameter());

            cell[9].setCellValue(inspectionResultses.get(index - 1).getDefectType());

            cell[10].setCellValue(inspectionResultses.get(index - 1).getDefectLoc());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 10, 12));//Merge Cell

            cell[13].setCellValue(inspectionResultses.get(index - 1).getResult());

            index++;
        } else {
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 0, 13));//Default Merge Cell
        }
        //ROW 35
        rowNo = 34;
        row = sheet.createRow(rowNo);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
        }

        if (verifyVector(inspectionResultses, index)) {

            for (int i = 0; i < 14; i++) {

                cell[i].setCellStyle(setBorder());
            }

            cell[0].setCellValue(index);

            cell[1].setCellValue(inspectionResultses.get(index - 1).getWeldNo());

            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 1, 3));//Merge Cell

            cell[4].setCellValue(inspectionResultses.get(index - 1).getTestLength());

            cell[5].setCellValue(inspectionResultses.get(index - 1).getWeldingProcess());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 5, 6));//Merge Cell

            cell[7].setCellValue(inspectionResultses.get(index - 1).getThickness());

            cell[8].setCellValue(inspectionResultses.get(index - 1).getDiameter());

            cell[9].setCellValue(inspectionResultses.get(index - 1).getDefectType());

            cell[10].setCellValue(inspectionResultses.get(index - 1).getDefectLoc());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 10, 12));//Merge Cell

            cell[13].setCellValue(inspectionResultses.get(index - 1).getResult());

            index++;
        } else {
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 0, 13));//Default Merge Cell
        }

        //ROW 36
        rowNo = 35;
        row = sheet.createRow(rowNo);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
        }

        if (verifyVector(inspectionResultses, index)) {

            for (int i = 0; i < 14; i++) {

                cell[i].setCellStyle(setBorder());
            }

            cell[0].setCellValue(index);

            cell[1].setCellValue(inspectionResultses.get(index - 1).getWeldNo());

            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 1, 3));//Merge Cell

            cell[4].setCellValue(inspectionResultses.get(index - 1).getTestLength());

            cell[5].setCellValue(inspectionResultses.get(index - 1).getWeldingProcess());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 5, 6));//Merge Cell

            cell[7].setCellValue(inspectionResultses.get(index - 1).getThickness());

            cell[8].setCellValue(inspectionResultses.get(index - 1).getDiameter());

            cell[9].setCellValue(inspectionResultses.get(index - 1).getDefectType());

            cell[10].setCellValue(inspectionResultses.get(index - 1).getDefectLoc());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 10, 12));//Merge Cell

            cell[13].setCellValue(inspectionResultses.get(index - 1).getResult());

            index++;
        } else {
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 0, 13));//Default Merge Cell
        }

        //ROW 37
        rowNo = 36;
        row = sheet.createRow(rowNo);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
        }

        if (verifyVector(inspectionResultses, index)) {

            for (int i = 0; i < 14; i++) {

                cell[i].setCellStyle(setBorder());
            }

            cell[0].setCellValue(index);

            cell[1].setCellValue(inspectionResultses.get(index - 1).getWeldNo());

            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 1, 3));//Merge Cell

            cell[4].setCellValue(inspectionResultses.get(index - 1).getTestLength());

            cell[5].setCellValue(inspectionResultses.get(index - 1).getWeldingProcess());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 5, 6));//Merge Cell

            cell[7].setCellValue(inspectionResultses.get(index - 1).getThickness());

            cell[8].setCellValue(inspectionResultses.get(index - 1).getDiameter());

            cell[9].setCellValue(inspectionResultses.get(index - 1).getDefectType());

            cell[10].setCellValue(inspectionResultses.get(index - 1).getDefectLoc());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 10, 12));//Merge Cell

            cell[13].setCellValue(inspectionResultses.get(index - 1).getResult());

            index++;
        } else {
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 0, 13));//Default Merge Cell
        }

        //ROW 38
        rowNo = 37;
        row = sheet.createRow(rowNo);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
        }

        if (verifyVector(inspectionResultses, index)) {

            for (int i = 0; i < 14; i++) {

                cell[i].setCellStyle(setBorder());
            }

            cell[0].setCellValue(index);

            cell[1].setCellValue(inspectionResultses.get(index - 1).getWeldNo());

            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 1, 3));//Merge Cell

            cell[4].setCellValue(inspectionResultses.get(index - 1).getTestLength());

            cell[5].setCellValue(inspectionResultses.get(index - 1).getWeldingProcess());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 5, 6));//Merge Cell

            cell[7].setCellValue(inspectionResultses.get(index - 1).getThickness());

            cell[8].setCellValue(inspectionResultses.get(index - 1).getDiameter());

            cell[9].setCellValue(inspectionResultses.get(index - 1).getDefectType());

            cell[10].setCellValue(inspectionResultses.get(index - 1).getDefectLoc());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 10, 12));//Merge Cell

            cell[13].setCellValue(inspectionResultses.get(index - 1).getResult());

            System.out.println("row 38 calisti");
            index++;
        } else {
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 0, 13));//Default Merge Cell
        }

//---------------------------------------------------------------------------//
        //Row 39
        sheet.createRow(38);

        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
            cell[i].setCellStyle(setHeaderFont());
        }

        cell[0].setCellValue("Personel Information");
        sheet.addMergedRegion(new CellRangeAddress(38, 38, 0, 2));//Merge Cell
        cell[3].setCellValue("Operator");
        sheet.addMergedRegion(new CellRangeAddress(38, 38, 3, 5));//Merge Cell
        cell[6].setCellValue("Evaluated By");
        sheet.addMergedRegion(new CellRangeAddress(38, 38, 6, 8));//Merge Cell

        cell[9].setCellValue("Confirmation");
        sheet.addMergedRegion(new CellRangeAddress(38, 38, 9, 11));//Merge Cell

        cell[12].setCellValue("Customer");
        sheet.addMergedRegion(new CellRangeAddress(38, 38, 12, 13));//Merge Cell

        //Row 40
        sheet.createRow(39);

        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());

        }

        cell[0].setCellValue("Name Surname");
        sheet.addMergedRegion(new CellRangeAddress(39, 39, 0, 2));//Merge Cell
        cell[3].setCellValue(operator);
        sheet.addMergedRegion(new CellRangeAddress(39, 39, 3, 5));//Merge Cell
        cell[6].setCellValue(evaluated);
        sheet.addMergedRegion(new CellRangeAddress(39, 39, 6, 8));//Merge Cell

        cell[9].setCellValue(confirmation);
        sheet.addMergedRegion(new CellRangeAddress(39, 39, 9, 11));//Merge Cell

        cell[12].setCellValue(customerTab.getCustomer());
        sheet.addMergedRegion(new CellRangeAddress(39, 39, 12, 13));//Merge Cell

        //Row 41
        sheet.createRow(40);

        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());

        }

        cell[0].setCellValue("Level");
        cell[0].setCellStyle(setHeaderFont());
        sheet.addMergedRegion(new CellRangeAddress(40, 40, 0, 2));//Merge Cell

        cell[3].setCellValue("lev");
        sheet.addMergedRegion(new CellRangeAddress(40, 40, 3, 5));//Merge Cell
        cell[6].setCellValue("lev");
        sheet.addMergedRegion(new CellRangeAddress(40, 40, 6, 8));//Merge Cell

        cell[9].setCellValue("lev");
        sheet.addMergedRegion(new CellRangeAddress(40, 40, 9, 11));//Merge Cell

        cell[12].setCellValue("lev");
        sheet.addMergedRegion(new CellRangeAddress(40, 40, 12, 13));//Merge Cell

        //Row 42
        sheet.createRow(41);

        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());

        }

        cell[0].setCellValue("Date");
        cell[0].setCellStyle(setHeaderFont());
        sheet.addMergedRegion(new CellRangeAddress(41, 41, 0, 2));//Merge Cell

        cell[3].setCellValue(date);
        sheet.addMergedRegion(new CellRangeAddress(41, 41, 3, 5));//Merge Cell
        cell[6].setCellValue(date);
        sheet.addMergedRegion(new CellRangeAddress(41, 41, 6, 8));//Merge Cell

        cell[9].setCellValue(date);
        sheet.addMergedRegion(new CellRangeAddress(41, 41, 9, 11));//Merge Cell

        cell[12].setCellValue(date);
        sheet.addMergedRegion(new CellRangeAddress(41, 41, 12, 13));//Merge Cell

        //Row 43
        sheet.createRow(42);

        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());

        }

        cell[0].setCellValue("Signature");
        cell[0].setCellStyle(setHeaderFont());
        sheet.addMergedRegion(new CellRangeAddress(42, 42, 0, 2));//Merge Cell
        cell[3].setCellValue("sig");
        sheet.addMergedRegion(new CellRangeAddress(42, 42, 3, 5));//Merge Cell
        cell[6].setCellValue("sig");
        sheet.addMergedRegion(new CellRangeAddress(42, 42, 6, 8));//Merge Cell

        cell[9].setCellValue("sig");
        sheet.addMergedRegion(new CellRangeAddress(42, 42, 9, 11));//Merge Cell

        cell[12].setCellValue("sig");
        sheet.addMergedRegion(new CellRangeAddress(42, 42, 12, 13));//Merge Cell

//        
        for (int colNum = 0; colNum < 14; colNum++) {
            sheet.autoSizeColumn(colNum, true);
        }
//        
//        short width = (int)300;
//        short height =(int)300;
//        sheet.setDefaultRowHeight(height);
//        sheet.setDefaultColumnWidth(width);

//         autoSizeColumns(workbook);
        createXlsxFile("exportGUI1");

    }

    public static void exportGUI2() {

        exportCustomer();
        exportEquipment();
        exportInspectionResults();
        createXlsxFile("exportGUI2");

    }

    public static void exportInspectionResults() {

        System.out.println("girdi");

        //Row 23
        row = sheet.createRow(22);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }
        cell[0].setCellValue("Inspection Results");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(22, 22, 0, 13));//Merge Cell

        //Row 24
        row = sheet.createRow(23);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
        }
        cell[0].setCellValue("Serial No");
        cell[0].setCellStyle(setHeaderFont());//SET STYLE

        cell[1].setCellValue("Weld/Piece No");
        cell[1].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(23, 23, 1, 3));//Merge Cell 3

        cell[4].setCellValue("Test Length");
        cell[4].setCellStyle(setHeaderFont());//SET STYLE

        cell[5].setCellValue("Welding Process");
        cell[5].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(23, 23, 5, 6));//Merge Cell 2

        cell[7].setCellValue("Thickness");
        cell[7].setCellStyle(setHeaderFont());//SET STYLE

        cell[8].setCellValue("Diaemter");
        cell[8].setCellStyle(setHeaderFont());//SET STYLE

        cell[9].setCellValue("Defect Type");
        cell[9].setCellStyle(setHeaderFont());//SET STYLE

        cell[10].setCellValue("Defect Loc");
        cell[10].setCellStyle(setHeaderFont());//SET STYLE
        sheet.addMergedRegion(new CellRangeAddress(23, 23, 10, 12));//Merge Cell

        cell[13].setCellValue("Result");
        cell[13].setCellStyle(setHeaderFont());//SET STYLE

        setInspectionResultsRow(24);
        setInspectionResultsRow(25);
        setInspectionResultsRow(26);
        setInspectionResultsRow(27);
        setInspectionResultsRow(28);
        setInspectionResultsRow(29);
        setInspectionResultsRow(30);
        setInspectionResultsRow(31);
        setInspectionResultsRow(32);
        setInspectionResultsRow(33);
        setInspectionResultsRow(34);
        setInspectionResultsRow(35);
        setInspectionResultsRow(36);
        setInspectionResultsRow(37);
        setInspectionResultsRow(38);

        for (int colNum = 0; colNum < 14; colNum++) {
            sheet.autoSizeColumn(colNum);
        }

//        createXlsxFile("Inspection");
    }

    private static boolean verifyVector(Vector<InspectionResults> vector, int index) {

        System.out.println("index " + index + "size  " + vector.size());
        boolean result = true;
        if (index > vector.size()) {
            return false;
        }
        System.out.println("index<size");
        return result;
    }

    // Header CEll Style
    private static CellStyle setHeaderFont() {
        Font headerFont = workbook.createFont();
        headerFont.setColor(IndexedColors.BLACK.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        headerCellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
        headerCellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        headerCellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        headerCellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);

        byte[] rgb = new byte[]{(byte) 255, (byte) 209, (byte) 205};
        XSSFCellStyle xssfcellcolorstyle = (XSSFCellStyle) headerCellStyle;
        headerCellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        xssfcellcolorstyle.setFillForegroundColor(new XSSFColor(rgb));

        return headerCellStyle;
    }

    private static CellStyle setBorder() {

        CellStyle style = workbook.createCellStyle();
        style.setBorderTop(XSSFCellStyle.BORDER_THIN);
        style.setBorderRight(XSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        style.setBorderBottom(XSSFCellStyle.BORDER_THIN);

        return style;
    }

    private static void createXlsxFile(String fileName) {

        try {
            fileOutputStream = new FileOutputStream(fileName + ".xlsx");
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Document Created");

    }

    private static void setInspectionResultsRow(int rowNo) {

        row = sheet.createRow(rowNo);
        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
        }

        if (verifyVector(inspectionResultses, index)) {

            for (int i = 0; i < 14; i++) {

                cell[i].setCellStyle(setBorder());
            }

            cell[0].setCellValue(index);

            cell[1].setCellValue(inspectionResultses.get(index - 1).getWeldNo());

            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 1, 3));//Merge Cell

            cell[4].setCellValue(inspectionResultses.get(index - 1).getTestLength());

            cell[5].setCellValue(inspectionResultses.get(index - 1).getWeldingProcess());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 5, 6));//Merge Cell

            cell[7].setCellValue(inspectionResultses.get(index - 1).getThickness());

            cell[8].setCellValue(inspectionResultses.get(index - 1).getDiameter());

            cell[9].setCellValue(inspectionResultses.get(index - 1).getDefectType());

            cell[10].setCellValue(inspectionResultses.get(index - 1).getDefectLoc());
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 10, 12));//Merge Cell

            cell[13].setCellValue(inspectionResultses.get(index - 1).getResult());

            index++;
        } else {
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 0, 13));//Default Merge Cell
        }

    }

    public static void lastSection() {

        //Row 39
        sheet.createRow(38);

        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());
            cell[i].setCellStyle(setHeaderFont());
        }

        cell[0].setCellValue("Personel Information");
        sheet.addMergedRegion(new CellRangeAddress(38, 38, 0, 2));//Merge Cell
        cell[3].setCellValue("Operator");
        sheet.addMergedRegion(new CellRangeAddress(38, 38, 3, 5));//Merge Cell
        cell[6].setCellValue("Evaluated By");
        sheet.addMergedRegion(new CellRangeAddress(38, 38, 6, 8));//Merge Cell

        cell[9].setCellValue("Confirmation");
        sheet.addMergedRegion(new CellRangeAddress(38, 38, 9, 11));//Merge Cell

        cell[12].setCellValue("Customer");
        sheet.addMergedRegion(new CellRangeAddress(38, 38, 12, 13));//Merge Cell

        //Row 40
        sheet.createRow(39);

        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());

        }

        cell[0].setCellValue("Name Surname");
        sheet.addMergedRegion(new CellRangeAddress(39, 39, 0, 2));//Merge Cell
        cell[3].setCellValue(operator);
        sheet.addMergedRegion(new CellRangeAddress(39, 39, 3, 5));//Merge Cell
        cell[6].setCellValue(evaluated);
        sheet.addMergedRegion(new CellRangeAddress(39, 39, 6, 8));//Merge Cell

        cell[9].setCellValue(confirmation);
        sheet.addMergedRegion(new CellRangeAddress(39, 39, 9, 11));//Merge Cell

        cell[12].setCellValue("customer");
        sheet.addMergedRegion(new CellRangeAddress(39, 39, 12, 13));//Merge Cell

        //Row 41
        sheet.createRow(40);

        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());

        }

        cell[0].setCellValue("Level");
        cell[0].setCellStyle(setHeaderFont());
        sheet.addMergedRegion(new CellRangeAddress(40, 40, 0, 2));//Merge Cell

        cell[3].setCellValue("lev");
        sheet.addMergedRegion(new CellRangeAddress(40, 40, 3, 5));//Merge Cell
        cell[6].setCellValue("lev");
        sheet.addMergedRegion(new CellRangeAddress(40, 40, 6, 8));//Merge Cell

        cell[9].setCellValue("lev");
        sheet.addMergedRegion(new CellRangeAddress(40, 40, 9, 11));//Merge Cell

        cell[12].setCellValue("lev");
        sheet.addMergedRegion(new CellRangeAddress(40, 40, 12, 13));//Merge Cell

        //Row 42
        sheet.createRow(41);

        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());

        }

        cell[0].setCellValue("Date");
        cell[0].setCellStyle(setHeaderFont());
        sheet.addMergedRegion(new CellRangeAddress(41, 41, 0, 2));//Merge Cell

        cell[3].setCellValue(date);
        sheet.addMergedRegion(new CellRangeAddress(41, 41, 3, 5));//Merge Cell
        cell[6].setCellValue(date);
        sheet.addMergedRegion(new CellRangeAddress(41, 41, 6, 8));//Merge Cell

        cell[9].setCellValue(date);
        sheet.addMergedRegion(new CellRangeAddress(41, 41, 9, 11));//Merge Cell

        cell[12].setCellValue(date);
        sheet.addMergedRegion(new CellRangeAddress(41, 41, 12, 13));//Merge Cell

        //Row 43
        sheet.createRow(42);

        for (int i = 0; i < 14; i++) {
            cell[i] = row.createCell(i);
            cell[i].setCellStyle(setBorder());

        }

        cell[0].setCellValue("Signature");
        cell[0].setCellStyle(setHeaderFont());
        sheet.addMergedRegion(new CellRangeAddress(42, 42, 0, 2));//Merge Cell
        cell[3].setCellValue("sig");
        sheet.addMergedRegion(new CellRangeAddress(42, 42, 3, 5));//Merge Cell
        cell[6].setCellValue("sig");
        sheet.addMergedRegion(new CellRangeAddress(42, 42, 6, 8));//Merge Cell

        cell[9].setCellValue("sig");
        sheet.addMergedRegion(new CellRangeAddress(42, 42, 9, 11));//Merge Cell

        cell[12].setCellValue("sig");
        sheet.addMergedRegion(new CellRangeAddress(42, 42, 12, 13));//Merge Cell

        System.out.println("row 38");

        createXlsxFile("last");

    }

    private static void autoSizeColumns(Workbook workbook) {
        int numberOfSheets = workbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            Sheet sheet = workbook.getSheetAt(i);
            if (sheet.getPhysicalNumberOfRows() > 0) {
                Row row = sheet.getRow(sheet.getFirstRowNum());
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    int columnIndex = cell.getColumnIndex();
                    sheet.autoSizeColumn(columnIndex);
                }
            }
        }
    }

    private static void addImage(int row, int row2, int coll, int coll2) throws FileNotFoundException, IOException {
        /* Read input PNG / JPG Image into FileInputStream Object*/
        InputStream my_banner_image = new FileInputStream("butt0.png");

        /* Convert picture to be added into a byte array */
        byte[] bytes = IOUtils.toByteArray(my_banner_image);

        /* Add Picture to Workbook, Specify picture type as PNG and Get an Index */
        int my_picture_id = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);

        /* Close the InputStream. We are ready to attach the image to workbook now */
        my_banner_image.close();

        /* Create the drawing container */
        XSSFDrawing drawing = sheet.createDrawingPatriarch();

        /* Create an anchor point */
        XSSFClientAnchor my_anchor = new XSSFClientAnchor();

        /* Define top left corner, and we can resize picture suitable from there */
        my_anchor.setRow1(row);
        my_anchor.setRow2(row2);
        my_anchor.setCol1(coll);
        my_anchor.setCol2(coll2);

        /* Invoke createPicture and pass the anchor point and ID */
        XSSFPicture my_picture = drawing.createPicture(my_anchor, my_picture_id);

        /* Call resize method, which resizes the image */
//        my_picture.resize();
    }
}
