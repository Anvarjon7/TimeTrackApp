package de.telran.timetrackinapp.service;

import de.telran.timetrackinapp.dto.RatingCreateRequestDto;
import de.telran.timetrackinapp.model.entity.rating.Rating;

public interface RatingService {

    Rating leaveRating(RatingCreateRequestDto createRequestDto);

    void updateUserAverageRating(Long userId);
}
