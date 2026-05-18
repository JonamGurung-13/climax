package com.icp.climax.utilities;

import jakarta.servlet.http.Part;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class ValidationUtil {
    // 1. Validate if a field is null or empty
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    // 2. Validate if a string contains only letters
    public static boolean isAlphabetic(String value) {
        boolean result = value != null && value.matches("^[a-zA-Z ]+$");
        System.out.println(result);
        return value != null && value.matches("^[a-zA-Z ]+$");
    }

    // 3. Validate if a string starts with a letter and is composed of letters and numbers
    public static boolean isAlphanumericStartingWithLetter(String value) {
        return value != null && value.matches("^[a-zA-Z][a-zA-Z0-9]*$");
    }


    // 4. Validate if a string is a valid email address
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email != null && Pattern.matches(emailRegex, email);
    }

    // 5. Validate if a password is composed of at least 1 capital letter, 1 number, and 1 symbol
    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$";
        return password != null && password.matches(passwordRegex);
    }

    // 6. Validate if a Part's file extension matches with image extensions (jpg, jpeg, png, gif)
    public static boolean isValidImageExtension(Part imagePart) {
        if (imagePart == null || isNullOrEmpty(imagePart.getSubmittedFileName())) {
            return false;
        }
        String fileName = imagePart.getSubmittedFileName().toLowerCase();
        return fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png") || fileName.endsWith(".gif");
    }

    // 7. Validate if password and retype password match
    public static boolean doPasswordsMatch(String password, String retypePassword) {
        return password != null && password.equals(retypePassword);
    }

    // 8. Validate if phone number is numeric
    public static boolean isValidNumber(String number) {
        return number != null && number.matches("^[0-9]+$");
    }

    //9. Validate if Date
    public static boolean isValidDate(String dateOfBirth) {
        try {
            return dateOfBirth != null && LocalDate.parse(dateOfBirth) != null;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    //10. Validate if age is valid and before the current date
    public static boolean isValidAge(String dateOfBirth){
        try {
            LocalDate dob = LocalDate.parse(dateOfBirth);
            LocalDate today = LocalDate.now();
            int age = Period.between(dob, today).getYears();
            int minAge = 16;

            return dob.isBefore(today) && age >= minAge;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    //11. Validation  message for invalid age (overloading)
    public static String invalidAge(String dateOfBirth) {
        try {
            LocalDate dob = LocalDate.parse(dateOfBirth);
            LocalDate today = LocalDate.now();
            int age = Period.between(dob, today).getYears();

            if (dob.isAfter(today)) {
                return "Date of birth cannot be in the future!";
            }
            if (age < 16) {
                return "You are not eligible! Age must be more than 16 years old";
            }
            return null;
        } catch (DateTimeParseException e) {
            return "Invalid date format!";
        }
    }

}
