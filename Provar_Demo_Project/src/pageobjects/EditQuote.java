package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.provar.core.testapi.annotations.BooleanType;
import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.ChoiceListType;
import com.provar.core.testapi.annotations.PageRow;
import com.provar.core.testapi.annotations.PageTable;
import com.provar.core.testapi.annotations.SalesforcePage;
import com.provar.core.testapi.annotations.SteelBrickBy;
import com.provar.core.testapi.annotations.TextType;
import com.provar.core.testapi.annotations.SteelBrickBy.Facet;

@SalesforcePage( title="Edit Quote"                                
               , summary=""
               , page="sb"
               , namespacePrefix="SBQQ"
               , object=""
               , connection="CPQ_New"
     )             
public class EditQuote {

	@ButtonType()
	@SteelBrickBy(customAction = "Add Products")
	public WebElement addProducts;

	@PageRow()
	public static class ProductSelectionLines {

		@BooleanType()
		@SteelBrickBy(fieldSetTableItem = "checkbox")
		public WebElement checkbox;
		@TextType()
		@SteelBrickBy(fieldSetTableItem = "Product2.ProductCode")
		public WebElement productCode;
	}

	@SteelBrickBy(locatorType = "XPath", pageTableRow = "//sb-lookup-layout[@id=\"lookupLayout\"]")
	@PageTable(firstRowContainsHeaders = false, row = ProductSelectionLines.class)
	public List<ProductSelectionLines> productSelectionLines;
	@ChoiceListType()
	@SteelBrickBy(fieldSetTableItem = "sb-pricebook")
	public WebElement sbPricebook;
	@ButtonType()
	@SteelBrickBy(customAction = "Save")
	public WebElement save;
	@TextType()
	@SteelBrickBy(fieldSetTableItem = "itemLabel")
	public WebElement searchProducts;
	@ButtonType()
	@SteelBrickBy(customAction = "plSelect")
	public WebElement select;

	@PageRow()
	public static class Group1Lines {

		@TextType()
		@SteelBrickBy(pageGroupName = "Group1", fieldSetTableItem = "SBQQ__Quantity__c")
		public WebElement sBQQQuantityC;
		@BooleanType()
		@SteelBrickBy(pageGroupName = "Group1", fieldSetTableItem = "checkboxcontainer")
		public WebElement checkboxcontainer;
		@TextType()
		@SteelBrickBy(pageGroupName = "Group1", fieldSetTableItem = "SBQQ__ProductCode__c")
		public WebElement sBQQProductCodeC;
	}

	@SteelBrickBy(locatorType = "XPath", pageGroupName = "Group1", pageTableRow = "//sf-standard-table[@id=\"standardLines\"]")
	@PageTable(firstRowContainsHeaders = false, row = Group1Lines.class)
	public List<Group1Lines> group1Lines;
	@ButtonType()
	@SteelBrickBy(customAction = "Add Group")
	public WebElement addGroup;
	@TextType()
	@SteelBrickBy(fieldSetTableItem = "SBQQ__CustomerDiscount__c")
	public WebElement additionalDisc;
	@ButtonType()
	@SteelBrickBy(customAction = "Calculate")
	public WebElement calculate;
	
}
