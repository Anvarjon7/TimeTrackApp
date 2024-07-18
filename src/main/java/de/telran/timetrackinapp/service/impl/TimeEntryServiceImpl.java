package de.telran.timetrackinapp.service.impl;

import de.telran.timetrackinapp.dto.TimeEntryRequestDto;
import de.telran.timetrackinapp.model.entity.timeEntry.TimeEntry;
import de.telran.timetrackinapp.model.entity.user.User;
import de.telran.timetrackinapp.repository.TimeEntryRepository;
import de.telran.timetrackinapp.service.TimeEntryService;
import de.telran.timetrackinapp.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeEntryServiceImpl implements TimeEntryService {

    private final TimeEntryRepository timeEntryRepository;
    private final UserService userService;

    @Override
    public TimeEntry create(TimeEntryRequestDto requestDto) {

        User user = userService.findById(requestDto.userId());

        TimeEntry timeEntry = new TimeEntry();
        timeEntry.setUserId(user);
        timeEntry.setDate(requestDto.date());
        timeEntry.setCategory(requestDto.category());
        timeEntry.setTimeSpent(requestDto.timeSpent());

        return timeEntryRepository.save(timeEntry);
    }

    @Override
    public TimeEntry update(Long id, TimeEntryRequestDto requestDto) {

        TimeEntry existingTimeEntry = timeEntryRepository.findById(id).get();

        existingTimeEntry.setDate(requestDto.date());
        existingTimeEntry.setCategory(requestDto.category());
        existingTimeEntry.setTimeSpent(requestDto.timeSpent());

        return timeEntryRepository.save(existingTimeEntry);
    }

    @Override
    public void delete(Long id) {

        TimeEntry existingTimeEntry = timeEntryRepository.findById(id).get();

        timeEntryRepository.delete(existingTimeEntry);
    }

    @Override
    public List<TimeEntry> getTimeEntriesForUser(Long userId) {

        return timeEntryRepository.findByUserId(userId);
    }

    @Override
    public List<TimeEntry> getTimeEntriesForUserBetweenDates(Long userId, LocalDate startDate, LocalDate endDate) {

        return timeEntryRepository.findByUserIdAndDateBetween(userId, startDate, endDate);
    }

    @Override
    public TimeEntry findById(Long id) {
        return timeEntryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TimeEntry with id " + id + " not found")); // #Todo own Exception
    }
}
