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
import fxreportmanagement.Report1.Entitates.RInspectionResults;
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

    private static Vector<RInspectionResults> inspectionResultses;

    private static int row;

    private static int col;

    private static int index = 1;

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
            workbook.save("Report1.xls");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

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
    
    private static void exportCustomer() {

        //---------------------Row 3-----------------------------------------//        
        row = 2;

        createCustomerRow(row, "Customer", "", "Inspection Precedure", "", "Page", "");

        //---------------------Row 4-----------------------------------------//        
        row = 3;

        createCustomerRow(row, "Project Name", "", "Inspection Scope", "", "Report No", "");

        //---------------------Row 5-----------------------------------------//        
        row = 4;

        createCustomerRow(row, "Inspection Place", "", "Drawing No", "", "Report Date", "");

        //---------------------Row 6-----------------------------------------//        
        row = 5;

        createCustomerRow(row, "Inspection Standart", "", "Surface Condition", "", "Job Order No", "");

        //---------------------Row 7-----------------------------------------//        
        row = 6;

        createCustomerRow(row, "Evaluation Standart / Accep.Level", "", "Stage Of Examination", "", "Offer No", "");

    }

    
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
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 2, 2);//Set Border
        cells.merge(row, col, 2, 2);

        //C11-12
        col = 10;
        cells.get(row, col).setValue("Se-75");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 2, 2);//Set Border
        cells.merge(row, col, 2, 2);

        //C13-14-15
        col = 12;
        cells.get(row, col).setValue("X-Ray");
        setColor2(cells.get(row, col));//SET COLOR
        setCenter(cells.get(row, col));//Set Center
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

        cells.get(row, col).setValue("Equipment");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C3-4-5-6-7-8
        col = 2;

        cells.get(row, col).setValue("Used Device");
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

        cells.get(row, col).setValue("Focal Shoot Size");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C19-20
        col = 18;

        cells.get(row, col).setValue("Exposure Time");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);
        //C21-22-23
        col = 20;

        cells.get(row, col).setValue("Film Focus Distance");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C24-25-26
        col = 23;

        cells.get(row, col).setValue("Pb Scenes");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C27-28
        col = 26;

        cells.get(row, col).setValue("Filters");
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

        cells.get(row, col).setValue("-");
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

        cells.get(row, col).setValue(" ");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C10-11-12
        col = 9;

        cells.get(row, col).setValue(" ");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C13-14
        col = 12;

        cells.get(row, col).setValue(" ");
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C15-16-17
        col = 14;

        cells.get(row, col).setValue(" ");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C18-19
        col = 17;

        cells.get(row, col).setValue(" ");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C20-21
        col = 19;

        cells.get(row, col).setValue("");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C22-23
        col = 21;

        cells.get(row, col).setValue(" ");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C24-25
        col = 23;

        cells.get(row, col).setValue("");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C26-27-28
        col = 25;

        cells.get(row, col).setValue("");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

    }

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

        cells.get(row, col).setValue(" ");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 5);//Set Border
        cells.merge(row, col, 1, 5);

        //C8-9
        col = 7;

        cells.get(row, col).setValue(" ");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C10-11-12
        col = 9;

        cells.get(row, col).setValue(" ");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //13-14-15
        col = 12;

        cells.get(row, col).setValue(" ");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C16-17-18
        col = 15;

        cells.get(row, col).setValue(" ");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //C19-20
        col = 18;

        cells.get(row, col).setValue(" ");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C21-22-23
        col = 20;

        cells.get(row, col).setValue("");
        setCenter(cells.get(row, col));//Set Center
        setBorder(row, col, 1, 3);//Set Border
        cells.merge(row, col, 1, 3);

        //24-25-26-27-28
        col = 23;

        cells.get(row, col).setValue("");
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
        setCheckBox(row, 3, 20, 40);//Set Checkbox

        //C6-7-8-9
        col = 5;
        cells.merge(row, col, 2, 4);
        setCheckBox(row, 7, 20, 40);//Set Checkbox

        //C10-11-12-13
        col = 9;
        cells.merge(row, col, 2, 4);
        setCheckBox(row, 11, 20, 40);//Set Checkbox

        //C14-15-16-17-18
        col = 13;
        cells.merge(row, col, 2, 5);
        setCheckBox(row, 15, 20, 40);//Set Checkbox

        //C19-20-21-22-23
        col = 18;
        cells.merge(row, col, 2, 5);
        setCheckBox(row, 20, 20, 40);//Set Checkbox

        //C24-25-26-27-28
        col = 23;
        cells.merge(row, col, 2, 5);
        setCheckBox(row, 25, 20, 40);//Set Checkbox

    }

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

        createLastSectionRow(54, "Name Surname");
        createLastSectionRow(55, "Level");
        createLastSectionRow(56, "Date");
        createLastSectionRow(57, "Signature");

    }

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

    private static boolean verifyVector(Vector<RInspectionResults> vector, int index) {

        System.out.println("index " + index + "size  " + vector.size());
        boolean result = true;
        if (index > vector.size()) {
            return false;
        }
        System.out.println("index<size");
        return result;
    }

    private static void setInspectionResultsRow(int row) {

        cells.setRowHeight(row, 25);

        //C1
        col = 0;

        cells.get(row, col).setValue(index);
        setBorder(row, col, 1, 1);//Set Border

        //C2-3-4-5-6
        col = 1;

        cells.get(row, col).setValue("");
        setBorder(row, col, 1, 5);//Set Border
        cells.merge(row, col, 1, 5);

        //C7-8
        col = 6;

        cells.get(row, col).setValue("");
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C9
        col = 8;

        cells.get(row, col).setValue("");
        setBorder(row, col, 1, 1);//Set Border
        //C10
        col = 9;

        cells.get(row, col).setValue("");
        setBorder(row, col, 1, 1);//Set Border
        //C11
        col = 10;

        cells.get(row, col).setValue("");
        setBorder(row, col, 1, 1);//Set Border

        //C12
        col = 11;

        cells.get(row, col).setValue("");
        setBorder(row, col, 1, 1);//Set Border

        //C13
        col = 12;

        cells.get(row, col).setValue("");
        setBorder(row, col, 1, 1);//Set Border

        //C14
        col = 13;

        cells.get(row, col).setValue("");
        setBorder(row, col, 1, 1);//Set Border

        //C15
        col = 14;

        cells.get(row, col).setValue("");
        setBorder(row, col, 1, 1);//Set Border

        //C16
        col = 15;

        cells.get(row, col).setValue("");
        setBorder(row, col, 1, 1);//Set Border
        //C17
        col = 16;

        cells.get(row, col).setValue("");
        setBorder(row, col, 1, 1);//Set Border
        //C18
        col = 17;

        cells.get(row, col).setValue("");
        setBorder(row, col, 1, 1);//Set Border
        //C19
        col = 18;

        cells.get(row, col).setValue("");
        setBorder(row, col, 1, 1);//Set Border
        //C20
        col = 19;

        cells.get(row, col).setValue("");
        setBorder(row, col, 1, 1);//Set Border
        //C21
        col = 20;

        cells.get(row, col).setValue("");
        setBorder(row, col, 1, 1);//Set Border
        //C22
        col = 21;

        cells.get(row, col).setValue("");
        setBorder(row, col, 1, 1);//Set Border

        //C23
        col = 22;

        cells.get(row, col).setValue("");
        setBorder(row, col, 1, 1);//Set Border

        //C24
        col = 23;

        cells.get(row, col).setValue("");
        setBorder(row, col, 1, 1);//Set Border

        //C25-26
        col = 24;

        cells.get(row, col).setValue("");
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        //C27-28
        col = 26;

        cells.get(row, col).setValue("");
        setBorder(row, col, 1, 2);//Set Border
        cells.merge(row, col, 1, 2);

        index++;

    }

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
        cells.setRowHeight(57, 50);

    }

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

    private static void setColor2(Cell cell) {

        Style style = cell.getStyle();
        style.setForegroundColor(color);
        style.setPattern(BackgroundType.SOLID);
        cell.setStyle(style);

    }

    private static void setBorder(int firstRow, int firstColumn, int totalRow, int totalColumn) {

        Range range = worksheet.getCells().createRange(firstRow, firstColumn, totalRow, totalColumn);
        range.setName("MyRange");

        range.setOutlineBorders(CellBorderType.THIN, Color.getBlack());

    }

    private static void setBorderRight(int firstRow, int firstColumn, int totalRow, int totalColumn) {

        Range range = worksheet.getCells().createRange(firstRow, firstColumn, totalRow, totalColumn);
        range.setName("MyRange");

        range.setOutlineBorder(CellBorderType.THIN, BorderType.RIGHT_BORDER, Color.getBlack());

    }

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

    private static void setCenter(Cell cell) {

        Style style = cell.getStyle();
        style.setHorizontalAlignment(TextAlignmentType.CENTER);

        cell.setStyle(style);

    }

    private static void setVertical(Cell cell) {

        Style style = cell.getStyle();
        style.setRotationAngle(-90);
        cell.setStyle(style);

        cell.setStyle(style);

    }

    private static void setWidthHeight() {

        worksheet.getCells().setStandardWidth(6);

    }

    private static void setPicture(int upperLeftRow, int upperLeftCol, int lowerRightRow, int lowerRightcol, String fileName) {

        String dataDir = "C:/Users/ofaar/Documents/GitHub/fxreportmanagement/FxReportManagement/src/fxreportmanagement/Resources/" + fileName + ".PNG";

        try {
            int index = worksheet.getPictures().add(upperLeftRow, upperLeftCol, lowerRightRow, lowerRightcol, dataDir);
            Picture picture = worksheet.getPictures().get(index);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static void setCheckBox(int upperLeftRow, int upperLeftColumn, int height, int width) {

        int index = worksheet.getCheckBoxes().add(upperLeftRow, upperLeftColumn, height, width);
        CheckBox checkBox = worksheet.getCheckBoxes().get(index);

    }
}
