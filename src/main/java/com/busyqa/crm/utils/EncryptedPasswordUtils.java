package com.busyqa.crm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptedPasswordUtils {
    public static void main(String[] args) {

        String password = "12345678";
        String encryptedPassword = encryptedPassword(password);

        System.out.println("Encrypted Password: " + encryptedPassword);

    }

    // Encrypted Password with BCryptPasswordEncoder
    public static String encryptedPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }


}
