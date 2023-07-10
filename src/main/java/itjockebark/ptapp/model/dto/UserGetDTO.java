package itjockebark.ptapp.model.dto;

import itjockebark.ptapp.model.UserRole;
import itjockebark.ptapp.utils.ColumnDescription;

public class UserGetDTO {

    @ColumnDescription(value = "Email of the user", example = "example@example.com")
    private String email;
    @ColumnDescription(value = "Firstname of the user", example = "Carl Gustaf")
    private String firstName;
    @ColumnDescription(value = "Lastname of the user", example = "Bernadotte")
    private String lastName;
    @ColumnDescription(value = "Role of the user", example = "USER")
    private UserRole role;
    @ColumnDescription(value = "The active status of the user", example = "true")
    private boolean isActive;
    @ColumnDescription(value = "Birthdate of the user", example = "1946-04-30")
    private String birthdate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
