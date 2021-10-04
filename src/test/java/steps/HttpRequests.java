package steps;

import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import models.ContactDTO;
import models.ErrorMessage;
import models.UserDTO;

import java.util.HashMap;
import java.util.Map;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;

public class HttpRequests {
    public static RequestSpecification baseRequest() {
        return given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json");
    }

    @Step("Create new user")
    public static UserDTO createUser(String firstName, String lastName) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put(FIRST_NAME, firstName);
        requestBody.put(LAST_NAME, lastName);

        return baseRequest()
                .body(requestBody)
                .post("/users")
                .as(UserDTO.class);
    }

    @Step("Get user by name")
    public static ErrorMessage getUserByName(String firstName) {
        return baseRequest()
                .pathParam(NAME, firstName)
                .get("/users/search/{name}")
                .as(ErrorMessage.class);
    }

    @Step("Delete user by id")
    public static int deleteUserById(int id) {
        return baseRequest()
                .pathParams(ID, id)
                .delete("/users/{id}")
                .getStatusCode();
    }

    @Step("Create new contact for user")
    public static ContactDTO createContactForUser(int userId, ContactDTO contact) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put(FIRST_NAME, contact.getFirstName());
        requestBody.put(LAST_NAME, contact.getLastName());
        requestBody.put(PHONE, contact.getPhone());
        requestBody.put(EMAIL, contact.getEmail());

        return baseRequest()
                .pathParams(ID, userId)
                .body(requestBody)
                .post("/users/{id}/contacts")
                .as(ContactDTO.class);
    }
}
