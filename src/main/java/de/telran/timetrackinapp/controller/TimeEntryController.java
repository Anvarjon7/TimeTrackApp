package de.telran.timetrackinapp.controller;

import de.telran.timetrackinapp.dto.TimeEntryRequestDto;
import de.telran.timetrackinapp.dto.TimeEntryResponseDto;
import de.telran.timetrackinapp.mapper.TimeEntryMapper;
import de.telran.timetrackinapp.model.entity.timeEntry.TimeEntry;
import de.telran.timetrackinapp.service.TimeEntryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
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
    private final TimeEntryMapper timeEntryMapper;

    @PostMapping("/create")
    public ResponseEntity<TimeEntryResponseDto> create(@Valid @RequestBody TimeEntryRequestDto requestDto){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(timeEntryMapper.toDto(timeEntryService.create(requestDto)));
    };

//    @PutMapping("/{id}")
//    public ResponseEntity<TimeEntryResponseDto> update(Long id, TimeEntryRequestDto requestDto){
//
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(timeEntrymapper.toDto(timeEntryService.update(id,requestDto)));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        timeEntryService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<List<TimeEntryResponseDto>> getTimeEntriesForUser(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(timeEntryService.getTimeEntriesForUser(id).stream()
                        .map(timeEntryMapper::toDto)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/betweenDates")
    public ResponseEntity<List<TimeEntryResponseDto>> getTimeEntriesForUserBetweenDates(
            @RequestParam Long userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<TimeEntry> timeEntries = timeEntryService.getTimeEntriesForUserBetweenDates(userId, startDate, endDate);
        List<TimeEntryResponseDto> response = timeEntries.stream()
                .map(timeEntryMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<TimeEntryResponseDto> findById(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(timeEntryMapper.toDto(timeEntryService.findById(id)));
    }

}
