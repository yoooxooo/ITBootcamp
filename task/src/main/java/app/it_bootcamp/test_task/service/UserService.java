package app.it_bootcamp.test_task.service;


import app.it_bootcamp.test_task.core.dto.pageDto.PageDto;
import app.it_bootcamp.test_task.core.dto.userDto.CreateUserDto;
import app.it_bootcamp.test_task.core.dto.userDto.GetUserDto;
import app.it_bootcamp.test_task.dao.UserRepository;
import app.it_bootcamp.test_task.domain.User;
import app.it_bootcamp.test_task.service.api.IUserService;
import app.it_bootcamp.test_task.utils.mappers.PageMapper;
import app.it_bootcamp.test_task.utils.mappers.UserMapper;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements IUserService {

    public static final Logger LOGGER = LogManager.getLogger(UserService.class);

    private final UserRepository dao;

    private final UserMapper userMapper;

    private final PageMapper<GetUserDto> pageMapper;

    public UserService(UserRepository dao, UserMapper userMapper, PageMapper<GetUserDto> pageMapper) {
        this.dao = dao;
        this.userMapper = userMapper;
        this.pageMapper = pageMapper;
    }

    @Override
    public PageDto<GetUserDto> getAllUsers(Integer pageNumber, Integer pageSize) {
        if (pageNumber < 0 || pageSize < 1) {
            throw new IllegalArgumentException("Страницы с такими параметрами не существует");
        }
        Page<User> userPage;
        if ((userPage = dao.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("mail")))).getTotalPages() < pageNumber + 1) {
            throw new IllegalArgumentException("Общее количество страниц меньше чем номер запрашиваемой");
        }
        LOGGER.info("getting entities");
        return pageMapper.toDto(userPage.map(userMapper::createDto));
    }

    @Override
    public UUID createUser(CreateUserDto userDto) {
        User user = userMapper.createEntity(userDto);
        LOGGER.info("adding entity");
        return dao.save(user).getId();
    }

}
