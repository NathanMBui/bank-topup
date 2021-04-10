package com.abcbank.topup.validators;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validator {

    public boolean isPhoneNumberValid(String phoneNumber) {
        Pattern phoneNumberPattern = Pattern.compile("^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$");
        Matcher phoneMatcher = phoneNumberPattern.matcher(phoneNumber);
        return phoneMatcher.find();
    }
}
