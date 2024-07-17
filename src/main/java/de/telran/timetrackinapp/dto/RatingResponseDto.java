package de.telran.timetrackinapp.dto;

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

    private int rating;

    private Long grade;

    private String comment;

    private Timestamp createdOn;
}
