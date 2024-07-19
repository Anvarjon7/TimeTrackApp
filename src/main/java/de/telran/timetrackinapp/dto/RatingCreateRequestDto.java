package de.telran.timetrackinapp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;

public record RatingCreateRequestDto(

        @NotNull(message = "FromUser can not be empty")
        Long fromUserId,

        @NotNull(message = "ToUserId can not be empty")
        Long toUserId,

        @Min(1)
        @Max(5)
        Long grade,

        @Size(max = 400, message = "Comment must be at most 400 characters")
        String comment
) {
}
