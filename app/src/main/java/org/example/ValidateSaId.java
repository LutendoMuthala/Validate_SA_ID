package org.example;

public class ValidateSaId {
    public static boolean isIdNumberValid(String idNumber) {
        // Check if the ID is null
        if (idNumber == null) {
            return false;
        }

        // Check if the ID has the correct length (13 digits)
        if (idNumber.length() != 13) {
            return false;
        }

        // Check if the ID contains only digits
        if (!idNumber.matches("\\d+")) {
            return false;
        }

        // Validate birth date components (YYMMDD)
        if (!isValidDate(idNumber.substring(0, 6))) {
            return false;
        }

        // Validate gender code (SSSS) - 0000-4999 for females, 5000-9999 for males
        int genderCode = Integer.parseInt(idNumber.substring(6, 10));
        if (genderCode < 0 || genderCode > 9999) {
            return false;
        }

        // Validate citizenship status (C) - 0 for citizen, 1 for permanent resident
        char citizenshipStatus = idNumber.charAt(10);
        if (citizenshipStatus != '0' && citizenshipStatus != '1') {
            return false;
        }

        // Validate the checksum digit using the Luhn algorithm
        return isValidChecksum(idNumber);
    }

    // Validates if the date part of the ID number is valid. Format: YYMMDD

    private static boolean isValidDate(String dateStr) {
        if (dateStr.length() != 6) {
            return false;
        }

        try {
            int year = Integer.parseInt(dateStr.substring(0, 2));
            int month = Integer.parseInt(dateStr.substring(2, 4));
            int day = Integer.parseInt(dateStr.substring(4, 6));

            // Validate month (1-12)
            if (month < 1 || month > 12) {
                return false;
            }

            // Validate day based on month
            int maxDay;
            switch (month) {
                case 4:
                case 6:
                case 9:
                case 11:
                    maxDay = 30;
                    break;
                case 2:
                    maxDay = (year % 4 == 0) ? 29 : 28;
                    break;
                default:
                    maxDay = 31;
            }

            return day >= 1 && day <= maxDay;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Validates the checksum digit using the Luhn algorithm.
    private static boolean isValidChecksum(String idNumber) {
        int sum = 0;
        boolean alternate = false;

        // Process all digits except the last one (checksum digit)
        for (int i = 0; i < idNumber.length() - 1; i++) {
            int digit = Character.getNumericValue(idNumber.charAt(i));

            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit = digit - 9;
                }
            }

            sum += digit;
            alternate = !alternate;
        }

        int checkDigit = Character.getNumericValue(idNumber.charAt(idNumber.length() - 1));
        return (sum + checkDigit) % 10 == 0;
    }
}
