package de.telran.timetrackinapp.mapper;

import de.telran.timetrackinapp.dto.TimeEntryResponseDto;
import de.telran.timetrackinapp.model.entity.timeEntry.TimeEntry;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class TimeEntryMapper implements Mapper<TimeEntry, TimeEntryResponseDto> {

    @Override
    public TimeEntryResponseDto toDto(TimeEntry timeEntry) {
        return new TimeEntryResponseDto(
                timeEntry.getId(),
                timeEntry.getDate(),
                timeEntry.getCategory(),
                timeEntry.getTimeSpent(),
                timeEntry.getUserId().getId()
        );
    }

    @Override
    public Set<TimeEntryResponseDto> toDtoSet(Set<TimeEntry> entitieSet) {
        return Set.of();
    }

    @Override
    public TimeEntry toEntity(TimeEntryResponseDto timeEntryResponseDto) {
        return null;
    }

    @Override
    public Set<TimeEntry> toEntitySet(Set<TimeEntryResponseDto> timeEntryResponseDtoSet) {
        return Set.of();
    }
}
