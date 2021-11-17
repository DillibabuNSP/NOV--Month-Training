package Excel2Json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Excel2Json {
    List<Students> Stud;
    public void GetReadFile() throws IOException {
        FileInputStream fis= new FileInputStream("C:\\Users\\NSP\\Desktop\\Test.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rows = sheet.iterator();

         Stud = new ArrayList<>();

        int rowNumber = 0;
        while (rows.hasNext()) {
            Row currentRow = rows.next();

            // skip header
            if(rowNumber == 0) {
                rowNumber++;
                continue;
            }

            Iterator<Cell> cellsInRow = currentRow.iterator();

             Students cust = new Students();

            int cellIndex = 0;
            while (cellsInRow.hasNext()) {
                Cell currentCell = cellsInRow.next();
                if(cellIndex==0){
                    cust.setName(currentCell.getStringCellValue());
                }
                else if(cellIndex==1){
                    cust.setAge((int) currentCell.getNumericCellValue());
                }
                else if(cellIndex==2){
                    cust.setTotalMarks((int) currentCell.getNumericCellValue());
                }
                cellIndex++;
            }

            Stud.add(cust);
        }

        // Close WorkBook
        workbook.close();
        System.out.println(Stud);
    }

    public void GetJsonFile() throws IOException {
        ObjectMapper obj =new ObjectMapper();
        File file = new File("Test.json");
        obj.writerWithDefaultPrettyPrinter().writeValue(file,Stud);
    }
    public static void main(String[] args) throws IOException {
        Excel2Json ref = new Excel2Json();
        ref.GetReadFile();
        ref.GetJsonFile();
    }
}