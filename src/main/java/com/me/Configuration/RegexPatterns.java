package com.me.Configuration;

public final class RegexPatterns {
    private RegexPatterns() {
    }

    public static final String USERNAME = "^[a-zA-Z0-9_.-]{6,32}$";
    public static final String PHONE_E164 = "^\\+[1-9]\\d{1,14}$";
    public static final String SLUG = "^[a-z0-9]+(?:-[a-z0-9]+)*$";
    public static final String STRONG_PASSWORD =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,72}$";
    public static final String EMAIL =
            "^(?=.{6,254}$)[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[A-Za-z0-9](?:[A-Za-z0-9-]{0,61}[A-Za-z0-9])?\\.)+[A-Za-z]{2,63}$";
}
