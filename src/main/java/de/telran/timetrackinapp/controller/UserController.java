package de.telran.timetrackinapp.controller;

import de.telran.timetrackinapp.dto.FullUserResponseDto;
import de.telran.timetrackinapp.dto.UserRequestDto;
import de.telran.timetrackinapp.dto.UserResponseDto;
import de.telran.timetrackinapp.mapper.UserMapper;
import de.telran.timetrackinapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> create(@RequestBody @Valid UserRequestDto userRequestDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userMapper.toDto(userService.register(userRequestDto)));
    }

    @PutMapping("/update")
    public ResponseEntity<UserResponseDto> update(@RequestBody @Valid Long id, UserRequestDto userRequestDto) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(userMapper.toDto(userService.update(id, userRequestDto)));
    }

    @GetMapping
    public ResponseEntity<List<FullUserResponseDto>> getAll() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getAll().stream().map(userMapper::toFullUserResponseDto)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(userMapper.toDto(userService.getById(id).get()));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponseDto> getByEmail(@PathVariable String email) {

        return ResponseEntity.status(HttpStatus.OK).body(userMapper.toDto(userService.getByEmail(email)));
    }


    @GetMapping("/delete")
    public ResponseEntity delete(@RequestParam Long id) {

        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}
