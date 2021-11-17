package Excel2Json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ExportList {


    public static void main(String[] args) throws IOException {
        List<StudentJson> Student = readJsonFile2Objects();
        readExcelFile(Student);

    }

    private static List<StudentJson> readJsonFile2Objects() throws IOException {
        InputStream inJson = StudentJson.class.getResourceAsStream("Test.json");
        List<StudentJson> Student = null;

        try {
            Student = new ObjectMapper().readValue(inJson, new TypeReference<List<StudentJson>>(){});
        }
        catch (JsonParseException e)
        {
            e.printStackTrace();
        }



        return Student;
    }

    private static void readExcelFile(List<StudentJson> student) {
        try{

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("sheet1");// creating a blank sheet
        int rownum = 0;
        for (StudentJson studentJson :student)
        {
            Row row = sheet.createRow(rownum++);
            createList(studentJson, row);

        }

        FileOutputStream out = new FileOutputStream(new File("NewFile.xlsx")); // file name with path
        workbook.write(out);
        out.close();

        }
        catch (Exception e)
    {
        e.printStackTrace();
    }
    }

    private static void createList(StudentJson studentJson, Row row) // creating cells for each row
    {
        Cell cell = row.createCell(0);
        cell.setCellValue(studentJson.getName());

        cell = row.createCell(1);
        cell.setCellValue(studentJson.getAge());

        cell = row.createCell(2);
        cell.setCellValue(studentJson.getTotalMarks());

    }
    }