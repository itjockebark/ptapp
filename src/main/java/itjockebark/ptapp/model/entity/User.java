package itjockebark.ptapp.model.entity;

import itjockebark.ptapp.model.UserRole;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "email", nullable = false, length = 64)
    private String email;
    @Column(name = "password", length = 64)
    private String password;
    @Column(name="first_name", length = 32)
    private String firstName;
    @Column(name="last_name", length = 32)
    private String lastName;
    @Column(name = "birthdate")
    private LocalDate birthdate;
    @Column(name="role", length = 32)
    private UserRole role;
    @Column(name="is_active")
    private boolean isActive;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
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
        try {
            return birthdate.toString();
        } catch (NullPointerException exception) {
            return null;
        }
    }

    public void setBirthdate(String birthdate) {
        try {
            this.birthdate = LocalDate.parse(birthdate);
        } catch(NullPointerException exception) {
            this.birthdate = null;
        }
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

    public void setActive(boolean active) {
        isActive = active;
    }
}
