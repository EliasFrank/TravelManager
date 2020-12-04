package com.hl.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author hl2333
 */
public class EncodePassword {
    private static BCryptPasswordEncoder passwordEncoder
            = new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return passwordEncoder.encode(password);
    }
}
