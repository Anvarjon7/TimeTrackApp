package de.telran.timetrackinapp.repository;

import de.telran.timetrackinapp.entity.user.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopUserRepository extends JpaRepository<User, Long> {

//    @Query("SELECT u FROM User u LEFT JOIN Rating r ON u.id = r.toUserId GROUP BY u.id ORDER BY AVG(r.rating) DESC ")
//    List<User> findTop10Users(Pageable pageable);
//
//    @Query("SELECT u FROM User u LEFT JOIN Rating r ON u.id = r.toUserId GROUP BY u.id ORDER BY AVG(r.rating) DESC ")
//    List<User> findAllExceptTop10Users(Pageable pageable);
}
