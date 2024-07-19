package de.telran.timetrackinapp.mapper;

import de.telran.timetrackinapp.dto.RatingResponseDto;
import de.telran.timetrackinapp.model.entity.rating.Rating;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RatingMapper implements Mapper<Rating, RatingResponseDto> {

    @Override
    public RatingResponseDto toDto(Rating rating) {
        return new RatingResponseDto(
                rating.getId(),
                rating.getFromUser(),
                rating.getToUser(),
                rating.getGrade(),
                rating.getComment(),
                rating.getCreatedAt()
        );
    }

    @Override
    public Set<RatingResponseDto> toDtoSet(Set<Rating> entitiesSet) {
        return Set.of();
    }

    @Override
    public Rating toEntity(RatingResponseDto ratingResponseDto) {
        return null;
    }

    @Override
    public Set<Rating> toEntitySet(Set<RatingResponseDto> ratingResponseDtoSet) {
        return Set.of();
    }
}
