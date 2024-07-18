package de.telran.timetrackinapp.repository;

import de.telran.timetrackinapp.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticsRepository extends JpaRepository<User, Long> {

}
