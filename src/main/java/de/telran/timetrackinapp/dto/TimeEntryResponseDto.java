package de.telran.timetrackinapp.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TimeEntryResponseDto(

        @NotNull(message = "ID can not be empty")
        Long id,

        LocalDate date,

        String category,

        int timeSpent,

        @NotNull(message = "ID can not be empty")
        Long userId
) {

}
