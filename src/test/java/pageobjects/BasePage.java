package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.BaseTest;

public class BasePage extends PageObject {

    public final String LOGIN_PAGE = BaseTest.getBaseUrl() + BaseTest.getLoginPath();
    @FindBy(className = "oxd-topbar-header-breadcrumb")
    private WebElementFacade titleMenu;

    public void openOrangeHrmWeb() {
        openUrl(LOGIN_PAGE);
    }

    public boolean verifyMenu(String expected){
        waitFor(ExpectedConditions.visibilityOf(titleMenu));
        return titleMenu.getText().toLowerCase().contains(expected.toLowerCase());
    }


}
