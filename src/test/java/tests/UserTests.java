package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.ErrorMessage;
import models.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.HttpRequests;

import static constants.Constants.CREATED_FIRST_NAME;
import static constants.Constants.CREATED_LAST_NAME;

public class UserTests {
    UserDTO createNewUser;

    //positive test
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "check creating user")
    public final void checkCreateUser(){
        createNewUser = HttpRequests.createUser(CREATED_FIRST_NAME, CREATED_LAST_NAME);
        Assert.assertEquals(createNewUser.getFirstName(), CREATED_FIRST_NAME);
        Assert.assertEquals(createNewUser.getLastName(), CREATED_LAST_NAME);
    }

    //positive test
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "check deleting user", dependsOnMethods = "checkCreateUser")
    public final void checkDeleteUser(){
        int statusCode = 202;
        int id = createNewUser.getId();
        int deleteUser = HttpRequests.deleteUserById(id);
        Assert.assertEquals(deleteUser, statusCode);
    }

    //negative test
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "check getting user by firstName, that not exists", dependsOnMethods = {"checkCreateUser","checkDeleteUser"})
    public final void checkGetUserByNonExistFirstName(){
        String error = "Not Found";
        ErrorMessage errorMessage = HttpRequests.getUserByName(CREATED_FIRST_NAME);
        Assert.assertEquals(errorMessage.getError(), error);
    }
}
