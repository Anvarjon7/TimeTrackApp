package de.telran.timetrackinapp.service;

import de.telran.timetrackinapp.dto.UserRequestDto;
import de.telran.timetrackinapp.model.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User register(UserRequestDto userRequestDto);

    User update(Long id, UserRequestDto userRequestDto);

    List<User> getAll();

    Optional<User> getById(Long id);

    User getByEmail(String email);

    void delete(Long id);

    User findById(Long id);

    Optional<User> findByIdWithRatings(Long id);

    void save(User user);
}
