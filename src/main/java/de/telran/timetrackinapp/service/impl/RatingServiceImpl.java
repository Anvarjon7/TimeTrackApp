package de.telran.timetrackinapp.service.impl;

import de.telran.timetrackinapp.dto.RatingCreateRequestDto;
import de.telran.timetrackinapp.exception.InvalidUserException;
import de.telran.timetrackinapp.model.entity.rating.Rating;
import de.telran.timetrackinapp.model.entity.user.User;
import de.telran.timetrackinapp.repository.RatingRepository;
import de.telran.timetrackinapp.service.RatingService;
import de.telran.timetrackinapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final UserService userService;

    @Override
    public Rating leaveRating(RatingCreateRequestDto dto) {

        User fromUser = userService.findById(dto.fromUserId());
        User toUser = userService.findById(dto.toUserId());

        if (fromUser == null || toUser == null) {
            throw new InvalidUserException("Both fromUser and toUser must be valid users");
        }

        log.debug("Creating rating from user: {} to user: {}", fromUser.getId(), toUser.getId());
        // Log the details for debugging purposes
        log.debug("Creating rating from user: {} to user: {}", fromUser.getId(), toUser.getId());

        Rating newRating = Rating.builder()
                .fromUser(fromUser.getId())
                .toUser(toUser.getId())
                .grade(dto.grade())
                .comment(dto.comment())
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .build();

        updateUserAverageRating(toUser.getId());

        return ratingRepository.save(newRating);
    }


    @Override
    public void updateUserAverageRating(Long userId) {
        List<Rating> ratings = ratingRepository.findByToUserId(userId);

        double averageRating = ratings.stream()
                .mapToDouble(Rating::getGrade).average().orElse(0.0);
        User user = userService.findById(userId);
        user.setAverageRating(averageRating);
        userService.save(user);
    }
}
