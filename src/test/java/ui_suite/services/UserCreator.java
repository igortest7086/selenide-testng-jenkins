package ui_suite.services;

import ui_suite.models.User;

public class UserCreator {

    public static final String USER_NAME = "igortest7086";
    public static final String USER_PASSWORD = "J8mLX333";

    public static User withCredentialsFromProperty(){
        return new User(USER_NAME,
                USER_PASSWORD);
    }

    public static User withEmptyUsername(){
        return new User("", USER_PASSWORD);
    }

    public static User withEmptyPassword(){
        return new User(USER_NAME, "");
    }
}
