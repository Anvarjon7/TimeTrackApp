package de.telran.timetrackinapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;

public record FullUserResponseDto(

        UserResponseDto userResponseDto,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        Set<RatingResponseDto> ratingResponseDtoSet,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        Set<TimeEntryResponseDto> timeEntryResponseDtoSet
) {
}
