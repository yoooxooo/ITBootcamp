package app.it_bootcamp.test_task.web.controllers;

import app.it_bootcamp.test_task.core.dto.pageDto.PageDto;
import app.it_bootcamp.test_task.core.dto.userDto.CreateUserDto;
import app.it_bootcamp.test_task.core.dto.userDto.GetUserDto;
import app.it_bootcamp.test_task.service.api.IUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<PageDto<GetUserDto>> getAllUsers(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                                           @RequestParam(value = "size", required = false, defaultValue = "10") Integer size) {
        return ResponseEntity.ok().body(service.getAllUsers(page, size));
    }


    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody CreateUserDto userDto) {
        service.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
