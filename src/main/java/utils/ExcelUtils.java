package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private static Workbook workbook;
    private static Sheet sheet;

    // Load Excel file . were creating a function to get our Excel file
    public static void loadExcel(String filePath, String sheetName) throws IOException {

        FileInputStream file = new FileInputStream(filePath); // use FileInputStream to get file path. it may throw
                                                              // FileNotFoundException if the file path is invalid.
        // Java requires checked exceptions to be handled. Option 1) try/catch > handles
        // the exception.
        // Option 2) throws > pass the responsibility to the calling method
        // if nobody handles it, the ecveption eventually reaches TestNG and the test
        // fails.
        workbook = new XSSFWorkbook(file); // for .xlsx
        // workbook = new HSSFWorkbook(file); // for .xls
        sheet = workbook.getSheet(sheetName);
    }

    // Get Cell data as String
    public static String getCellData(int row, int column) {

        Cell cell = sheet.getRow(row).getCell(column);
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((int) cell.getNumericCellValue()); // if cell is intigers then conver to string. use
                                                                     // type casting EX: String.valueOf((int)...())
        }
        return ""; // else return null string
    }

    // Get total rows
    public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    // Close workbook
    public static void closeExcel() throws IOException {
        workbook.close();
    }
}
