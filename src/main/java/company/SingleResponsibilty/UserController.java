package company.SingleResponsibilty;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

//Handles incoming JSON requests that work on User resource/entity
public class UserController {

    private UserPersistenceService userPersistenceService = new UserPersistenceService();

    //Create a new user
    public String createUser(String userJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(userJson, User.class);

        UserValidator validator = new UserValidator();
        boolean validUser = validator.validateUser(user);

        if (!validUser) {
            return "ERROR";
        }
        userPersistenceService.saveUser(user);
        return "SUCCESS";
    }
}