package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	public String ReadData(String sh, int rowmun, int cellnum) throws Exception {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestDate.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		DataFormatter df= new DataFormatter();
		return df.formatCellValue(wb.getSheet(sh).getRow(rowmun).getCell(cellnum));

	}

	public void createCellAndAddValue(String sh, int rownum, int cellnum, String projectId) throws Exception {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestDate.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Cell c = wb.getSheet(sh).getRow(rownum).createCell(cellnum);
		c.setCellValue(projectId);
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestDate.xlsx");
		wb.write(fos);
		wb.close();

	}
	
	public int getRowCount(String sh) throws Exception
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestDate.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sh);
		return sheet.getLastRowNum();
		
	}

}
