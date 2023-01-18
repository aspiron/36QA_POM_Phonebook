import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Contacts;
import pages.Login;

public class AddContactsTests extends TestBase{
    @BeforeMethod
    public void login(){
        Login myLoginPage = new Login(dr);
        myLoginPage.login("test@gmail.com", "test@gmail.com");
        sleep();
    }


    @Test
    public void checkTest(){
        Contacts contactsPage = new Contacts(dr);
        contactsPage.clickOnAddContactLink();
        contactsPage.fillAddContactsForm("firstNameExample", "lastNameExample", "a couple of words about this new contact");
        sleep();
//        contactsPage.clickOnCloseWindowAddContactButton();
        Assert.assertEquals(dr.findElement(By.id("contact-first-name")).getText(), "firstNameExample");
        Assert.assertEquals(dr.findElement(By.id("contact-last-name")).getText(), "lastNameExample");
        Assert.assertEquals(dr.findElement(By.id("contact-description")).getText(), "a couple of words about this new contact");

    }



}
