package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="My Page Object"                                
     , summary=""
     , relativeUrl=""
     , connection="CPQ_org"
     )             
public class MyPageObject {

	@LinkType()
	@FindBy(xpath = "//div[@data-region-name='content']//a")
	public WebElement _00001409;
			
}
