package org.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ValidateSaIdTest {

        @Test{
            // Test valid ID numbers 
            assertTrue(ValidateSaId.isIdNumberValid("2001014800086"));
            assertTrue(ValidateSaId.isIdNumberValid("2909035800085"));
        }
    
        @Test
        public void testTooShortIdNumber() {
            // Test ID that is too short
            assertFalse(ValidateSaId.isIdNumberValid("20010148000"));
        }
    
        @Test
        public void testTooLongIdNumber() {
            // Test ID that is too long
            assertFalse(ValidateSaId.isIdNumberValid("20010148000861"));
        }
    
        @Test
        public void testNonNumericIdNumber() {
            // Test ID with non-numeric characters
            assertFalse(ValidateSaId.isIdNumberValid("20010A4800086"));
        }
    
        @Test
        public void testNullIdNumber() {
            // Test null ID
            assertFalse(ValidateSaId.isIdNumberValid(null));
        }
    
        @Test
        public void testInvalidYear() {
            // No specific validation for year in SA ID (any two digits are technically
            // valid)
            // This test is more of a placeholder
            assertTrue(ValidateSaId.isIdNumberValid("2001014800086"));
        }
    
        @Test
        public void testInvalidMonth() {
            // Test month = 0 (invalid)
            assertFalse(ValidateSaId.isIdNumberValid("2000014800083"));
            // Test month = 13 (invalid)
            assertFalse(ValidateSaId.isIdNumberValid("2013014800082"));
        }
    
        @Test
        public void testInvalidDay() {
            // Test invalid day in January (day = 32)
            assertFalse(ValidateSaId.isIdNumberValid("2001324800085"));
            // Test invalid day in February (day = 30)
            assertFalse(ValidateSaId.isIdNumberValid("2002304800087"));
            // Test invalid day in April (day = 31)
            assertFalse(ValidateSaId.isIdNumberValid("2004314800080"));
        }
    
        @Test
        public void testInvalidGenderCode() {
            // All gender codes between 0000-9999 are valid, no specific test needed
            
            assertTrue(ValidateSaId.isIdNumberValid("2001014800086"));
        }
    
        @Test
        public void testInvalidCitizenshipStatus() {
            // Test invalid citizenship status (not 0 or 1)
            String invalidId = "2001014800286"; // Using 2 as citizenship status
            assertFalse(ValidateSaId.isIdNumberValid(invalidId));
        }
    
        @Test
        public void testInvalidChecksum() {
            // Test ID with invalid checksum
            assertFalse(ValidateSaId.isIdNumberValid("2001014800087")); // Changed last digit
        }
    }
