package de.telran.timetrackinapp.repository;

import de.telran.timetrackinapp.model.entity.timeEntry.TimeEntry;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {

    @EntityGraph(value = "TimeEntry.withUser", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT t FROM TimeEntry t WHERE t.id = :id")
    Optional<TimeEntry> findByIdWithUser(Long id);

    @Query("SELECT t FROM TimeEntry t WHERE t.userId.id = :id")
    List<TimeEntry> findByUserId(Long id);

    @Query("SELECT t FROM TimeEntry t WHERE t.userId = :userId AND t.date BETWEEN :startDate AND :endDate")
    List<TimeEntry> findByUserIdAndDateBetween(@Param("userId") Long id, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
