package Excel2Json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class ExportList {


    public static void main(String[] args) throws IOException {
        List<StudentJson> Student = readJsonFile2Objects();
        readExcelFile(Student);

    }

    private static List<StudentJson> readJsonFile2Objects() throws IOException {
        FileInputStream inJson =new FileInputStream("Test.json");
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
        String[] COLUMNS = { "Name", "Age", "TotalMarks"};
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("sheet1");




            Font headerFont = workbook.createFont();
            headerFont.setItalic(true);
            headerFont.setColor(IndexedColors.BLACK1.getIndex());
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerCellStyle.setFont(headerFont);

            int row1=0;
            Row headerRow = sheet.createRow(row1);

            for (int col = 0; col < COLUMNS.length; col++) {

                Cell cell = headerRow.createCell(col);
                cell.setCellValue(COLUMNS[col]);
                cell.setCellStyle(headerCellStyle);
            }


            int rownum=1;
        for (StudentJson studentJson :student)
        {

            Row row = sheet.createRow(rownum++);
            createList(studentJson, row);

        }

        FileOutputStream out = new FileOutputStream(new File("NewFile.xlsx"));
        workbook.write(out);
        out.close();

        }
        catch (Exception e)
    {
        e.printStackTrace();
    }

    }
    private static void createList(StudentJson studentJson, Row row)
    {

        Cell cell = row.createCell(0);
        cell.setCellValue(studentJson.getName());

        cell = row.createCell(1);
        cell.setCellValue(studentJson.getAge());

        cell = row.createCell(2);
        cell.setCellValue(studentJson.getTotalMarks());

    }
    }