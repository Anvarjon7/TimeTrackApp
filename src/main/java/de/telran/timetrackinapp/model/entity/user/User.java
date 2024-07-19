package de.telran.timetrackinapp.model.entity.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import de.telran.timetrackinapp.model.entity.rating.Rating;
import de.telran.timetrackinapp.model.entity.timeEntry.TimeEntry;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

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

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email", updatable = false, nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "averageRating")
    private Double averageRating;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @Column(name = "creationDate", nullable = false, updatable = false)
    private Timestamp createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Rating> ratings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TimeEntry> timeEntries;
}
