package de.telran.timetrackinapp.repository;

import de.telran.timetrackinapp.model.entity.rating.Rating;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    @EntityGraph(value = "Rating.withUser", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT r FROM Rating r WHERE r.id = :id")
    Optional<Rating> findByIdWithUser(Long id);

    @Query("SELECT r FROM  Rating r WHERE r.toUser = :toUserId")
    List<Rating> findByToUserId(@Param("toUserId")Long toUserId);
}
