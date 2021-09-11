import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import modell.Dwarf;
import module.GetContent;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class Main {
    public static void main(String[] args) {

        String filePath = "src/main/resources/myTestFile.xlsx";

        GetContent getContentFromExcelSheets = new GetContent();

        List<Dwarf> extractedDwarfData = new ArrayList<Dwarf>();

        // Try block to check if any exception/s occurs
        try {
            // excelFileContents.xlsx location need to be
            // specified correctly or else IOException will be
            // thrown. If file is available in that location, it
            // gets the data and stored in a list variable
            extractedDwarfData = getContentFromExcelSheets.readDataFromExcelFile(
                    filePath);
        } catch (IOException e) {

            // Print the line number and exception
            // in the program
            e.printStackTrace();
        }

        for (Dwarf dwarf:extractedDwarfData) {
            System.out.println(dwarf);
        }

    }
}
