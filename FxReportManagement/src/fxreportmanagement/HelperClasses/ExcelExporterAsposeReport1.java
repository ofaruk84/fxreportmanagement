/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.HelperClasses;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import fxreportmanagement.Report1.Entitates.REquipmentTab;
import fxreportmanagement.Report1.Entitates.RInspectionResults;
import fxreportmanagement.Report1.Entitates.RTestArrangements;
import fxreportmanagement.Report2.Entitates.CustomerTab;
import java.util.Vector;

/**
 *
 * @author Faruk
 */
public class ExcelExporterAsposeReport1 {

    private static Workbook workbook = new Workbook();

    private static Worksheet worksheet = workbook.getWorksheets().get(0);

    private static Cells cells = worksheet.getCells();

    private static Cell cell;

    private static Color color = Color.fromArgb(255, 209, 209);

    private static CustomerTab customer;

    private static REquipmentTab equipment;

    private static RTestArrangements testArrangements;

    private static Vector<RInspectionResults> inspectionResultses;

    private static int row;

    private static int col;

    private static int index = 1;

    private static String operator;

    private static String evaluated;

    private static String confirmation;
    


    public static void main(String[] args) {

        exportHead();
        exportCustomer();
        exportEquipment();
        exportShootingInformations();
        exportTestArrangements();
        exportDefecType();
        exportInspectionResults();
        exportLastSection();
        try {
            workbook.save("Report1.0.1.xlsx");
            System.out.println("Docoment Report1.0.1.xlsx craeted ");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    //Export GUI
    public static void exportGUI(String fileName) {

        exportHead();
        exportCustomer();
        exportEquipment();
        exportShootingInformations();
        exportTestArrangements();
        exportDefecType();
        exportInspectionResults();
        exportLastSection();
        try {
            workbook.save(fileName+".xlsx");
            System.out.println("Docoment "+fileName+" craeted ");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    //Export Head
    private static void exportHead() {

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

        setWidthHeight();

        //---------------------Row 8-----------------------------------------//   
        row = 7;

        //C1-28
        col = 0;
        cells.get(row, col).setValue("Equipment");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 28);//Set Border
        cells.merge(row, col, 1, 28);

        //Row9
        row = 8;
        col = 0;

        //C1-2
        cells.get(row, col).setValue("Equipment");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 3, 2);//Set Border
        cells.merge(row, col, 3, 2);

        //C3-4-5-6-7-8
        col = 2;

        cells.get(row, col).setValue("Used Device");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 3, 6);//Set Border
        cells.merge(row, col, 3, 6);

        //C9-10-11-12-13-14-15
        col = 8;

        cells.get(row, col).setValue("Device Energy");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 7);//Set Border
        cells.merge(row, col, 1, 7);

        //C16-17-18
        col = 15;

        cells.get(row, col).setValue("Focal Shoot Size");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 3, 3);//Set Border
        cells.merge(row, col, 3, 3);

        //C19-20
        col = 18;

        cells.get(row, col).setValue("Exposure Time");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 3, 2);//Set Border
        cells.merge(row, col, 3, 2);
        //C21-22-23
        col = 20;

        cells.get(row, col).setValue("Film Focus Distance");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 3, 3);//Set Border
        cells.merge(row, col, 3, 3);

        //C24-25-26
        col = 23;

        cells.get(row, col).setValue("Pb Scenes");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 3, 3);//Set Border
        cells.merge(row, col, 3, 3);

        //C27-28
        col = 26;

        cells.get(row, col).setValue("Filters");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 3, 2);//Set Border
        cells.merge(row, col, 3, 2);

        //---------------------Row 10-----------------------------------------//
        row = 9;

        //C9-10
        col = 8;
        cells.get(row, col).setValue("Ir-192");
        setTopLeft(cells.get(row, col));//Set Top Left

        if (equipment.getIr192().equals("1")) {
            setCheckBoxWithValue(row, 9, 20, 20, equipment.getIr192());//Set Checkbox
        } else {
            setCheckBox(row, 9, 20, 20);
        }

        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 2, 2);//Set Border
        cells.merge(row, col, 2, 2);

        //C11-12
        col = 10;
        cells.get(row, col).setValue("Se-75");
        setTopLeft(cells.get(row, col));//Set Top Left

        if (equipment.getSe75().equals("1")) {
            setCheckBoxWithValue(row, 11, 20, 20, equipment.getSe75());//Set Checkbox
        } else {
            setCheckBox(row, 11, 20, 20);
        }

        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 2, 2);//Set Border
        cells.merge(row, col, 2, 2);

        //C13-14-15
        col = 12;
        cells.get(row, col).setValue("X-Ray");
        setTopLeft(cells.get(row, col));//Set Top Left

        if (equipment.getxRay().equals("1")) {
            setCheckBoxWithValue(row, 14, 20, 20, equipment.getxRay());//Set Checkbox
        } else {
            setCheckBox(row, 14, 20, 20);
        }

        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //---------------------Row 11-----------------------------------------//
        row = 10;

        //C13-14
        col = 12;
        cells.get(row, col).setValue("Kv");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C15
        col = 14;
        cells.get(row, col).setValue("mA");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 1);//Set Border
        cells.merge(row, col, 1, 1);

        //---------------------Row 12-----------------------------------------//
        row = 11;

        //C1-2
        col = 0;

        cells.get(row, col).setValue(equipment.getEquipment());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C3-4-5-6-7-8
        col = 2;

        cells.get(row, col).setValue(equipment.getUsedDevice());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 6);//Set Border
        cells.merge(row, col, 1, 6);

        //C9-10
        col = 8;
        cells.get(row, col).setValue("-");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C11-12
        col = 10;
        cells.get(row, col).setValue("-");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C13-14
        col = 12;
        cells.get(row, col).setValue("-");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C15
        col = 14;
        cells.get(row, col).setValue("-");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 1);//Set Border
        cells.merge(row, col, 1, 1);

        //C16-17-18
        col = 15;

        cells.get(row, col).setValue(equipment.getFocalSpotSize());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C19-20
        col = 18;

        cells.get(row, col).setValue(equipment.getExposureTime());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);
        //C21-22-23
        col = 20;

        cells.get(row, col).setValue(equipment.getFilmFocusDistance());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C24-25-26
        col = 23;

        cells.get(row, col).setValue(equipment.getPbScenes());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C27-28
        col = 26;

        cells.get(row, col).setValue(equipment.getFilters());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //---------------------Row 13-----------------------------------------//
        row = 12;

        //C1-2
        col = 0;
        cells.get(row, col).setValue("Heat Treatment");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 2, 2);//Set Border
        cells.merge(row, col, 2, 2);

        //C3-4-5-6-7
        col = 2;

        cells.get(row, col).setValue("Geometric un-sharpness");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 2, 5);//Set Border
        cells.merge(row, col, 2, 5);

        //C8-9-10-11-12-13-14-15-16-17
        col = 7;

        cells.get(row, col).setValue("Film Informations");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 10);//Set Border
        cells.merge(row, col, 1, 10);

        //C18-19-20-21
        col = 17;

        cells.get(row, col).setValue("IQI Tech");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 4);//Set Border
        cells.merge(row, col, 1, 4);

        //C22-23-24-25-26-27-28
        col = 21;

        cells.get(row, col).setValue("Film Processing Tech");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 7);//Set Border
        cells.merge(row, col, 1, 7);

        //---------------------Row 14-----------------------------------------//
        row = 13;

        //C8-9
        col = 7;
        cells.get(row, col).setValue("Film Brand");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 3, 2);//Set Border
        cells.merge(row, col, 3, 2);

        //C10-11-12-13-14-15-16-17
        col = 9;
        cells.get(row, col).setValue("Film Type");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 8);//Set Border
        cells.merge(row, col, 1, 8);

        //C18-19
        col = 17;
        cells.get(row, col).setValue("EN");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        cells.merge(row, col, 1, 2);

        //C20-21
        col = 19;
        cells.get(row, col).setValue("ASTM");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        cells.merge(row, col, 1, 2);

        //C22-23
        col = 21;
        cells.get(row, col).setValue("Automatic");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 3, 2);//Set Border
        cells.merge(row, col, 3, 2);

        //C24-25
        col = 23;
        cells.get(row, col).setValue("Manual");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 3, 2);//Set Border
        cells.merge(row, col, 3, 2);

        //C26-27-28
        col = 25;
        cells.get(row, col).setValue("Temperature");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 3, 3);//Set Border
        cells.merge(row, col, 3, 3);

        //---------------------Row 15-----------------------------------------//
        row = 14;

        //C1-2
        col = 0;

        cells.get(row, col).setValue(equipment.getHeatTreatment());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 3, 2);//Set Border
        cells.merge(row, col, 3, 2);

        //C3-4-5
        col = 2;

        cells.get(row, col).setValue("u = bxa");
        setBorder(row, col, 3, 3);
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        cells.merge(row, col, 3, 3);

        //C6-7
        col = 5;

        cells.get(row, col).setValue("0.18mm");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 3, 2);//Set Border
        cells.merge(row, col, 3, 2);

        //C10-11-C12
        col = 9;

        cells.get(row, col).setValue("D4(MX-125)");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 2, 3);//Set Border
        cells.merge(row, col, 2, 3);

        //C13-14
        col = 12;

        cells.get(row, col).setValue("D5(T2000)");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 2, 2);//Set Border
        cells.merge(row, col, 2, 2);

        //C15-16-17
        col = 14;

        cells.get(row, col).setValue("D7(AA 400)");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 2, 3);//Set Border
        cells.merge(row, col, 2, 3);

        //C18-19
        col = 17;

        cells.get(row, col).setValue("Source Side");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 2, 2);//Set Border
        cells.merge(row, col, 2, 2);

        //C20-21
        col = 19;

        cells.get(row, col).setValue("Film Side");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 2, 2);//Set Border
        cells.merge(row, col, 2, 2);

        //---------------------Row 17-----------------------------------------//
        row = 16;

        //C8-9
        col = 7;

        cells.get(row, col).setValue(equipment.getFilmBrand());//filmbrand
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C10-11-12
        col = 9;

        cells.get(row, col).setValue(" ");//D4

        if (equipment.getD4().equals("1")) {
            setCheckBoxWithValue(row, 10, 20, 20, equipment.getD4());//Set Checkbox
        } else {
            setCheckBox(row, 10, 20, 20);
        }

        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C13-14
        col = 12;

        cells.get(row, col).setValue(" ");//d5

        if (equipment.getD5().equals("1")) {
            setCheckBoxWithValue(row, 13, 20, 20, equipment.getD5());//Set Checkbox
        } else {
            setCheckBox(row, 13, 20, 20);
        }

        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C15-16-17
        col = 14;

        cells.get(row, col).setValue(" ");//d7

        if (equipment.getD7().equals("1")) {
            setCheckBoxWithValue(row, 15, 20, 20, equipment.getD7());//Set Checkboxes
        } else {
            setCheckBox(row, 15, 20, 20);
        }

        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C18-19
        col = 17;

        cells.get(row, col).setValue(" ");//sourceside

        if (equipment.getSourceSide().equals("1")) {
            setCheckBoxWithValue(row, 18, 20, 20, equipment.getSourceSide());//Set Checkboxes
        } else {
            setCheckBox(row, 18, 20, 20);
        }

        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C20-21
        col = 19;

        cells.get(row, col).setValue("");//filmside

        if (equipment.getFilmSide().equals("1")) {
            setCheckBoxWithValue(row, 20, 20, 20, equipment.getFilmSide());//Set Checkboxes
        } else {
            setCheckBox(row, 20, 20, 20);
        }

        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C22-23
        col = 21;

        cells.get(row, col).setValue(" ");//auto

        if (equipment.getAutomatic().equals("1")) {
            setCheckBoxWithValue(row, 22, 20, 20, equipment.getAutomatic());//Set Checkboxes
        } else {
            setCheckBox(row, 22, 20, 20);
        }

        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C24-25
        col = 23;

        cells.get(row, col).setValue("");//manuel

        if (equipment.getManual().equals("1")) {
            setCheckBoxWithValue(row, 24, 20, 20, equipment.getManual());//Set Checkboxes
        } else {
            setCheckBox(row, 24, 20, 20);
        }

        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C26-27-28
        col = 25;

        cells.get(row, col).setValue(equipment.getTemperature());//temp
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

    }
    
    //Export Shooting Informations
    private static void exportShootingInformations() {

        //---------------------Row 18-----------------------------------------//
        row = 17;

        //C All Columns
        col = 0;

        cells.get(row, col).setValue("Shooting Informations");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 28);//Set Border
        cells.merge(row, col, 1, 28);

        //---------------------Row 19-----------------------------------------//
        row = 18;

        //C1-2
        col = 0;
        cells.get(row, col).setValue("Film Size");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C3-4-5-6-7
        col = 2;

        cells.get(row, col).setValue("10x12");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 5);//Set Border
        cells.merge(row, col, 1, 5);

        //C8-9
        col = 7;

        cells.get(row, col).setValue("10x16");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C10-11-12
        col = 9;

        cells.get(row, col).setValue("10x24");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //13-14-15
        col = 12;

        cells.get(row, col).setValue("10x36");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C16-17-18
        col = 15;

        cells.get(row, col).setValue("10x48");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C19-20
        col = 18;

        cells.get(row, col).setValue("30x40");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C21-22-23
        col = 20;

        cells.get(row, col).setValue("Suitible Film");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //24-25-26-27-28
        col = 23;

        cells.get(row, col).setValue("Repair Film");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 5);//Set Border
        cells.merge(row, col, 1, 5);

        cells.setRowHeight(row, 20);

        //---------------------Row 20-----------------------------------------//
        row = 19;

        //C1-2
        col = 0;

        cells.get(row, col).setValue("Film Quant");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C3-4-5-6-7
        col = 2;

        cells.get(row, col).setValue(equipment.getX12());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 5);//Set Border
        cells.merge(row, col, 1, 5);

        //C8-9
        col = 7;

        cells.get(row, col).setValue(equipment.getX16());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C10-11-12
        col = 9;

        cells.get(row, col).setValue(equipment.getX24());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //13-14-15
        col = 12;

        cells.get(row, col).setValue(equipment.getX36());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C16-17-18
        col = 15;

        cells.get(row, col).setValue(equipment.getX48());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C19-20
        col = 18;

        cells.get(row, col).setValue(equipment.getX40());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C21-22-23
        col = 20;

        cells.get(row, col).setValue(equipment.getSuitibleFilm());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //24-25-26-27-28
        col = 23;

        cells.get(row, col).setValue(equipment.getRepairFilm());
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 5);//Set Border
        cells.merge(row, col, 1, 5);

        cells.setRowHeight(row, 20);//Set Row Height

        //---------------------Row 21-----------------------------------------//
        row = 20;

        //C1-2-3-4-5
        col = 0;

        cells.get(row, col).setValue("Evaluatin Symbols");
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 5);//Set Border
        cells.merge(row, col, 1, 5);

        //C6-7-8-9
        col = 5;

        cells.get(row, col).setValue("Accepted     OK");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 4);//Set Border
        cells.merge(row, col, 1, 4);

        //10-11
        col = 9;

        cells.get(row, col).setValue("Repair     R");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C12-13-14-15-16-17
        col = 11;

        cells.get(row, col).setValue("Cut-Out         C/O");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 6);//Set Border
        cells.merge(row, col, 1, 6);

        //C18-19-20-21-22
        col = 17;

        cells.get(row, col).setValue("Re-Shoot     RS");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 5);//Set Border
        cells.merge(row, col, 1, 5);

        //C23-24-25-26-27-28
        col = 22;

        cells.get(row, col).setValue("Extra Film        EF");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 6);//Set Border
        cells.merge(row, col, 1, 6);

        cells.setRowHeight(row, 21);//Set Row Height

    }
    
    //Export Test Arrangements
    private static void exportTestArrangements() {

        //---------------------Row 22-----------------------------------------//
        row = 21;

        //C0
        col = 0;
        cells.get(row, col).setValue("Test Arrangements");
        setColor2(cells.get(row, col));//SET COLOR
        setVertical(cells.get(row, col));//Set Veritcal
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 10, 1);//Set Border
        cells.merge(row, col, 10, 1);

        //C3
        col = 2;
        setPicture(22, col, 29, 5, "ta1");

        //C7
        col = 6;
        setPicture(22, col, 29, 9, "ta2");

        //C11
        col = 10;
        setPicture(22, col, 29, 13, "ta3");

        //C15
        col = 14;
        setPicture(22, col, 29, 18, "ta4");

        //C20
        col = 19;
        setPicture(22, col, 29, 23, "ta5");

        //C25
        col = 24;
        setPicture(22, col, 29, 27, "ta6");

        cells.merge(row, 1, 1, 27);//Merge Whole first Row

        cells.merge(22, 1, 7, 1);//Merge 22-29 Columns
        cells.merge(22, 5, 7, 1);//Merge 22-29 Columns
        cells.merge(22, 9, 7, 1);//Merge 22-29 Columns
        cells.merge(22, 13, 7, 1);//Merge 22-29 Columns
        cells.merge(22, 18, 7, 1);//Merge 22-29 Columns
        cells.merge(22, 23, 7, 1);//Merge 22-29 Columns
        cells.merge(22, 27, 7, 1);//Merge 22-29 Columns

        setBorderRight(21, 28, 10, 1);

        //---------------------Row 30-----------------------------------------//
        row = 29;

        //C2-3-4-5
        col = 1;
        cells.merge(row, col, 2, 4);

        if (testArrangements.getTa1().equals("1")) {

            setCheckBoxWithValue(row, 3, 20, 40, testArrangements.getTa1());//Set Checkbox
        } else {

            setCheckBox(row, 3, 20, 40);
        }

        //C6-7-8-9
        col = 5;
        cells.merge(row, col, 2, 4);

        if (testArrangements.getTa2().equals("1")) {

            setCheckBoxWithValue(row, 7, 20, 40, testArrangements.getTa2());
        } else {

            setCheckBox(row, 7, 20, 40);
        }

        //C10-11-12-13
        col = 9;
        cells.merge(row, col, 2, 4);

        if (testArrangements.getTa3().equals("1")) {

            setCheckBoxWithValue(row, 11, 20, 40, testArrangements.getTa3());//Set Checkbox
        } else {

            setCheckBox(row, 11, 20, 40);
        }

        //C14-15-16-17-18
        col = 13;
        cells.merge(row, col, 2, 5);

        if (testArrangements.getTa4().equals("1")) {

            setCheckBoxWithValue(row, 15, 20, 40, testArrangements.getTa4());//Set Checkbox
        } else {

            setCheckBox(row, 15, 20, 40);
        }

        //C19-20-21-22-23
        col = 18;
        cells.merge(row, col, 2, 5);

        if (testArrangements.getTa5().equals("1")) {

            setCheckBoxWithValue(row, 20, 20, 40, testArrangements.getTa5());//Set Checkbox
        } else {

            setCheckBox(row, 20, 20, 40);
        }

        //C24-25-26-27-28
        col = 23;
        cells.merge(row, col, 2, 5);

        if (testArrangements.getTa6().equals("1")) {

            setCheckBoxWithValue(row, 25, 20, 40, testArrangements.getTa6());//Set Checkbox
        } else {

            setCheckBox(row, 25, 20, 40);
        }

    }
    
    //Export Defect Types
    private static void exportDefecType() {

        //---------------------Row 32-----------------------------------------//   
        row = 31;
        cells.setRowHeight(row, 13);//Set Row Height

        //C1-2-3-4
        col = 0;

        cells.get(row, col).setValue("According To");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 4);//Set Border
        cells.merge(row, col, 1, 4);

        //C5-6-7-8-9-10-11-12-13-14
        col = 4;

        cells.get(row, col).setValue("Defect Types");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 2, 10);//Set Border
        cells.merge(row, col, 2, 10);

        //C15-16-17-18
        col = 14;

        cells.get(row, col).setValue("According To");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 4);//Set Border
        cells.merge(row, col, 1, 4);

        //C19-20-21-22-23-24-25-26-27-28
        col = 18;

        cells.get(row, col).setValue("Defect Types");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 2, 10);//Set Border
        cells.merge(row, col, 2, 10);

        //---------------------Row 33-----------------------------------------//   
        row = 32;

        //C1
        col = 0;

        cells.get(row, col).setValue("IIW");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 1);//Set Border

        //C2-3-4
        col = 1;

        cells.get(row, col).setValue("652-1");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C15
        col = 14;

        cells.get(row, col).setValue("IIW");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 1);//Set Border

        //C16-17-18
        col = 15;

        cells.get(row, col).setValue("652-1");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //---------------------Row 34-----------------------------------------//   
        row = 33;
        createDefectRow(row, "Aa", "2011", "Prosity", "Db", "515", "Root Suck Back");
        cells.setRowHeight(row, 13);//Set Row Height

        //---------------------Row 35-----------------------------------------//   
        row = 34;
        createDefectRow(row, "Ab", "2016", "Worm Holes", "Dc", "504", "Exessive Penetration");
        cells.setRowHeight(row, 13);//Set Row Height

        //---------------------Row 36-----------------------------------------//   
        row = 35;
        createDefectRow(row, "Ac", "2014", "Aligned Prosity", "Ea", "1011", "Longitudinal Crack");
        cells.setRowHeight(row, 13);//Set Row Height

        //---------------------Row 37-----------------------------------------//   
        row = 36;
        createDefectRow(row, "Ad", "2013", "Porosity Group", "Eb", "10211023,1", "Transverse Crack");
        cells.setRowHeight(row, 13);//Set Row Height

        //---------------------Row 38-----------------------------------------//   
        row = 37;
        createDefectRow(row, "Ba", "3012", "Slag Inclusion", "Ec", "1046,1047,1054", "Crater Cracks");
        cells.setRowHeight(row, 13);//Set Row Height

        //---------------------Row 37-----------------------------------------//   
        row = 38;
        createDefectRow(row, "Bb", "3011", "Slag Line", "Fb", "517, 5091", "Bad Weld Surface");
        cells.setRowHeight(row, 13);//Set Row Height

        //---------------------Row 40-----------------------------------------//   
        row = 39;
        createDefectRow(row, "Bc", "3013", "Slag Group (Clustered)", "Fc", "5011,5012,5013", "Undercut");
        cells.setRowHeight(row, 13);//Set Row Height

        //---------------------Row 41-----------------------------------------//   
        row = 40;
        createDefectRow(row, "C", "4011", "Lack Of Fusion", "ff", "-", "Film Failure");
        cells.setRowHeight(row, 13);//Set Row Height

        //---------------------Row 42-----------------------------------------//   
        row = 41;
        createDefectRow(row, "D", "402,4021,4013", "Incomplete Penetration", "W", "3041", "Tungsten Inclusion");
        cells.setRowHeight(row, 13);//Set Row Height

        //---------------------Row 43-----------------------------------------//   
        row = 42;
        cells.setRowHeight(row, 25);//Set Row Height

        //C1-14
        col = 0;

        cells.get(row, col).setValue("Inspection Dates");
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 14);//Set Border
        cells.merge(row, col, 1, 14);

        //C15-28
        col = 14;

        cells.get(row, col).setValue(" ");
        setBorder(row, col, 1, 14);//Set Border
        cells.merge(row, col, 1, 14);

        //---------------------Row 44-----------------------------------------//   
        row = 43;
        cells.setRowHeight(row, 25);//Set Row Height

        //C1-14
        col = 0;

        cells.get(row, col).setValue("Descriptions and Attachments");
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 14);//Set Border
        cells.merge(row, col, 1, 14);

        //C15-28
        col = 14;

        cells.get(row, col).setValue(" ");
        setBorder(row, col, 1, 14);//Set Border
        cells.merge(row, col, 1, 14);
    }
    
    //Export Inspection Results
    private static void exportInspectionResults() {

        //---------------------Row 45-----------------------------------------//   
        row = 44;

        //C1-28
        col = 0;
        cells.get(row, col).setValue("Inspection Results");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 28);//Set Border
        cells.merge(row, col, 1, 28);

        cells.setRowHeight(row, 20);//Set Row Height;

        //---------------------Row 46-----------------------------------------//   
        row = 45;

        //C1
        col = 0;

        cells.get(row, col).setValue("Serial No");
        setColor2(cells.get(row, col));//SET COLOR
        setVertical(cells.get(row, col));//Set Vertical
        setBorder(row, col, 3, 1);//Set Border
        cells.merge(row, col, 3, 1);

        //C2-3-4-5-6
        col = 1;

        cells.get(row, col).setValue("Shooting Area");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 3, 5);//Set Border
        cells.merge(row, col, 3, 5);

        //C7-8
        col = 6;

        cells.get(row, col).setValue("Film No");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 3, 2);//Set Border
        cells.merge(row, col, 3, 2);

        //C9
        col = 8;

        cells.get(row, col).setValue("Material Type");
        setColor2(cells.get(row, col));//SET COLOR
        setVertical(cells.get(row, col));//Set Vertical
        setBorder(row, col, 3, 1);//Set Border
        cells.merge(row, col, 3, 1);

        //C10
        col = 9;

        cells.get(row, col).setValue("Welding Type");
        setColor2(cells.get(row, col));//SET COLOR
        setVertical(cells.get(row, col));//Set Vertical
        setBorder(row, col, 3, 1);//Set Border
        cells.merge(row, col, 3, 1);

        //C11
        col = 10;

        cells.get(row, col).setValue("Welder Nr");
        setColor2(cells.get(row, col));//SET COLOR
        setVertical(cells.get(row, col));//Set Vertical
        setBorder(row, col, 3, 1);//Set Border
        cells.merge(row, col, 3, 1);

        //C12
        col = 11;

        cells.get(row, col).setValue("Position");
        setColor2(cells.get(row, col));//SET COLOR
        setVertical(cells.get(row, col));//Set Vertical
        setBorder(row, col, 3, 1);//Set Border
        cells.merge(row, col, 3, 1);

        //C13
        col = 12;

        cells.get(row, col).setValue("Thicknes");
        setColor2(cells.get(row, col));//SET COLOR
        setVertical(cells.get(row, col));//Set Vertical
        setBorder(row, col, 3, 1);//Set Border
        cells.merge(row, col, 3, 1);

        //C14
        col = 13;

        cells.get(row, col).setValue("IQI");
        setColor2(cells.get(row, col));//SET COLOR
        setVertical(cells.get(row, col));//Set Vertical
        setBorder(row, col, 3, 1);//Set Border
        cells.merge(row, col, 3, 1);

        //C15
        col = 14;

        cells.get(row, col).setValue("Visible IQI");
        setColor2(cells.get(row, col));//SET COLOR
        setVertical(cells.get(row, col));//Set Vertical
        setBorder(row, col, 3, 1);//Set Border
        cells.merge(row, col, 3, 1);

        //C16
        col = 15;

        cells.get(row, col).setValue("Density");
        setColor2(cells.get(row, col));//SET COLOR
        setVertical(cells.get(row, col));//Set Vertical
        setBorder(row, col, 3, 1);//Set Border
        cells.merge(row, col, 3, 1);

        //C17
        col = 16;

        cells.get(row, col).setValue("10x12");
        setColor2(cells.get(row, col));//SET COLOR
        setVertical(cells.get(row, col));//Set Vertical
        setBorder(row, col, 3, 1);//Set Border
        cells.merge(row, col, 3, 1);
        //C18
        col = 17;

        cells.get(row, col).setValue("10x16");
        setColor2(cells.get(row, col));//SET COLOR
        setVertical(cells.get(row, col));//Set Vertical
        setBorder(row, col, 3, 1);//Set Border
        cells.merge(row, col, 3, 1);

        //C19
        col = 18;

        cells.get(row, col).setValue("10x24");
        setColor2(cells.get(row, col));//SET COLOR
        setVertical(cells.get(row, col));//Set Vertical
        setBorder(row, col, 3, 1);//Set Border
        cells.merge(row, col, 3, 1);

        //C20
        col = 19;

        cells.get(row, col).setValue("10x36");
        setColor2(cells.get(row, col));//SET COLOR
        setVertical(cells.get(row, col));//Set Vertical
        setBorder(row, col, 3, 1);//Set Border
        cells.merge(row, col, 3, 1);

        //C21
        col = 20;

        cells.get(row, col).setValue("10x48");
        setColor2(cells.get(row, col));//SET COLOR
        setVertical(cells.get(row, col));//Set Vertical
        setBorder(row, col, 3, 1);//Set Border
        cells.merge(row, col, 3, 1);

        //C22
        col = 21;

        cells.get(row, col).setValue("30x40");
        setColor2(cells.get(row, col));//SET COLOR
        setVertical(cells.get(row, col));//Set Vertical
        setBorder(row, col, 3, 1);//Set Border
        cells.merge(row, col, 3, 1);

        //C23
        col = 22;

        cells.get(row, col).setValue("Defect Loc");
        setColor2(cells.get(row, col));//SET COLOR
        setVertical(cells.get(row, col));//Set Vertical
        setBorder(row, col, 3, 1);//Set Border
        cells.merge(row, col, 3, 1);

        //C24
        col = 23;

        cells.get(row, col).setValue("Defect Type");
        setColor2(cells.get(row, col));//SET COLOR
        setVertical(cells.get(row, col));//Set Vertical
        setBorder(row, col, 3, 1);//Set Border
        cells.merge(row, col, 3, 1);

        //C25-26
        col = 24;

        cells.get(row, col).setValue("Pre Evaluation");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 3, 2);//Set Border
        cells.merge(row, col, 3, 2);

        //C27-28
        col = 26;

        cells.get(row, col).setValue("Final Evaluation");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 3, 2);//Set Border
        cells.merge(row, col, 3, 2);

        cells.setRowHeight(row, 23);
        cells.setRowHeight(46, 23);
        cells.setRowHeight(47, 23);

        setInspectionResultsRow(48);
        setInspectionResultsRow(49);
        setInspectionResultsRow(50);
        setInspectionResultsRow(51);
        setInspectionResultsRow(52);

    }
    
    //Export Last Section
    private static void exportLastSection() {

        //---------------------Row 54-----------------------------------------//   
        row = 53;
        cells.setRowHeight(row, 25);

        //C1-2-3-4-5-6
        col = 0;

        cells.get(row, col).setValue("Personel Information");
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 6);//Set Border
        cells.merge(row, col, 1, 6);

        //C7-12
        col = 6;

        cells.get(row, col).setValue("Radiographer");
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

        createLastSectionRow(54, "Name Surname",operator,evaluated,confirmation,"");
        createLastSectionRow(55, "Level","","","","");
        createLastSectionRow(56, "Date","","","","");
        createLastSectionRow(57, "Signature","","","","");

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
    
    //Verify IR Vector
    private static boolean verifyVector(Vector<RInspectionResults> vector, int index) {

        System.out.println("index " + index + "size  " + vector.size());
        boolean result = true;
        if (index > vector.size()) {
            return false;
        }
        System.out.println("index<size");
        return result;
    }
    
    //Create IR Row
    private static void setInspectionResultsRow(int row) {

        cells.setRowHeight(row, 25);

        if (verifyVector(inspectionResultses, index)) {
            //C1
            col = 0;

            cells.get(row, col).setValue(index);
            setBorder(row, col, 1, 1);//Set Border

            //C2-3-4-5-6
            col = 1;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getShootingArea());
            setBorder(row, col, 1, 5);//Set Border
            cells.merge(row, col, 1, 5);

            //C7-8
            col = 6;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getFilmNo());
            setBorder(row, col, 1, 2);//Set Border
            cells.merge(row, col, 1, 2);

            //C9
            col = 8;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getMaterialType());
            setBorder(row, col, 1, 1);//Set Border
            //C10
            col = 9;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getWeldingType());
            setBorder(row, col, 1, 1);//Set Border
            //C11
            col = 10;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getWelderNo());
            setBorder(row, col, 1, 1);//Set Border

            //C12
            col = 11;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getPosition());
            setBorder(row, col, 1, 1);//Set Border

            //C13
            col = 12;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getThickness());
            setBorder(row, col, 1, 1);//Set Border

            //C14
            col = 13;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getIQI());
            setBorder(row, col, 1, 1);//Set Border

            //C15
            col = 14;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getVisibleIQI());
            setBorder(row, col, 1, 1);//Set Border

            //C16
            col = 15;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getDensity());
            setBorder(row, col, 1, 1);//Set Border
            //C17
            col = 16;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getX12());
            setBorder(row, col, 1, 1);//Set Border
            //C18
            col = 17;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getX16());
            setBorder(row, col, 1, 1);//Set Border
            //C19
            col = 18;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getX24());
            setBorder(row, col, 1, 1);//Set Border
            //C20
            col = 19;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getX36());
            setBorder(row, col, 1, 1);//Set Border
            //C21
            col = 20;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getX48());
            setBorder(row, col, 1, 1);//Set Border
            //C22
            col = 21;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getX40());
            setBorder(row, col, 1, 1);//Set Border

            //C23
            col = 22;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getDefectLoc());
            setBorder(row, col, 1, 1);//Set Border

            //C24
            col = 23;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getDefectType());
            setBorder(row, col, 1, 1);//Set Border

            //C25-26
            col = 24;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getPreEvaluation());
            setBorder(row, col, 1, 2);//Set Border
            cells.merge(row, col, 1, 2);

            //C27-28
            col = 26;

            cells.get(row, col).setValue(inspectionResultses.get(index - 1).getFinalEvaluation());
            setBorder(row, col, 1, 2);//Set Border
            cells.merge(row, col, 1, 2);

            index++;
        } else {

            //C1
            col = 0;

            setBorder(row, col, 1, 1);//Set Border

            //C2-3-4-5-6
            col = 1;

            setBorder(row, col, 1, 5);//Set Border
            cells.merge(row, col, 1, 5);

            //C7-8
            col = 6;

            setBorder(row, col, 1, 2);//Set Border
            cells.merge(row, col, 1, 2);

            //C9
            col = 8;

            setBorder(row, col, 1, 1);//Set Border
            //C10
            col = 9;

            setBorder(row, col, 1, 1);//Set Border
            //C11
            col = 10;

            setBorder(row, col, 1, 1);//Set Border

            //C12
            col = 11;

            setBorder(row, col, 1, 1);//Set Border

            //C13
            col = 12;

            setBorder(row, col, 1, 1);//Set Border

            //C14
            col = 13;

            setBorder(row, col, 1, 1);//Set Border

            //C15
            col = 14;

            setBorder(row, col, 1, 1);//Set Border

            //C16
            col = 15;

            setBorder(row, col, 1, 1);//Set Border
            //C17
            col = 16;

            setBorder(row, col, 1, 1);//Set Border
            //C18
            col = 17;

            setBorder(row, col, 1, 1);//Set Border
            //C19
            col = 18;

            setBorder(row, col, 1, 1);//Set Border
            //C20
            col = 19;

            setBorder(row, col, 1, 1);//Set Border
            //C21
            col = 20;

            setBorder(row, col, 1, 1);//Set Border
            //C22
            col = 21;

            setBorder(row, col, 1, 1);//Set Border

            //C23
            col = 22;

            setBorder(row, col, 1, 1);//Set Border

            //C24
            col = 23;

            setBorder(row, col, 1, 1);//Set Border

            //C25-26
            col = 24;

            setBorder(row, col, 1, 2);//Set Border
            cells.merge(row, col, 1, 2);

            //C27-28
            col = 26;

            setBorder(row, col, 1, 2);//Set Border
            cells.merge(row, col, 1, 2);

        }

    }
    
    //Create Last Section  Row
    private static void createLastSectionRow(int row, String field,String radiographer,String evaluated,String confirmation,String customer) {

        //C1-2-3-4-5-6
        col = 0;

        cells.get(row, col).setValue(field);
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 6);//Set Border
        cells.merge(row, col, 1, 6);

        //C7-12
        col = 6;

        cells.get(row, col).setValue(radiographer);
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 6);//Set Border
        cells.merge(row, col, 1, 6);

        //C13-18
        col = 12;

        cells.get(row, col).setValue(evaluated);
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 6);//Set Border
        cells.merge(row, col, 1, 6);

        //C19-22
        col = 18;

        cells.get(row, col).setValue(confirmation);
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 4);//Set Border
        cells.merge(row, col, 1, 4);

        //C23-28
        col = 22;

        cells.get(row, col).setValue(customer);
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 6);//Set Border
        cells.merge(row, col, 1, 6);

        cells.setRowHeight(row, 25);
        cells.setRowHeight(57, 50);

    }
    
    //Create Defect Type Row
    private static void createDefectRow(int row, String c0, String c1, String c4, String c14, String c15, String c18) {

        //String C1
        col = 0;

        cells.get(row, col).setValue(c0);
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 1);//Set Border

        //C2-3-4
        col = 1;

        cells.get(row, col).setValue(c1);
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C5-6-7-8-9-10-11-12-13-14
        col = 4;

        cells.get(row, col).setValue(c4);
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 10);//Set Border
        cells.merge(row, col, 1, 10);

        //C15
        col = 14;

        cells.get(row, col).setValue(c14);
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 1);//Set Border

        //C16-17-18
        col = 15;

        cells.get(row, col).setValue(c15);
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C19-20-21-22-23-24-25-26-27-28
        col = 18;

        cells.get(row, col).setValue(c18);
        setColor2(cells.get(row, col));//SET COLOR
        setBorder(row, col, 1, 10);//Set Border
        cells.merge(row, col, 1, 10);

    }
    
    //Check Checkbox OLD**
    private static void checkCheckboxOfEquipment(int row, int col) {

        /*  String temp = equipment.getFilmType();

        //Film Type Checkboxes
        if (temp.equals("0")) {
            s
            if (temp.equals("0")) {

                setCheckBoxWithValue(row, col, 20, 20, 1);
            } else {

                setCheckBoxWithValue(row, col, 20, 20, 0);
            }

            temp = equipment.getAstm();

            if (temp.equals("1")) {

                setCheckBoxWithValue(row, col, 20, 20, 1);
            } else {

            }

            temp = equipment.getSourceSide();

            if (temp.equals("2")) {

                setCheckBoxWithValue(row, col, 20, 20, 1);

            } else {

                setCheckBoxWithValue(row, col, 20, 20, 0);
            }

            temp = equipment.getFilmSide();

            if (temp.equals("3")) {

                setCheckBoxWithValue(row, col, 20, 20, 1);

            } else {

                setCheckBoxWithValue(row, col, 20, 20, 0);
            }

            //Film Process Type Checkboxes
            temp = equipment.getAutomatic();

            if (temp.equals("0")) {

                setCheckBoxWithValue(row, col, 20, 20, 1);

            } else {

                setCheckBoxWithValue(row, col, 20, 20, 0);
            }

            temp = equipment.getManual();

            if (temp.equals("1")) {

                setCheckBoxWithValue(row, col, 20, 20, 1);

            } else {

                setCheckBoxWithValue(row, col, 20, 20, 0);
            }
            setCheckBoxWithValue(row, col, 20, 20, 1);

        } else if (temp.equals("1")) {

            setCheckBoxWithValue(row, col, 20, 20, 1);
        } else if (temp.equals("2")) {

            setCheckBoxWithValue(row, col, 20, 20, 1);
        } else {
            setCheckBoxWithValue(row, col, 20, 20, 0);
        }

        //IQI Checkboxes
        temp = equipment.getEn();

        if (temp.equals("0")) {

            setCheckBoxWithValue(row, col, 20, 20, 1);
        } else {

            setCheckBoxWithValue(row, col, 20, 20, 0);
        }

        temp = equipment.getAstm();

        if (temp.equals("1")) {

            setCheckBoxWithValue(row, col, 20, 20, 1);
        } else {

        }

        temp = equipment.getSourceSide();

        if (temp.equals("2")) {

            setCheckBoxWithValue(row, col, 20, 20, 1);

        } else {

            setCheckBoxWithValue(row, col, 20, 20, 0);
        }

        temp = equipment.getFilmSide();

        if (temp.equals("3")) {

            setCheckBoxWithValue(row, col, 20, 20, 1);

        } else {

            setCheckBoxWithValue(row, col, 20, 20, 0);
        }

        //Film Process Type Checkboxes
        temp = equipment.getAutomatic();

        if (temp.equals("0")) {

            setCheckBoxWithValue(row, col, 20, 20, 1);

        } else {

            setCheckBoxWithValue(row, col, 20, 20, 0);
        }

        temp = equipment.getManual();

        if (temp.equals("1")) {

            setCheckBoxWithValue(row, col, 20, 20, 1);

        } else {

            setCheckBoxWithValue(row, col, 20, 20, 0);
        }
         */
    }
    
    //--------------------------------------------------------------------------
    
    //Getter Setters
    
    
    //Set Customer
    public static void setCustomer(CustomerTab customer) {

        ExcelExporterAsposeReport1.customer = customer;
    }
    
    //Set Equipment
    public static void setEquipment(REquipmentTab equipment) {

        ExcelExporterAsposeReport1.equipment = equipment;
    }
    
    //Set Test Arrangements
    public static void setTestArrangements(RTestArrangements testArrangements) {

        ExcelExporterAsposeReport1.testArrangements = testArrangements;
    }
    
    //Set Inspeciton Results
    public static void setInspectionResults(Vector<RInspectionResults> inspectionResultses) {

        ExcelExporterAsposeReport1.inspectionResultses = inspectionResultses;
    }
    
    //Set Opearator
    public static void setOperator(String operator) {
        ExcelExporterAsposeReport1.operator = operator;
    }
    
    //Set Evaluated
    public static void setEvaluated(String evaluated) {
        ExcelExporterAsposeReport1.evaluated = evaluated;
    }
    
    
    //Set Confirmation
    public static void setConfirmation(String confirmation) {
        ExcelExporterAsposeReport1.confirmation = confirmation;
       
    }
    //--------------------------------------------------------------------------
    
    //Setting Styles
    
    //Set Color OLD
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
    
    //Set Color
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
    
    //Set Top Left
    private static void setTopLeft(Cell cell) {

        Style style = cell.getStyle();

        style.setVerticalAlignment(TextAlignmentType.TOP);

        style.setHorizontalAlignment(TextAlignmentType.LEFT);

        cell.setStyle(style);

    }
    
    //Set Width 
    private static void setWidthHeight() {

        worksheet.getCells().setStandardWidth(6);

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
    
    //Set Check Box
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

}
