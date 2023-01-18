package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends PageBase{

    public Login(WebDriver dr) {
        super(dr);
    }

    @FindBy(id="defaultRegisterFormEmail")
    WebElement userName;

    @FindBy(xpath = "//*[@id=\"login-form\"]/div[2]/div[1]/div/input")
    WebElement password;

    @FindBy(xpath = "/html/body/app-root/app-login/div/div[2]/div/form/div[3]/div[1]/button")
    WebElement loginButton;

    public Contacts login(String uName, String pass) {
        type(userName, uName);
        type(password, pass);
        click(loginButton);
        return new Contacts(dr);
    }

    public Login loginNegative(String uName, String pass) {
        type(userName, uName);
        type(password, pass);
        click(loginButton);
        return this;
    }



}
