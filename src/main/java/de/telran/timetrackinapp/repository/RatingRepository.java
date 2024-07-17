package de.telran.timetrackinapp.repository;

import de.telran.timetrackinapp.model.entity.rating.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

//    List<Rating> findByToUserId(Long userId);
//
//    List<Rating> findByFromUserId(Long userId);
//
//    List<Rating> findByToUserIdAndRating(Long toUserId, int rating);
//
//    @Query("SELECT AVG(r.grade) FROM Rating r WHERE r.toUserId = :userId")
//    Double findByAverageRatingByUserId(@Param("userId") Long userId);
}
