package com.icp.climax.utilities;

import org.mindrot.jbcrypt.BCrypt;
public class PasswordUtil {
    private final static int COST = 10;

    public static String getHashPassword(String inputPassword){
        String salt = BCrypt.gensalt(COST);

        return BCrypt.hashpw(inputPassword, salt);
    }

    public static boolean checkPassword(String inputPassword, String hashedPassword){
        return BCrypt.checkpw(inputPassword, hashedPassword);
    }
}
