package de.telran.timetrackinapp.controller;

import de.telran.timetrackinapp.dto.TimeEntryRequestDto;
import de.telran.timetrackinapp.dto.TimeEntryResponseDto;
import de.telran.timetrackinapp.mapper.TimeEntryMapper;
import de.telran.timetrackinapp.model.entity.timeEntry.TimeEntry;
import de.telran.timetrackinapp.service.TimeEntryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/timeEntry")
@RequiredArgsConstructor
public class TimeEntryController {

    private final TimeEntryService timeEntryService;
    private final TimeEntryMapper timeEntrymapper;

    @PostMapping("/create")
    public ResponseEntity<TimeEntryResponseDto> create(@Valid @RequestBody TimeEntryRequestDto requestDto){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(timeEntrymapper.toDto(timeEntryService.create(requestDto)));
    };

    @PutMapping("/{id}")
    public ResponseEntity<TimeEntryResponseDto> update(Long id, TimeEntryRequestDto requestDto){

        return ResponseEntity.status(HttpStatus.OK)
                .body(timeEntrymapper.toDto(timeEntryService.update(id,requestDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        timeEntryService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<TimeEntryResponseDto>> getTimeEntriesForUser(Long userId){

        return ResponseEntity.status(HttpStatus.OK)
                .body(timeEntryService.getTimeEntriesForUser(userId).stream()
                        .map(timeEntrymapper::toDto)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/betweenDates")
    public ResponseEntity<List<TimeEntryResponseDto>> getTimeEntriesForUserBetweenDates(Long userId, LocalDate startDate, LocalDate endDate){

        return ResponseEntity.status(HttpStatus.OK)
                .body(timeEntryService.getTimeEntriesForUserBetweenDates(userId,startDate,endDate).stream()
                        .map(timeEntrymapper::toDto)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/getById")
    public ResponseEntity<TimeEntryResponseDto> findById(Long id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(timeEntrymapper.toDto(timeEntryService.findById(id)));
    }

}
