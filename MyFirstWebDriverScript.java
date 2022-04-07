package test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstWebDriverScript {
	public static WebDriver driver;
	public static Properties prop;
	public static String sAppURL;
	public static String username;
	public static String password;
	static String[] data = null;
	
	//This function is used to read data from specified cell of Excel sheet once you give Excelsheet name and path
	
			public static String[] HA_GF_readXL (int row, String column, String strFilePath) throws IOException 
			{
				
				File file =    new File("E:\\Workspace\\TestAutomation\\DataPool\\HA_HotelSearch.xls");
				FileInputStream inputStream = new FileInputStream(file);
				HSSFWorkbook wb=new HSSFWorkbook(inputStream);
				HSSFSheet sheet=wb.getSheet("location");
				
				HSSFRow row1=sheet.getRow(1);
						
				int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
				data = new String[rowCount];
		        System.out.println(rowCount);
		        
		        //iterate over all the row to print the data present in each cell.
		        for(int i=0;i<=rowCount;i++){
		            
		            //get cell count in a row
		        	int cellcount=sheet.getRow(i).getLastCellNum();
		            System.out.println(cellcount);
		            //iterate over each cell to print its value
		            System.out.println("Row"+ i+" data is :");
		            
		            for(int j=0;j<=cellcount;j++){
		            	data[i] = sheet.getRow(i).getCell(j).getStringCellValue();
		                System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() +",");
		            }
		            System.out.println();
		        }
		    
			//System.out.println("NO MATCH FOUND IN GIVEN FILE: PROBLEM IS COMING FROM DATA FILE");
			
			return data;
			}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		try {
			prop = new Properties();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  prop.load(new FileInputStream("E:\\Workspace\\TestAutomation\\Configuration\\HA_Configuration.properties"));
		  sAppURL = prop.getProperty("sAppURL");
		  username = prop.getProperty("uname");
		  password = prop.getProperty("pwd");
		  System.out.println(sAppURL);
		  System.out.println(username);
		  System.out.println(password);
		System.setProperty("webdriver.chrome.driver", "E:\\drivers\\ChromeNew\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(sAppURL);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		String []slocation = HA_GF_readXL(1,"Location","E:\\Workspace\\TestAutomation\\DataPool\\HA_HotelSearch.xls");
		//String s1 = driver.findElement(By.xpath("//*[@id=\'login_form\']/table/tbody/tr[5]/td[2]/div/b")).getText();
		//System.out.println(s1);
		
		//File opfile = new File("E:\\Workspace\\TestAutomation\\output\\output.txt");
		//FileWriter fw = new FileWriter(opfile);
		//fw.append(s1);
		//fw.write("\n");
		//fw.write("Sample");
		//fw.close();
		int rowsize = slocation.length;
		//int colsize =slocation[0].length;
		System.out.println(rowsize);
		//System.out.println(colsize);
		
		for(int i=1;i<=rowsize;i++)
		{
			
				System.out.println(slocation[i]);
			
		}
	}

}
