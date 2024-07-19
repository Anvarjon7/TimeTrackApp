package de.telran.timetrackinapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RatingResponseDto {

    private Long id;

    private Long fromUser;

    private Long toUser;

    private Long grade;

    private String comment;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH.mm.ss")
    private Timestamp createdOn;
}
