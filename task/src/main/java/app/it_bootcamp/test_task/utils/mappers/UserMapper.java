package app.it_bootcamp.test_task.utils.mappers;

import app.it_bootcamp.test_task.core.dto.userDto.CreateUserDto;
import app.it_bootcamp.test_task.core.dto.userDto.GetUserDto;
import app.it_bootcamp.test_task.domain.User;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class UserMapper {

    public GetUserDto createDto(User user) {

        GetUserDto userDto = new GetUserDto();

        userDto.setFio(user.getName() + " " + user.getSurname() + " " + user.getPatronymic());
        userDto.setMail(user.getMail());
        userDto.setRole(user.getRole());

        return userDto;
    }

    public User createEntity(CreateUserDto dto) {

        User user = new User();

        user.setCreationDate(Instant.now());
        user.setMail(dto.getMail());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setPatronymic(dto.getPatronymic());
        user.setRole(dto.getRole());

        return user;
    }

}
