package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.provar.core.model.base.java.WebComponent;
import com.provar.core.testapi.annotations.*;

@Page( title="Experience_Cloud"                                
     , summary=""
     , relativeUrl=""
     , connection="Partner_Centeral"
     )             
public class Experience_Cloud {

private static final String ChoiceListType = null;
WebDriver driver;
public Experience_Cloud(WebDriver driver){
this.driver=driver;
}

	@ButtonType()
	@FindBy(xpath = "//div[@data-region-name='content']//button[normalize-space(.)='Contact Support']")
	public WebElement Contact_Support;
	@TextType()
	@FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Case.Subject']//input")
	public WebElement Test_Subject;
	@ChoiceListType()
	@FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Case.Product_Family_KB__c']//a")
	public WebElement Commercial_Products;
	@TextType()
	@FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Case.Description']//textarea")
	public WebElement Description;
	@ButtonType()
	@FindBy(xpath = "//div[@data-region-name='content']//button[normalize-space(.)='Upload File']")
	public WebElement uploadFile;
	@ButtonType(file=true)
	@FindBy(xpath = "//div[contains(@class, 'active') and contains(@class, 'open') and (contains(@class, 'forceModal') or contains(@class, 'uiModal'))][last()]//button[normalize-space(.)='Upload File']")
	public WebElement uploadFile1;
	@FindBy(xpath = "//button[contains(normalize-space(.),'Support') and @type='submit']/lightning-icon[contains(@class,'lwc-59kp5sov61j') and contains(@class,'slds-current-color') and contains(@class,'slds-p-left_x-small') and contains(@class,'slds-icon-utility-chevrondown') and contains(@class,'slds-icon_container')]")
	@WebComponentMapping(componentId = "88107c76-5ad8-4e6a-8477-884f9baa3d11")
	public WebComponent support;
	@LinkType()
	@FindBy(xpath = "//div[@data-region-name='nav']//a[@title='Support Home']")
	public WebElement supportHome;
	@ButtonType()
	@FindBy(xpath = "//div[contains(@class, 'active') and contains(@class, 'open') and (contains(@class, 'forceModal') or contains(@class, 'uiModal'))][last()]//button[normalize-space(.)='Done']")
	public WebElement done;
	@LinkType()
	@FindBy(xpath = "//div[normalize-space(.)='Case Number:']/following-sibling::div//a")
	public WebElement Case_Number;
	@ButtonType()
	@FindBy(xpath = "//div[@data-region-name='content']//button[normalize-space(.)='Submit']")
	public WebElement submit;
	@LinkType()
	@FindBy(xpath = "//a[@title='Commercial Products']")
	public WebElement commercialProductLisst;
	
	public void ProductFamilyPicklist(String PicklistValue ){
	driver.findElement(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Case.Product_Family_KB__c']//a")).click();
	driver.findElement(By.xpath("//a[@title='"+PicklistValue+"']")).click();
	
	}
	
	
	public void FileUpload(String FilePath) throws AWTException, InterruptedException{
		driver.findElement(By.xpath("//div[contains(@class, 'active') and contains(@class, 'open') and (contains(@class, 'forceModal') or contains(@class, 'uiModal'))][last()]//button[normalize-space(.)='Upload File']")).click();
	
		Thread.sleep(2000);
		
		StringSelection file = new StringSelection(
		        FilePath
		);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
		
		Robot robot = new Robot();
		robot.delay(500);
		
		// CTRL + V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		// ENTER
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);		
	}
}
