package de.telran.timetrackinapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record TimeEntryRequestDto(

        String category,

        @PositiveOrZero(message = "Time spent must be a positive or zero integer")
        Integer timeSpent,

        @NotNull(message = "ID can not be empty")
        Long userId
) {

}
