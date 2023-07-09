package itjockebark.ptapp.model.dto;

import itjockebark.ptapp.utils.ColumnDescription;

public class UserRegisterDTO {

    @ColumnDescription(value = "Email of the user", example = "example@example.com")
    private String email;
    @ColumnDescription(value = "Password of the user", example = "P4ssw0rd")
    private String password;
    @ColumnDescription(value = "Firstname of the user", example = "Carl Gustaf")
    private String firstName;
    @ColumnDescription(value = "Lastname of the user", example = "Bernadotte")
    private String lastName;
    @ColumnDescription(value = "Birthdate of the user", example = "1946-04-30")
    private String birthdate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
