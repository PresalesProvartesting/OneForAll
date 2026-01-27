package pageobjects.CPQ;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.provar.core.testapi.annotations.*;
import com.provar.core.testapi.annotations.SteelBrickBy.Facet;
@SalesforcePage( title="Sbqq__ Applei Phone X Package__ CPQ Product"                                
               , summary=""
               , page="sb"
               , namespacePrefix="SBQQ"
               , object=""
               , connection="CPQ"
     )             
public class sbqq__AppleiPhoneXPackage__CPQProduct {
	@PageRow()
	public static class ConfigureProductsLines {
	}
	@SteelBrickBy(pageTableRow = "sb-product-option-table#ot")
	@PageTable(firstRowContainsHeaders = false, row = ConfigureProductsLines.class)
	public List<ConfigureProductsLines> configureProductsLines;
	@ButtonType()
	@SteelBrickBy(customAction = "pcSave")
	public WebElement save;
	@PageRow()
	public static class ConfigureProductsLinesMemC {
	}
	@SteelBrickBy(pageFeatureName = "Memory Cards", pageTableRow = "sb-product-feature-list")
	@PageTable(firstRowContainsHeaders = false, row = ConfigureProductsLinesMemC.class)
	public List<ConfigureProductsLinesMemC> configureProductsLinesMemC;
}
