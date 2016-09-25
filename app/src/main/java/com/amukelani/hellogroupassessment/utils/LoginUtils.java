package com.raywenderlich.hellogroupassessment.utils;

import android.content.Context;
import android.util.Log;

import javax.mail.internet.InternetAddress;

/**
 * Created by Amukelani on 9/25/16.
 */
public class LoginUtils {

    private static String constPassword = "magic";
    private Context _context;

    public LoginUtils() {
    }

    public boolean isUserNameValid(String email){

        boolean valid = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (Exception ex) {
            valid = false;
        }
        return valid;
    }

    public boolean isPasswordValid(String password) {
        boolean isValid = false;
        Log.d("Password for employee", password);
        if(password.equals(constPassword))
        {
            isValid = true;
        }
        return isValid;
    }
}
