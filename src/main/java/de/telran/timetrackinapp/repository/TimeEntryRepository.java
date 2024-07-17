package de.telran.timetrackinapp.repository;

import de.telran.timetrackinapp.entity.timeEntry.TimeEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {

//    List<TimeEntry> findByUserId(Long userId);
//
//    List<TimeEntry> findByUserIdAndDate(Long userId, LocalDate date);
//
//    List<TimeEntry> findByUserIdAndCategory(Long userId, String category);
//
//    List<TimeEntry> findByUserIdAndDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
}
