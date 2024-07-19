package de.telran.timetrackinapp.service.impl;

import de.telran.timetrackinapp.dto.UserRequestDto;
import de.telran.timetrackinapp.exception.UserAlreadyExistException;
import de.telran.timetrackinapp.exception.UserNotFoundException;
import de.telran.timetrackinapp.model.entity.user.User;
import de.telran.timetrackinapp.repository.UserRepository;
import de.telran.timetrackinapp.service.UserService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User register(UserRequestDto userRequestDto) {

        if (userRepository.existsByEmail(userRequestDto.getEmail())) {
            throw new UserAlreadyExistException("User already exists with email " + userRequestDto.getEmail() + "!");
        }


        User user = User.builder()
                .firstName(userRequestDto.getFirstName())
                .lastName(userRequestDto.getLastName())
                .email(userRequestDto.getEmail())
                .password(userRequestDto.getPassword())
                .averageRating(0.0)
                .role(userRequestDto.getRole())
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .build();

        return userRepository.save(user);
    }

    @Override
    public User update(Long id, UserRequestDto userRequestDto) {

        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            register(userRequestDto);
        }

        User existingUser = user.get();
        existingUser.setFirstName(userRequestDto.getFirstName());
        existingUser.setLastName(userRequestDto.getLastName());
        existingUser.setEmail(userRequestDto.getEmail());
        existingUser.setPassword(userRequestDto.getPassword());
        existingUser.setRole(userRequestDto.getRole());

        return userRepository.save(existingUser);
    }

    @Override
    public List<User> getAll() {

        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) {

        return userRepository.findById(id);
    }

    @Override
    public User getByEmail(String email) {

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User with email " + email + " not found!"));
    }

    @Override
    public void delete(Long id) {

        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User with id " + id + " not found!");
        }
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found!"));
    }

//    @Override
//    public Long getCurrentUserId() {
//
//        return 0L;
//    }

    @Override
    public Optional<User> findByIdWithRatings(Long id) {

        return userRepository.findByIdWithRatings(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }


//
//    @Override
//    public void deleteLowRatedUsers(int retainCount) {
//
//        List<User> users = userRepository.findAllOrderedByRatingDesc();
//
//        int usersToDelete = users.size() - retainCount;
//
//        if (usersToDelete > 0) {
//            for (int i = 0; i < usersToDelete; i++) {
//                User userToDelete = users.get(i);
//                userRepository.delete(userToDelete);
//            }
//        }
//    }


}
