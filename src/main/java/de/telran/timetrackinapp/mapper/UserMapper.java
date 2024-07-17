package de.telran.timetrackinapp.mapper;

import de.telran.timetrackinapp.dto.FullUserResponseDto;
import de.telran.timetrackinapp.dto.UserResponseDto;
import de.telran.timetrackinapp.model.entity.rating.Rating;
import de.telran.timetrackinapp.model.entity.timeEntry.TimeEntry;
import de.telran.timetrackinapp.model.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserMapper implements Mapper<User, UserResponseDto> {

    private final RatingMapper ratingMapper;

    private final TimeEntryMapper timeEntryMapper;

    @Override
    public UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getCreationDate()
        );
    }


    @Override
    public Set<UserResponseDto> toDtoSet(Set<User> entitieSet) {
        return Set.of();
    }

    @Override
    public User toEntity(UserResponseDto userResponseDto) {
        return null;
    }

    @Override
    public Set<User> toEntitySet(Set<UserResponseDto> userResponseDtos) {
        return Set.of();
    }

    public FullUserResponseDto toFullUserResponseDto(User user) {
        return new FullUserResponseDto(
                toDto(user),
                ratingMapper.toDtoSet((Set<Rating>) user.getRatings()),
                timeEntryMapper.toDtoSet((Set<TimeEntry>) user.getTimeEntries())
        );
    }
}
