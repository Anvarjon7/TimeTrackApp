package de.telran.timetrackinapp.service.impl;

import de.telran.timetrackinapp.dto.TimeEntryRequestDto;
import de.telran.timetrackinapp.exception.TimeEntryNotFoundException;
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
        timeEntry.getDate();
        timeEntry.setCategory(requestDto.category());
        timeEntry.setTimeSpent(requestDto.timeSpent());
        timeEntry.setUser(user);

        return timeEntryRepository.save(timeEntry);
    }

//    @Override
//    public TimeEntry update(Long id, TimeEntryRequestDto requestDto) {
//
//        User user = userService.findById(id);
//
////        TimeEntry existingTimeEntry = timeEntryRepository.findByUserId(id);
//
////        existingTimeEntry.setCategory(requestDto.category());
////        existingTimeEntry.setTimeSpent(requestDto.timeSpent());
//////        existingTimeEntry.setUser(user);
////
////        return timeEntryRepository.save(existingTimeEntry);
//    }

    @Override
    public void delete(Long id) {

        TimeEntry toDelete = timeEntryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        timeEntryRepository.delete(toDelete);
    }

    @Override
    public List<TimeEntry> getTimeEntriesForUser(Long userId) {
        User user = userService.findById(userId);

        return timeEntryRepository.findByUserId(user.getId());
    }

    @Override
    public List<TimeEntry> getTimeEntriesForUserBetweenDates(Long userId, LocalDate startDate, LocalDate endDate) {

        return timeEntryRepository.findByUserIdAndDateBetween(userId, startDate, endDate);
    }

    @Override
    public TimeEntry findById(Long id) {
        return timeEntryRepository.findById(id)
                .orElseThrow(() -> new TimeEntryNotFoundException("TimeEntry with id " + id + " not found"));
    }
}
