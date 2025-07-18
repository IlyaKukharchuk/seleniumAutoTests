package admin;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationDetailsTest extends AdminTest {

    @Test
    public void testLegitCreds(){
        registrationDetailsPage.setSurnameField("Иванов");
        registrationDetailsPage.setNameField("Иван");
        registrationDetailsPage.setMiddlenameField("Иванович");
        registrationDetailsPage.setPhoneField("123456789");
        registrationDetailsPage.setPassportField("12345678");
        registrationDetailsPage.setBirthdayField("22011994");
        Assert.assertFalse(registrationDetailsPage.nextButtonIsDisabled());
        registrationDetailsPage.clickNextButton();
    }
}
