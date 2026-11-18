package com.me.Configuration;

public final class ValidationMessages {

    private ValidationMessages() {
    }

    public static final String USERNAME_BLANK =
            "The username cannot be blank";

    public static final String USERNAME_SIZE =
            "The username must be between 6 and 32 characters";

    public static final String USERNAME_PATTERN =
            "The username is invalid";

    public static final String PASSWORD_BLANK =
            "The password cannot be blank";

    public static final String PASSWORD_SIZE =
            "The password must be between 8 and 72 characters";

    public static final String PASSWORD_PATTERN =
            "The password is too weak";

    public static final String EMAIL_BLANK =
            "The email address cannot be blank";

    public static final String EMAIL_SIZE =
            "The email address must be between 6 and 254 characters";

    public static final String EMAIL_PATTERN =
            "The email address is invalid";
}