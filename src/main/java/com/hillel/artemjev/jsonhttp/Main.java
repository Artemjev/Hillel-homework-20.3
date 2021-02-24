package com.hillel.artemjev.jsonhttp;


import com.hillel.artemjev.jsonhttp.dto.StatusResponse;
import com.hillel.artemjev.jsonhttp.dto.contacts.FindByValueContactRequest;
import com.hillel.artemjev.jsonhttp.dto.contacts.GetContactsResponse;
import com.hillel.artemjev.jsonhttp.dto.user.CreateUserRequest;
import com.hillel.artemjev.jsonhttp.dto.user.LoginUserRequest;
import com.hillel.artemjev.jsonhttp.dto.user.LoginUserResponse;
import com.hillel.artemjev.jsonhttp.dto.user.UserResponse;

public class Main {
    public static void main(String[] args) {
        JsonHttpFacade jsonHttp = new JsonHttpFacade();
        //------------------------------------------
        UserResponse userResponse = jsonHttp.get("https://mag-contacts-api.herokuapp.com/users", UserResponse.class);
        System.out.println(userResponse);
        //------------------------------------------
        CreateUserRequest createUserRequest = new CreateUserRequest(
                "examplelogin1",
                "examplepass2",
                "2000-01-01"
        );
        StatusResponse statusResponse = jsonHttp.post(
                "https://mag-contacts-api.herokuapp.com/register",
                createUserRequest,
                StatusResponse.class
        );
        System.out.println(statusResponse);
        //------------------------------------------
        LoginUserRequest loginUserRequest = new LoginUserRequest(
                "misha",
                "777"
        );
        LoginUserResponse loginUserResponse = jsonHttp.post(
                "https://mag-contacts-api.herokuapp.com/login",
                loginUserRequest,
                LoginUserResponse.class
        );
        System.out.println(loginUserResponse);
        //------------------------------------------
        String token = loginUserResponse.getToken();

        GetContactsResponse contactsResponse = jsonHttp.getAuth(
                "https://mag-contacts-api.herokuapp.com/contacts",
                GetContactsResponse.class,
                token
        );
        System.out.println(contactsResponse);
        //------------------------------------------
        FindByValueContactRequest findByValueContactRequest = new FindByValueContactRequest("777");
        GetContactsResponse contactsByValueResponse = jsonHttp.postAuth(
                "https://mag-contacts-api.herokuapp.com/contacts/find",
                findByValueContactRequest,
                GetContactsResponse.class,
                token
        );
        System.out.println(contactsByValueResponse);
    }
}
