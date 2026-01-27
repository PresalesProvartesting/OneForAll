package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="SDO_Partner_Central"                                
     , summary=""
     , relativeUrl=""
     , connection="SDO_Partner_Central"
     )             
public class SDO_Partner_Central {

	@TextType()
	@FindBy(xpath = "//button[normalize-space(.)='Support']//span/lightning-primitive-icon")
	public WebElement support;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='Support']")
	public WebElement support1;
	@LinkType()
	@FindBy(xpath = "//a[normalize-space(.)='Support Home']")
	public WebElement supportHome;
	@ButtonType()
	@FindBy(xpath = "//button[normalize-space(.)='Contact Support']")
	public WebElement contactSupport;
	@TextType()
	@FindBy(xpath = "//fieldset//input")
	public WebElement renderFacet16520;
	@LinkType()
	@JavascriptBy(jspath = "return document.querySelector('div.uiPopupTrigger > div > div > a')")
	public WebElement commercialProducts;
	@TextType()
	@FindBy(xpath = "//textarea")
	public WebElement renderFacet16710;
	
			
}
