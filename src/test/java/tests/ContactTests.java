package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.ContactDTO;
import models.UserDTO;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.HttpRequests;

import static constants.Constants.*;

public class ContactTests {
    UserDTO createNewUser;

    @BeforeMethod
    public final void setEnvironment() {
        createNewUser = HttpRequests.createUser(CREATED_FIRST_NAME, CREATED_LAST_NAME);
    }

    //negative test
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "check creating contact for user with invalid phone")
    public final void checkCreateContactForUserWithInvalidPhone() {
        String phone = "должно соответствовать шаблону \"\\d{10}\"";
        int id = createNewUser.getId();
        ContactDTO contactDTO = new ContactDTO(CREATED_FIRST_NAME, CREATED_LAST_NAME, CREATED_PHONE, CREATED_EMAIL);
        ContactDTO createNewContact = HttpRequests.createContactForUser(id, contactDTO);
        Assert.assertEquals(createNewContact.getPhone(), phone);
    }
}
