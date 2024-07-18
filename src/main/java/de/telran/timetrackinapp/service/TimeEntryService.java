package de.telran.timetrackinapp.service;

import de.telran.timetrackinapp.dto.TimeEntryRequestDto;
import de.telran.timetrackinapp.model.entity.timeEntry.TimeEntry;

import java.time.LocalDate;
import java.util.List;

public interface TimeEntryService {

    TimeEntry create(TimeEntryRequestDto requestDto);

    TimeEntry update(Long id, TimeEntryRequestDto requestDto);

    void delete(Long id);

    List<TimeEntry> getTimeEntriesForUser(Long userId);

    List<TimeEntry> getTimeEntriesForUserBetweenDates(Long userId, LocalDate startDate, LocalDate endDate);

    TimeEntry findById(Long id);
}
