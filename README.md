

# South African ID Validation Unit Testing

This Java application test and validates **South African ID numbers** based on various criteria, including format, date, gender, citizenship, and checksum.

### Features:
- **Validates ID number length** (13 digits)
- **Verifies the birth date** (YYMMDD format)
- **Checks the gender code** (valid range: 0000–4999 for females, 5000–9999 for males)
- **Validates citizenship status** (0 for citizen, 1 for permanent resident)
- **Verifies the checksum** using the Luhn algorithm

## Technologies:
- **Java 8+**
- **JUnit** for unit testing
- **Gradle** for build automation

## Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/LutendoMuthala/Validate_SA_ID.git

2. **Navigate to the project directory**
   ```bash
   cd Validate_SA_ID

3. **Run The Test**
   ```bash
   gradle test
  
  

