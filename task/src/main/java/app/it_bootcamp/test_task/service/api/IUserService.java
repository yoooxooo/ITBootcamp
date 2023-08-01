package app.it_bootcamp.test_task.service.api;


import app.it_bootcamp.test_task.core.dto.pageDto.PageDto;
import app.it_bootcamp.test_task.core.dto.userDto.CreateUserDto;
import app.it_bootcamp.test_task.core.dto.userDto.GetUserDto;

import java.util.UUID;

public interface IUserService {

    PageDto<GetUserDto> getAllUsers(Integer pageNumber, Integer pageSize);

    UUID createUser(CreateUserDto userDto);

}
