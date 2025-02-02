/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.HelperClasses;

import com.aspose.cells.BackgroundType;
import com.aspose.cells.BorderType;
import com.aspose.cells.Cells;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.Cell;
import com.aspose.cells.CellBorderType;
import com.aspose.cells.CheckBox;
import com.aspose.cells.Color;
import com.aspose.cells.Picture;
import com.aspose.cells.Range;
import com.aspose.cells.Style;
import com.aspose.cells.StyleFlag;
import com.aspose.cells.TextAlignmentType;
import fxreportmanagement.Report1.Entitates.RInspectionResults;
import fxreportmanagement.Report2.Entitates.CustomerTab;
import fxreportmanagement.Report2.Entitates.EquipmentTab;
import fxreportmanagement.Report2.Entitates.InspectionResults;
import java.util.Vector;

/**
 *
 * @author Faruk
 *
 * Ömer Faruk Korkmaz 170503014
 */
public class ExcelExporterAsposeReport2 {

    private static Workbook workbook = new Workbook();

    private static Worksheet worksheet = workbook.getWorksheets().get(0);

    private static Cells cells = worksheet.getCells();

    private static Cell cell;

    private static Color color = Color.fromArgb(255, 209, 209);

    private static int row;

    private static int col;

    private static int index = 1;

    private static CustomerTab customer;

    private static EquipmentTab equipment;

    private static Vector<InspectionResults> inspectionResultses = new Vector<InspectionResults>();

    private static String operator;

    private static String evaluated;

    private static String confirmation;

    public static void main(String[] args) {

        exportHead();
        exportCustomer();
        exportEquipment();
        exportInspectionResults();
        exportLastSection();
        try {
            workbook.save("Report2.xls");
        } catch (Exception ex) {

            System.out.println("Docoment Report2 created ");
            System.out.println(ex.getMessage());
        }

    }

    //Export GUI
    public static void exportGUI(String fileName) {

        exportHead();
        exportCustomer();
        exportEquipment();
        exportInspectionResults();
        exportLastSection();
        try {
            workbook.save(fileName + ".xlsx");
            System.out.println("Docoment " + fileName + " craeted ");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    //Export Head
    private static void exportHead() {

        setWidthHeight();
        //---------------------Row 1-----------------------------------------//   
        row = 0;

        //C1-10
        col = 0;
        cells.get(row, col).setValue("LOGO");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 2, 10);//Set Border
        cells.merge(row, col, 2, 10);

        //C11-28
        col = 10;
        cells.get(row, col).setValue("XXX SURVEILLANCE INSPECTION SERVICES");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 18);//Set Border
        cells.merge(row, col, 1, 18);

        cells.setRowHeight(row, 15);

        //---------------------Row 2-----------------------------------------//   
        row = 1;

        //C11-28
        col = 10;
        cells.get(row, col).setValue("RADIOGRAPHIC EXAMINATION REPORT");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 18);//Set Border
        cells.merge(row, col, 1, 18);

        cells.setRowHeight(row, 35);

    }

    //Export Customer
    private static void exportCustomer() {

        //---------------------Row 3-----------------------------------------//        
        row = 2;

        createCustomerRow(row, "Customer", customer.getCustomer(), "Inspection Procedure", customer.getInspectionPlace(), "Page", customer.getPage());
        //---------------------Row 4-----------------------------------------//        
        row = 3;

        createCustomerRow(row, "Project Name", customer.getProjectNanme(), "Inspection Scope", customer.getInspectionScope(), "Report No", customer.getReportNo());

        //---------------------Row 5-----------------------------------------//        
        row = 4;

        createCustomerRow(row, "Inspection Place", customer.getInspectionPlace(), "Drawing No", customer.getDrawingNo(), "Report Date", customer.getReportDate());

        //---------------------Row 6-----------------------------------------//        
        row = 5;

        createCustomerRow(row, "Inspection Standart", customer.getInspectionStandart(), "Surface Condition", customer.getSurfaceCondition(), "Job Order No", customer.getJobOrderNo());

        //---------------------Row 7-----------------------------------------//        
        row = 6;

        createCustomerRow(row, "Evaluation Standart", customer.getEvaluationStandart(), "Stage Of Examination", customer.getStageOfExamination(), "Offer No", customer.getOfferNo());

    }

    //Export Equipment
    private static void exportEquipment() {

        //---------------------Row 8-----------------------------------------//   
        row = 7;

        //C1-28
        col = 0;
        cells.get(row, col).setValue("Equipment");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 28);//Set Border
        cells.merge(row, col, 1, 28);

        //---------------------Row 9-----------------------------------------//        
        row = 8;

        createEquipmentRow(row, "Pole Distance", equipment.getPoleDistance(), "Stage Of Examination", equipment.getExaminationArea(), "Surface Temperature", equipment.getSurfaceTemparature());

        //---------------------Row 10-----------------------------------------//        
        row = 9;
        cells.setRowHeight(row, 25);//Set Row Height

        //C1-2-3-4-5
        col = 0;

        cells.get(row, col).setValue("Equipment");
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 5);//Set Border
        cells.merge(row, col, 1, 5);

        //C6-7-8
        col = 5;

        cells.get(row, col).setValue(equipment.getEquipment());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C9-10-11-12-13
        col = 8;

        cells.get(row, col).setValue("Current Type");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 5);//Set Border
        cells.merge(row, col, 1, 5);

        //14-15-16-17-18-19-20-21
        col = 13;

        cells.get(row, col).setValue(equipment.getCurrentType());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 8);//Set Border
        cells.merge(row, col, 1, 8);

        //C22-23-24-25
        col = 21;

        cells.get(row, col).setValue("Gauss Field Strength");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 2, 4);//Set Border
        cells.merge(row, col, 2, 4);

        //C26-27-28
        col = 25;

        cells.get(row, col).setValue(equipment.getGaussFieldStrength());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 2, 3);//Set Border
        cells.merge(row, col, 2, 3);

        //---------------------Row 11-----------------------------------------//        
        row = 10;
        cells.setRowHeight(row, 25);//Set Row Height

        //C1-2-3-4-5
        col = 0;

        cells.get(row, col).setValue("MP Carrier Medium");
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 5);//Set Border
        cells.merge(row, col, 1, 5);

        //C6-7-8
        col = 5;

        cells.get(row, col).setValue(equipment.getMpCarrierMedium());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C9-10-11-12-13
        col = 8;

        cells.get(row, col).setValue("Luxmeter");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 5);//Set Border
        cells.merge(row, col, 1, 5);

        //14-15-16-17-18-19-20-21
        col = 13;

        cells.get(row, col).setValue(equipment.getLuxmeter());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 8);//Set Border
        cells.merge(row, col, 1, 8);

        //---------------------Row 12-----------------------------------------//        
        row = 11;

        createEquipmentRow(row, "Mag Tech", equipment.getMagTech(), "Test Medium", equipment.getTestMedium(), "Surface Condition", equipment.getSurfaceCondition());

        //---------------------Row 13-----------------------------------------//        
        row = 12;

        createEquipmentRow(row, "UV Light Intensity", equipment.getUvLightIntesity(), "Demagnetization", equipment.getDemagnetization(), "Identication Of Light Equipment", equipment.getIdenticationOfLightEquipment());

        //---------------------Row 14-----------------------------------------//        
        row = 13;

        createEquipmentRow(row, "Distance Of Light", equipment.getDistanceOfLight(), "Heat Treatment", equipment.getHeatTreatment(), "Lifting Test Date/Number", equipment.getLiftingTestDateNo());

        //---------------------Row 15-----------------------------------------//        
        row = 14;
        cells.setRowHeight(row, 20);//Set Row Height

        //C1-2-3-4-5-6
        col = 0;

        cells.get(row, col).setValue("");
        setPicture(row, col, 19, 6, "butt");
        setCheckBoxWithValue(18, 4, 20, 20, equipment.getButt());
        setBorder(row, col, 5, 6);//Set Border
        cells.merge(row, col, 5, 6);

        //C7-8-9-10-11-12-13
        col = 6;

        cells.get(row, col).setValue("");
        setPicture(row, 6, 19, 12, "fillet");
        setCheckBoxWithValue(18, 10, 20, 20, equipment.getFillet());
        setBorder(row, col, 5, 7);//Set Border
        cells.merge(row, col, 5, 7);

        //C14-28
        col = 13;

        cells.get(row, col).setValue("Location Of Discontinuity");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//SET Center
        setBorder(row, col, 1, 15);//Set Border
        cells.merge(row, col, 1, 15);

        //---------------------Row 16-----------------------------------------//        
        row = 15;
        cells.setRowHeight(row, 20);//Set Row Height

        //C14-18
        col = 13;

        cells.get(row, col).setValue("BM");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//SET Center
        setBorder(row, col, 1, 5);//Set Border
        cells.merge(row, col, 1, 5);

        //C19-28
        col = 18;

        cells.get(row, col).setValue("Base Metal");
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 10);//Set Border
        cells.merge(row, col, 1, 10);

        //---------------------Row 17-----------------------------------------//        
        row = 16;
        cells.setRowHeight(row, 20);//Set Row Height

        //C14-18
        col = 13;

        cells.get(row, col).setValue("Haz");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//SET Center
        setBorder(row, col, 1, 5);//Set Border
        cells.merge(row, col, 1, 5);

        //C19-28
        col = 18;

        cells.get(row, col).setValue("Heat Affected Zone");
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 10);//Set Border
        cells.merge(row, col, 1, 10);

        //---------------------Row 18-----------------------------------------//        
        row = 17;
        cells.setRowHeight(row, 20);//Set Row Height

        //C14-18
        col = 13;

        cells.get(row, col).setValue("W");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//SET Center
        setBorder(row, col, 1, 5);//Set Border
        cells.merge(row, col, 1, 5);

        //C19-28
        col = 18;

        cells.get(row, col).setValue("Weld");
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 10);//Set Border
        cells.merge(row, col, 1, 10);

        //---------------------Row 19-----------------------------------------//        
        row = 18;
        cells.setRowHeight(row, 20);//Set Row Height

        //C14-18
        col = 13;

        cells.get(row, col).setValue("B");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//SET Center
        setBorder(row, col, 1, 5);//Set Border
        cells.merge(row, col, 1, 5);

        //C19-28
        col = 18;

        cells.get(row, col).setValue("Bevel");
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 10);//Set Border
        cells.merge(row, col, 1, 10);

        //---------------------Row 20-----------------------------------------//        
        row = 19;
        cells.setRowHeight(row, 25);

        //C1-7
        col = 0;

        cells.get(row, col).setValue("Standart Derivations");
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 7);//Set Border
        cells.merge(row, col, 1, 7);

        //C8-28
        col = 7;

        cells.get(row, col).setValue(equipment.getStandartDevitions());
        setBorder(row, col, 1, 21);//Set Border
        cells.merge(row, col, 1, 21);

        //---------------------Row 21-----------------------------------------//        
        row = 20;
        cells.setRowHeight(row, 25);

        //C1-7
        col = 0;

        cells.get(row, col).setValue("Inspection Dates");
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 7);//Set Border
        cells.merge(row, col, 1, 7);

        //C8-28
        col = 7;

        cells.get(row, col).setValue(equipment.getInspectionDates());
        setBorder(row, col, 1, 21);//Set Border
        cells.merge(row, col, 1, 21);

        //---------------------Row 22-----------------------------------------//        
        row = 21;
        cells.setRowHeight(row, 25);

        //C1-7
        col = 0;

        cells.get(row, col).setValue("Description and Attachments");
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 7);//Set Border
        cells.merge(row, col, 1, 7);

        //C8-28
        col = 7;

        cells.get(row, col).setValue(equipment.getDescription());
        setBorder(row, col, 1, 21);//Set Border
        cells.merge(row, col, 1, 21);

    }

    //Export Inspection Results
    private static void exportInspectionResults() {

        //---------------------Row 23-----------------------------------------//   
        row = 22;
        cells.setRowHeight(row, 15);//Set Row Height

        //C1-28
        col = 0;
        cells.get(row, col).setValue("Inpection Results");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 28);//Set Border
        cells.merge(row, col, 1, 28);

        //---------------------Row 24-----------------------------------------//   
        row = 23;
        cells.setRowHeight(row, 25);//Set Row Height

        //C1-2
        col = 0;

        cells.get(row, col).setValue("Serial No");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C3-4-5-6-7-8
        col = 2;

        cells.get(row, col).setValue("Weld Piece No");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 6);//Set Border
        cells.merge(row, col, 1, 6);

        //C9-10-11
        col = 8;

        cells.get(row, col).setValue("Test Length");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C12-13-14-15
        col = 11;

        cells.get(row, col).setValue("Welding Proces");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 4);//Set Border
        cells.merge(row, col, 1, 4);

        //C16-17
        col = 15;

        cells.get(row, col).setValue("Thickness");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C18-19
        col = 17;

        cells.get(row, col).setValue("Diameter");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C20-21-22
        col = 19;

        cells.get(row, col).setValue("Defect Type");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);
        //C23-24-25-26
        col = 22;

        cells.get(row, col).setValue("Defect Loc");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 4);//Set Border
        cells.merge(row, col, 1, 4);

        //C27-28
        col = 26;

        cells.get(row, col).setValue("Result");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //---------------------Row 25-38-----------------------------------------//   
        row = 24;
        for (row = 24; row < 38; row++) {

            createInspectionResultsRow(row);
        }

        //carry on with row 39
    }

    //Export Last Section
    private static void exportLastSection() {

        //---------------------Row 39-----------------------------------------//   
        row = 38;
        cells.setRowHeight(row, 25);

        //C1-2-3-4-5-6
        col = 0;

        cells.get(row, col).setValue("Personel Information");
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 6);//Set Border
        cells.merge(row, col, 1, 6);

        //C7-12
        col = 6;

        cells.get(row, col).setValue("Operator");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 6);//Set Border
        cells.merge(row, col, 1, 6);

        //C13-18
        col = 12;

        cells.get(row, col).setValue("Evaluated By");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 6);//Set Border
        cells.merge(row, col, 1, 6);

        //C19-22
        col = 18;

        cells.get(row, col).setValue("Confirmation");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 4);//Set Border
        cells.merge(row, col, 1, 4);

        //C23-28
        col = 22;

        cells.get(row, col).setValue("Personel Information");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 6);//Set Border
        cells.merge(row, col, 1, 6);

        createLastSectionRow(39, "Name Surname");
        createLastSectionRow(40, "Level");
        createLastSectionRow(41, "Date");
        createLastSectionRow(42, "Signature");

    }

    //--------------------------------------------------------------------------
    //Create Customer Row
    private static void createCustomerRow(int row, String c0, String c5, String c13, String c17, String c21, String c24) {

        //C1-2-3-4-5
        col = 0;

        cells.get(row, col).setValue(c0);
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 5);//Set Border
        cells.merge(row, col, 1, 5);

        //C6-7-8-9-10-11-12-13
        col = 5;

        cells.get(row, col).setValue(c5);
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 8);//Set Border
        cells.merge(row, col, 1, 8);

        //C14-15-16-17
        col = 13;

        cells.get(row, col).setValue(c13);
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 4);//Set Border
        cells.merge(row, col, 1, 4);

        //C18-19-20-21
        col = 17;

        cells.get(row, col).setValue(c17);
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 4);//Set Border
        cells.merge(row, col, 1, 4);

        //C22-23-24
        col = 21;

        cells.get(row, col).setValue(c21);
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //25-26-27-28
        col = 24;

        cells.get(row, col).setValue(c24);
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 4);//Set Border
        cells.merge(row, col, 1, 4);

        cells.setRowHeight(row, 25);

    }

    //Create Equipment Row
    private static void createEquipmentRow(int row, String c0, String c5, String c8, String c13, String c21, String c24) {

        //C1-2-3-4-5
        col = 0;

        cells.get(row, col).setValue(c0);
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 5);//Set Border
        cells.merge(row, col, 1, 5);

        //C6-7-8
        col = 5;

        cells.get(row, col).setValue(c5);
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C9-10-11-12-13
        col = 8;

        cells.get(row, col).setValue(c8);
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 5);//Set Border
        cells.merge(row, col, 1, 5);

        //14-15-16-17-18-19-20-21
        col = 13;

        cells.get(row, col).setValue(c13);
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 8);//Set Border
        cells.merge(row, col, 1, 8);

        //C22-23-24-25
        col = 21;

        cells.get(row, col).setValue(c21);
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 4);//Set Border
        cells.merge(row, col, 1, 4);

        //C26-27-28
        col = 25;

        cells.get(row, col).setValue(c24);
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        cells.setRowHeight(row, 25);

    }

    //Create Inspection Results Row
    private static void createInspectionResultsRow(int row) {

        if (verifyVector(inspectionResultses, index)) {

            //C1-2
            col = 0;

            cells.get(row, col).setValue(index);
            setCenter(cells.get(row, col));//Set Center
            setBorder(row, col, 1, 2);//Set Border
            cells.merge(row, col, 1, 2);

            //C3-4-5-6-7-8
            col = 2;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getWeldNo());
            setCenter(cells.get(row, col));//Set Center
            setBorder(row, col, 1, 6);//Set Border
            cells.merge(row, col, 1, 6);

            //C9-10-11
            col = 8;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getTestLength());
            setCenter(cells.get(row, col));//Set Center
            setBorder(row, col, 1, 3);//Set Border
            cells.merge(row, col, 1, 3);

            //C12-13-14-15
            col = 11;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getWeldingProcess());
            setCenter(cells.get(row, col));//Set Center
            setBorder(row, col, 1, 4);//Set Border
            cells.merge(row, col, 1, 4);

            //C16-17
            col = 15;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getThickness());
            setCenter(cells.get(row, col));//Set Center
            setBorder(row, col, 1, 2);//Set Border
            cells.merge(row, col, 1, 2);

            //C18-19
            col = 17;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getDiameter());
            setCenter(cells.get(row, col));//Set Center
            setBorder(row, col, 1, 2);//Set Border
            cells.merge(row, col, 1, 2);

            //C20-21-22
            col = 19;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getDefectType());
            setCenter(cells.get(row, col));//Set Center
            setBorder(row, col, 1, 3);//Set Border
            cells.merge(row, col, 1, 3);
            //C23-24-25-26
            col = 22;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getDefectLoc());
            setCenter(cells.get(row, col));//Set Center
            setBorder(row, col, 1, 4);//Set Border
            cells.merge(row, col, 1, 4);

            //C27-28
            col = 26;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getResult());
            setCenter(cells.get(row, col));//Set Center
            setBorder(row, col, 1, 2);//Set Border
            cells.merge(row, col, 1, 2);

            index++;
        } else {

            //C1-2
            col = 0;

            setBorder(row, col, 1, 2);//Set Border
            cells.merge(row, col, 1, 2);

            //C3-4-5-6-7-8
            col = 2;

            setBorder(row, col, 1, 6);//Set Border
            cells.merge(row, col, 1, 6);

            //C9-10-11
            col = 8;

            setBorder(row, col, 1, 3);//Set Border
            cells.merge(row, col, 1, 3);

            //C12-13-14-15
            col = 11;

            setBorder(row, col, 1, 4);//Set Border
            cells.merge(row, col, 1, 4);

            //C16-17
            col = 15;

            setBorder(row, col, 1, 2);//Set Border
            cells.merge(row, col, 1, 2);

            //C18-19
            col = 17;

            setBorder(row, col, 1, 2);//Set Border
            cells.merge(row, col, 1, 2);

            //C20-21-22
            col = 19;

            setBorder(row, col, 1, 3);//Set Border
            cells.merge(row, col, 1, 3);

            //C23-24-25-26
            col = 22;

            setBorder(row, col, 1, 4);//Set Border
            cells.merge(row, col, 1, 4);

            //C27-28
            col = 26;

            setBorder(row, col, 1, 2);//Set Border
            cells.merge(row, col, 1, 2);

        }

        cells.setRowHeight(row, 25);
    }

    //Create Last Section Row
    private static void createLastSectionRow(int row, String field) {

        //C1-2-3-4-5-6
        col = 0;

        cells.get(row, col).setValue(field);
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 6);//Set Border
        cells.merge(row, col, 1, 6);

        //C7-12
        col = 6;

        cells.get(row, col).setValue(" ");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 6);//Set Border
        cells.merge(row, col, 1, 6);

        //C13-18
        col = 12;

        cells.get(row, col).setValue("");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 6);//Set Border
        cells.merge(row, col, 1, 6);

        //C19-22
        col = 18;

        cells.get(row, col).setValue("");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 4);//Set Border
        cells.merge(row, col, 1, 4);

        //C23-28
        col = 22;

        cells.get(row, col).setValue("");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 6);//Set Border
        cells.merge(row, col, 1, 6);

        cells.setRowHeight(row, 25);
        cells.setRowHeight(42, 50);

    }

    //Verify IR Vector
    private static boolean verifyVector(Vector<InspectionResults> vector, int index) {

        System.out.println("index " + index + "size  " + vector.size());
        boolean result = true;
        if (index > vector.size()) {
            return false;
        }
        System.out.println("index<size");
        return result;
    }

    //-------------------------------------------------------------------------
    //Set Styles
    //Set Color  Old
    private static Style setColor() {

        Color color = Color.fromArgb(255, 209, 209);
        workbook.changePalette(color, 55);
        Style style = null;
        // Setting the line of the top border
        style.setBorder(BorderType.TOP_BORDER, CellBorderType.THICK, Color.getBlack());

        // Setting the line of the bottom border
        style.setBorder(BorderType.BOTTOM_BORDER, CellBorderType.THICK, Color.getBlack());

        // Setting the line of the left border
        style.setBorder(BorderType.LEFT_BORDER, CellBorderType.THICK, Color.getBlack());

        // Setting the line of the right border
        style.setBorder(BorderType.RIGHT_BORDER, CellBorderType.THICK, Color.getBlack());

        style.setForegroundColor(color);
        style.setPattern(BackgroundType.SOLID);

        return style;
    }

    //Set Color 2
    private static void setColor2(Cell cell) {

        Style style = cell.getStyle();
        style.setForegroundColor(color);
        style.setPattern(BackgroundType.SOLID);
        cell.setStyle(style);

    }

    //Set Border
    private static void setBorder(int firstRow, int firstColumn, int totalRow, int totalColumn) {

        Range range = worksheet.getCells().createRange(firstRow, firstColumn, totalRow, totalColumn);
        range.setName("MyRange");

        range.setOutlineBorders(CellBorderType.THIN, Color.getBlack());

    }

    //Set Border Right
    private static void setBorderRight(int firstRow, int firstColumn, int totalRow, int totalColumn) {

        Range range = worksheet.getCells().createRange(firstRow, firstColumn, totalRow, totalColumn);
        range.setName("MyRange");

        range.setOutlineBorder(CellBorderType.THIN, BorderType.RIGHT_BORDER, Color.getBlack());

    }

    //Set Border General
    private static void setBorderG() {

        Range range = worksheet.getCells().getMaxDisplayRange();
        Style style = workbook.createStyle();
        style.setBorder(CellBorderType.THIN, BorderType.TOP_BORDER, Color.getBlack());
        style.setBorder(CellBorderType.THIN, BorderType.RIGHT_BORDER, Color.getBlack());
        style.setBorder(CellBorderType.THIN, BorderType.BOTTOM_BORDER, Color.getBlack());
        style.setBorder(CellBorderType.THIN, BorderType.LEFT_BORDER, Color.getBlack());

        for (int r = range.getFirstRow(); r < range.getRowCount(); r++) {
            for (int c = range.getFirstColumn(); c < range.getColumnCount(); c++) {
                Cell cell = worksheet.getCells().get(r, c);
                StyleFlag styleFlag = new StyleFlag();
                styleFlag.setTopBorder(true);
                styleFlag.setRightBorder(true);
                styleFlag.setBottomBorder(true);
                styleFlag.setLeftBorder(true);

                cell.setStyle(style, styleFlag);

            }
        }

//Setting outline border to range
        range.setOutlineBorders(BorderType.TOP_BORDER, Color.getBlack());
        range.setOutlineBorders(BorderType.RIGHT_BORDER, Color.getBlack());
        range.setOutlineBorders(BorderType.BOTTOM_BORDER, Color.getBlack());
        range.setOutlineBorders(BorderType.LEFT_BORDER, Color.getBlack());

    }

    //Set Center
    private static void setCenter(Cell cell) {

        Style style = cell.getStyle();
        style.setHorizontalAlignment(TextAlignmentType.CENTER);

        cell.setStyle(style);

    }

    //Set Vertical
    private static void setVertical(Cell cell) {

        Style style = cell.getStyle();
        style.setRotationAngle(-90);
        cell.setStyle(style);

        cell.setStyle(style);

    }

    //Set Width
    private static void setWidthHeight() {

        worksheet.getCells().setStandardWidth(5);

    }

    //Set Picture
    private static void setPicture(int upperLeftRow, int upperLeftCol, int lowerRightRow, int lowerRightcol, String fileName) {

        String dataDir = "C:/Users/ofaar/Documents/GitHub/fxreportmanagement/FxReportManagement/src/fxreportmanagement/Resources/" + fileName + ".PNG";

        try {
            int index = worksheet.getPictures().add(upperLeftRow, upperLeftCol, lowerRightRow, lowerRightcol, dataDir);
            Picture picture = worksheet.getPictures().get(index);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    //Set Checkbox
    private static void setCheckBox(int upperLeftRow, int upperLeftColumn, int height, int width) {

        int index = worksheet.getCheckBoxes().add(upperLeftRow, upperLeftColumn, height, width);
        CheckBox checkBox = worksheet.getCheckBoxes().get(index);

    }

    //Set Check Box With Value
    private static void setCheckBoxWithValue(int upperLeftRow, int upperLeftColumn, int height, int width, String value) {

        int index = worksheet.getCheckBoxes().add(upperLeftRow, upperLeftColumn, height, width);
        CheckBox checkBox = worksheet.getCheckBoxes().get(index);

        checkBox.setCheckedValue(Integer.parseInt(value));

    }

    //------------------------------------------------------------------------
    //Getter Setters
    //Set Customer
    public static void setCustomer(CustomerTab customer) {

        ExcelExporterAsposeReport2.customer = customer;
    }

    //Set Equipment
    public static void setEquipment(EquipmentTab equipment) {

        ExcelExporterAsposeReport2.equipment = equipment;
    }

    //Set Inspection Results
    public static void setInspectionResults(Vector<InspectionResults> inspectionResultses) {

        ExcelExporterAsposeReport2.inspectionResultses = inspectionResultses;
    }

    //Set Operator
    public static void setOperator(String operator) {
        ExcelExporterAsposeReport2.operator = operator;
    }

    //Set Evaluated
    public static void setEvaluated(String evaluated) {
        ExcelExporterAsposeReport2.evaluated = evaluated;
    }

    //Set Confiramtion
    public static void setConfirmation(String confirmation) {
        ExcelExporterAsposeReport2.confirmation = confirmation;

    }

    //Export IR Old
    private void exportIr() {

        //C1-2
        col = 0;

        cells.get(row, col).setValue(index);
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C3-4-5-6-7-8
        col = 2;

        cells.get(row, col).setValue("");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 6);//Set Border
        cells.merge(row, col, 1, 6);

        //C9-10-11
        col = 8;

        cells.get(row, col).setValue("");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C12-13-14-15
        col = 11;

        cells.get(row, col).setValue("");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 4);//Set Border
        cells.merge(row, col, 1, 4);

        //C16-17
        col = 15;

        cells.get(row, col).setValue("");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C18-19
        col = 17;

        cells.get(row, col).setValue("");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C20-21-22
        col = 19;

        cells.get(row, col).setValue("");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);
        //C23-24-25-26
        col = 22;

        cells.get(row, col).setValue("");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 4);//Set Border
        cells.merge(row, col, 1, 4);

        //C27-28
        col = 26;

        cells.get(row, col).setValue("");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        index++;
        cells.setRowHeight(row, 25);
        //carry on with row 39
    }//Old
}
