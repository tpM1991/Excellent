package module;

import modell.Dwarf;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetContent {


    private Object getCellValue(Cell cell) {


        switch (cell.getCellType()) {

            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();


            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();


            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
        }


        return null;
    }

    public List<Dwarf> readDataFromExcelFile(String excelFilePath)
            throws IOException {

        List<Dwarf> dwarves = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);

        Iterator<Row> iterator = firstSheet.iterator();

        while (iterator.hasNext()) {

            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            Dwarf dwarf = new Dwarf();
            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();

                switch (columnIndex) {

                    case 0:
                        dwarf.setName((String) getCellValue(nextCell));
                        break;

                    case 1:
                        dwarf.setFaveFruit((String) getCellValue(nextCell));
                        break;

                    case 2:
                         dwarf.setFaveNum((Double) getCellValue(nextCell));  //TODO WHY Double???
                        break;
                }
            }

            dwarves.add(dwarf);
        }
        workbook.close();
        inputStream.close();

        return dwarves;
    }
}
