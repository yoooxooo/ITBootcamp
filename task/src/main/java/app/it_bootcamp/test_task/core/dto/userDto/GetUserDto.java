package app.it_bootcamp.test_task.core.dto.userDto;

import app.it_bootcamp.test_task.domain.User;
import app.it_bootcamp.test_task.domain.UserRole;

public class GetUserDto {

    private String fio;
    private String mail;

    private UserRole role;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
