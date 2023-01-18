import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Contacts;
import pages.Login;

public class LoginPageTests extends TestBase{
    @Test
    public void loginPositiveTest(){
        logger.info("Starting login test");
        //String language = System.getProperty("language");
        String language = "English";

        Login myLoginPage = new Login(dr);
        Contacts contactsPage = myLoginPage.login("test@gmail.com", "test@gmail.com");
        sleep();
        contactsPage.selectLanguage(language);
        sleep();
        Assert.assertEquals(contactsPage.getContacts(language).getText(), Contacts.getContactWord(language));
        logger.info("Finished login test");
    }


}
