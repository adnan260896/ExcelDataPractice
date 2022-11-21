package DataDrivenExcel.ExcelDataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainTest extends BrowserLaunchTest {

	DataFormatter format = new DataFormatter();
	@Test(dataProvider = "exceldata")
	public void testrun(String str, String str2)
	{
		lp.Enter_username(str);
		lp.Enter_pwd(str2);
		lp.Click_button();
		System.out.println("Test case successfully executed!");
	}
	
	@DataProvider
	public Object[][] exceldata() throws IOException
	{
		Object[][] obj = new Object[2][2];
		FileInputStream fis = new FileInputStream("D:\\SeleniumExcel\\LoginCredentials.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet =wb.getSheetAt(0);
		int row =sheet.getLastRowNum();
		//XSSFRow r =sheet.getRow(0);
		
		for(int i=0;i<row;i++)
		{
			XSSFRow r =sheet.getRow(i+1);
			for(int j=0;j<row-1;j++) 
			{
				XSSFCell cell =r.getCell(j);
				obj[i][j] =format.formatCellValue(cell);
			}
		}
		//wb.close();
		return obj;
		
	}
}
