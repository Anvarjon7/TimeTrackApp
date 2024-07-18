package de.telran.timetrackinapp.service;

import de.telran.timetrackinapp.model.entity.rating.Rating;

public interface RatingService {

    Rating leaveRating(Long fromUserId, Long toUserId, int rating, String comment);

    void updateUserAverageRating(Long userId);
}
