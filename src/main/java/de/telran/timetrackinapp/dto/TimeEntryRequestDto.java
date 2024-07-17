package de.telran.timetrackinapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record TimeEntryRequestDto(

        @NotNull(message = "Date can not be empty")
        LocalDate date,

        String category,

        @PositiveOrZero(message = "Time spent must be a positive or zero integer")
        int timeSpent,

        @NotNull(message = "ID can not be empty")
        Long userId
) {

}
