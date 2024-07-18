package de.telran.timetrackinapp.service.impl;

import de.telran.timetrackinapp.model.entity.rating.Rating;
import de.telran.timetrackinapp.model.entity.user.User;
import de.telran.timetrackinapp.repository.RatingRepository;
import de.telran.timetrackinapp.service.RatingService;
import de.telran.timetrackinapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final UserService userService;

    @Override
    public Rating leaveRating(Long fromUserId, Long toUserId, int rating, String comment) {

        validateRatingParameters(fromUserId, toUserId, rating);

        User fromUser = userService.findById(fromUserId);
        User toUser = userService.findById(toUserId);

        Rating newRating = Rating.builder()
                .fromUserId(fromUser.getId())
                .toUserId(toUser)
                .rating(rating)
                .comment(comment)
                .build();

        return ratingRepository.save(newRating);
    }

    private void validateRatingParameters(Long fromUserId, Long toUserId, int rating) {

        if (fromUserId == null || fromUserId <= 0) {
            throw new IllegalArgumentException("Invalid fromUserId: " + fromUserId);
        }
        if (toUserId == null || toUserId <= 0) {
            throw new IllegalArgumentException("Invalid toUserId: " + toUserId);
        }
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Invalid rating: " + rating + ". Rating must be between 1 and 5.");
        }
    }

    @Override
    public void updateUserAverageRating(Long userId) {
        List<Rating> ratings = ratingRepository.findByToUserId(userId);

        double averageRating = ratings.stream()
                .mapToInt(Rating::getRating).average().orElse(0.0);
        User user = userService.findById(userId);
        user.setAverageRating(averageRating);
        userService.save(user);
    }
}
