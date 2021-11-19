package codegym.controller;

import org.springframework.stereotype.Controller;

@Controller
public class ValidateAccount {
    private static final String ACCOUNT_REGEX = "^[_a-z0-9]{6,}$";
    public ValidateAccount(){

    }
}
