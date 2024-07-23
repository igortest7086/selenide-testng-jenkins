package ui_suite.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SignInUpType {
    SIGN_IN("Sign in"),
    SIGN_UP("Sign up");

    private final String value;

    @Override
    public String toString() {return value;}
}
