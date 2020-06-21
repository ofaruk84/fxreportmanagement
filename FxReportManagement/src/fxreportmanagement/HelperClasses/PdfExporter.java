/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.HelperClasses;

import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import fxreportmanagement.DatabaseOperations.DatabaseAccess.EmployeeDal;
import java.util.Scanner;

/**
 *
 * @author Faruk
 *
 * Ömer Faruk Korkmaz 
 * 170503014
 */
public class PdfExporter {

    private static Workbook workbook = null;
    private static Worksheet worksheet = null;
    private static PdfSaveOptions saveOptions = null;

    public static void exportPDF(String fileName) {

        try {
            workbook = new Workbook(fileName + ".xlsx");
            workbook.getWorksheets().add();
            saveOptions = new PdfSaveOptions(SaveFormat.PDF);
            worksheet = workbook.getWorksheets().get(0);
            worksheet.getPageSetup().setFitToPagesWide(1);
            worksheet.getPageSetup().setFitToPagesTall(0);

            String datadir = fileName + ".pdf";
            workbook.save(datadir, saveOptions);
        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

}
