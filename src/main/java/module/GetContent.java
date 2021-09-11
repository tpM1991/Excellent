package module;

public class GetContent {
    private Object getCellValue(Cell cell)
    {


        switch (cell.getCellType()) {

            // Case 1
            // If cell contents are string
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();

            // Case 2
            // If cell contents are Boolean
            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();

            // Case 3
            // If cell contents are Numeric which includes
            // int, float , double etc
            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
        }

        // Case 4
        // Default case
        // If cell contents are neither
        // string nor Boolean nor Numeric,
        // simply nothing is returned
        return null;
    }
}
