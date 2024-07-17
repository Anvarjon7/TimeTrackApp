package de.telran.timetrackinapp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;

public record RatingCreateRequestDto(

        @NotNull(message = "ID can not be empty")
        Long id,

        @NotNull(message = "FromUser can not be empty")
        Long fromUser,

        @NotNull(message = "ToUserId can not be empty")
        Long toUserId,

        @Min(value = 1, message = "Rating must be at least 1")
        @Max(value = 5, message = "Rating must be at most 5")
        int rating,

        @Min(0)
        @Max(5)
        Long grade,

        @Size(max = 400, message = "Comment must be at most 400 characters")
        String comment,

        @NotNull(message = "Creation date can not be empty")
        Timestamp createdOn
) {
}
