package de.telran.timetrackinapp.model.entity.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import de.telran.timetrackinapp.model.entity.rating.Rating;
import de.telran.timetrackinapp.model.entity.timeEntry.TimeEntry;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(exclude = {"ratings", "timeEntries"})
@ToString(exclude = {"ratings", "timeEntries"})
@Table(name = "user_")
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "User.withRating",
                attributeNodes = @NamedAttributeNode("ratings")
        ),
        @NamedEntityGraph(
                name = "User.withTimeEntry",
                attributeNodes = @NamedAttributeNode("timeEntries")
        ),
        @NamedEntityGraph(
                name = "User.withTimeEntryAndRating",
                attributeNodes = {@NamedAttributeNode("timeEntries"), @NamedAttributeNode("ratings")}
        )
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", updatable = false, nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "average_rating")
    private double averageRating;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp creationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @OneToMany(mappedBy = "toUserId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rating> ratings;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TimeEntry> timeEntries;
}
