package de.telran.timetrackinapp.service.impl;

import de.telran.timetrackinapp.model.entity.user.User;
import de.telran.timetrackinapp.service.StatisticsService;
import de.telran.timetrackinapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final UserService userService;

    @Override
    public void removeLowRatingUsers() {

        List<User> allUsers = userService.getAll();

        allUsers.sort(Comparator.comparingDouble(User::getAverageRating).reversed());

        List<User> topUsers = allUsers.stream()
                .limit(10)
                .toList();

        allUsers.stream()
                .skip(10)
                .forEach(user -> userService.delete(user.getId()));
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void scheduledRemoveLowRatingUsers() {
        removeLowRatingUsers();
    }
}
