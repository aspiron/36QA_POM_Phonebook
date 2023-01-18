package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Contacts extends PageBase {
    public Contacts(WebDriver dr) {
        super(dr);
    }

    @FindBy(xpath = "/html/body/app-root/app-home-page/app-header/nav/div/div[2]/button[2]")
    WebElement logOutButton;

    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement contacts;

    @FindBy(xpath = "//select[@id='langSelect']")
    WebElement selectLang;

//    @FindBy(xpath = "//option[contains(text(),'English')]")
//    WebElement engLang;

    public Login logout() {
        click(logOutButton);
        return new Login(dr);
    }

    public WebElement getContacts(String lang) {
        String contactWord = getContactWord(lang);
        contacts = dr.findElement(By.xpath("//a[contains(text(),'" + contactWord + "')]"));
        return contacts;
    }

    public static String getContactWord(String lang) {
        logger.info("Language specified: " + lang);
        String contactWord = null;
        if (lang.equals("English")) {
            contactWord = "Contacts";
        } else if (lang.equals("Russian")) {
            contactWord = "Контакты";
        } else if (lang.equals("German")) {
            contactWord = "Kontakte";
        } else if (lang.equals("Ukraine")) {
            contactWord = "Контакти";
        } else {
            logger.error("Language not supported: " + lang);
            throw new RuntimeException("Language not supported: " + lang);
        }
        return contactWord;
    }

    public Contacts selectLanguage(String lang) {
        click(selectLang);
        WebElement language = dr.findElement(By.xpath("//option[contains(text(),'" + lang + "')]"));
        click(language);
        return this;
    }

    @FindBy(xpath = "/html/body/app-root/app-home-page/app-header/nav/div/ul/li[2]/a")
    WebElement addContactBtn;

    @FindBy(xpath = "//*[@id=\"add-contact-modal\"]/a/span")
    WebElement closeAddContactWindowBtn;

    public Contacts clickOnAddContactLink() {
        addContactBtn.click();
        return new Contacts(dr);
    }

    public Contacts clickOnCloseWindowAddContactButton(){
        closeAddContactWindowBtn.click();
        return new Contacts(dr);
    }


    @FindBy(id = "form-name")
    WebElement fNameField;
    @FindBy(id = "form-lastName")
    WebElement lNameField;
    @FindBy(id = "form-about")
    WebElement aboutField;
    @FindBy(xpath = "//*[@id=\"add-contact-form\"]/div[4]/button[2]")
    WebElement saveBtn;

    public Contacts fillAddContactsForm(String firstNameKeys, String lastNameKeys, String aboutKeys){
        type(fNameField, firstNameKeys);
        type(lNameField, lastNameKeys);
        type(aboutField, aboutKeys);
        saveBtn.click();
        return new Contacts(dr);
    }


}
