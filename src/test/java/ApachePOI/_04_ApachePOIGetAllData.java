package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _04_ApachePOIGetAllData {
    public static void main(String[] args) throws IOException {
        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheet("Sheet1");

        //zoo.length : kaç satır olduğunu
        int rowCount=sheet.getPhysicalNumberOfRows(); // Kaç tane satır var
        System.out.println("rowCount = " + rowCount);

        for (int i = 0; i < rowCount; i++) {



        }

    }
}
