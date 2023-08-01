package app.it_bootcamp.test_task.core.dto.userDto;

import app.it_bootcamp.test_task.domain.UserRole;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

public class CreateUserDto {

    private final String pattern = "^[a-zA-Z]*$";

    @Email
    @NotBlank
    @Length(max = 50)
    private String mail;

    @NotBlank
    @Length(max = 40)
    @Pattern(regexp = pattern)
    private String name;

    @NotBlank
    @Length(max = 40)
    @Pattern(regexp = pattern)
    private String surname;

    @NotBlank
    @Length(max = 40)
    @Pattern(regexp = pattern)
    private String patronymic;

    private UserRole role;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
