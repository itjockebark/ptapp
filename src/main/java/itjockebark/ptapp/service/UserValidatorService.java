package itjockebark.ptapp.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserValidatorService {

    private final String EMAIL_REGEX = "\\S+@\\S+.\\S+";
    private final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    private final String DATE_REGEX = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";

    public void validateEmail(String email) {
        if (!Pattern.compile(EMAIL_REGEX).matcher(email).matches())
            throw new IllegalArgumentException("Invalid email address. Please include \"@\" and \".\",  in the format of \"example@example.se\"");
    }

    public void validatePassword(String password) {
        if (!Pattern.compile(PASSWORD_REGEX).matcher(password).matches())
            throw new IllegalArgumentException("Password must be minimum 8 characters and maximum 20 characters. " +
                    "Upper and lower case letters, one or more numbers and one or more special characters");
    }

    public void validateDate(String date) {
        if (!Pattern.compile(DATE_REGEX).matcher(date).matches())
            throw new IllegalArgumentException("Date format was not correct. Must be yyyy-mm-dd");
    }

    public void validateFirstName(String firstName) {
        if (firstName == null || firstName.length() < 2 || firstName.length() > 32)
            throw new IllegalArgumentException("Firstname can not be null, less than 2 character or more than 32 characters long");
    }

    public void validateLastName(String lastName) {
        if (lastName == null || lastName.length() < 2 || lastName.length() > 32)
            throw new IllegalArgumentException("Lastname can not be null, less than 2 character or more than 32 characters long");
    }

}
