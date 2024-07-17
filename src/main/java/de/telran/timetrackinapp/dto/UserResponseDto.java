package de.telran.timetrackinapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public record UserResponseDto(

        Long id,
        String firstName,
        String lastName,
        String email,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH.mm.ss")
        Timestamp createdAt
) {
}
