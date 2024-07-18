package de.telran.timetrackinapp.repository;

import de.telran.timetrackinapp.model.entity.rating.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("SELECT r FROM  Rating r WHERE r.toUserId = :toUserId")
    List<Rating> findByToUserId(@Param("toUserId")Long toUserId);

}
