package cn.tjuscs.selenium;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



public class Lab2 {
   
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private String[] stuId = new String[145];
	  private String[] stuPw = new String[145];
	  private String[] stuGit = new String[145];
	  //将excel文件数据存储在数组中

	  //@Before的setUp方法中完成驱动的配置，以及baseurl 的设定
	  @Before
	  public void setUp() throws Exception {
		  //xlsx文件存在一些问题，通过wps转成xls后问题消失
		  File f = new File("E:" + File.separator + "文件" + File.separator + "软件测试名单.xls");
		  try {
			  Workbook book = Workbook.getWorkbook(f);
			  Sheet sheet = book.getSheet(0);
			  for ( int i = 2 ; i < sheet.getRows(); i ++ ) {
				  Cell cell = sheet.getCell(1,i);
				  stuId[i-2] = cell.getContents();
				  int longth = stuId[i-2].length();
				  if(longth >= 6) {
					  stuPw[i-2] = stuId[i-2].substring(longth-6, longth);
				  }
				  cell = sheet.getCell(3,i);
				  stuGit[i-2] = cell.getContents();
			  }
		  }catch(BiffException e) {
			  e.printStackTrace();
		  }catch(IOException e) {
			  e.printStackTrace();
		  }
		  
		  
		String driverPath=System.getProperty("user.dir") + "/src/resources/driver/geckodriver.exe";
		  System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  baseUrl = "http://121.193.130.195:8800/";
		  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testLab2() throws Exception {
	    driver.get(baseUrl + "/");
	    for ( int i = 0 ; i <= 10 ; i ++ ) {
	    //for( int i = 11 ; i <= 30 ; i ++ ) {
	    //for ( int i = 31 ; i <= 70 ; i ++ ) {
	    //for ( int i = 0 ; i <= 142 ; i ++ ) {
	    	//通过selenium完成一整次步骤探测完整操作流程
		    driver.findElement(By.name("id")).sendKeys(stuId[i]);
		    driver.findElement(By.name("password")).sendKeys(stuPw[i]);
		    WebElement btn = driver.findElement(By.id("btn_login"));
		    btn.sendKeys(Keys.ENTER);
		    assertEquals(stuGit[i], driver.findElement(By.id("student-git")).getText());
		    WebElement btn1 = driver.findElement(By.id("btn_logout"));
		    btn1.sendKeys(Keys.ENTER);
		    WebElement btn2 = driver.findElement(By.id("btn_return"));
		    btn2.sendKeys(Keys.ENTER);
	    }

	  }

	  @After
	  public void tearDown() throws Exception {
//	    driver.quit();
//	    String verificationErrorString = verificationErrors.toString();
//	    if (!"".equals(verificationErrorString)) {
//	      fail(verificationErrorString);
//	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}