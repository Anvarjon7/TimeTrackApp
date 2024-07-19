package de.telran.timetrackinapp.controller;

import de.telran.timetrackinapp.dto.RatingCreateRequestDto;
import de.telran.timetrackinapp.dto.RatingResponseDto;
import de.telran.timetrackinapp.mapper.RatingMapper;
import de.telran.timetrackinapp.model.entity.rating.Rating;
import de.telran.timetrackinapp.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;
    private final RatingMapper ratingMapper;

    @PostMapping("/leaveRating")
    public ResponseEntity<RatingResponseDto> leaveRating(@Validated @RequestBody RatingCreateRequestDto createRequestDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ratingMapper.toDto(ratingService.leaveRating(createRequestDto)));
    }


}
