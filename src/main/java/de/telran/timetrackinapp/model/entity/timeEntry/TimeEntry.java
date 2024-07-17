package de.telran.timetrackinapp.model.entity.timeEntry;

import de.telran.timetrackinapp.model.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "time_entry")
@EqualsAndHashCode(exclude = "userId")
@ToString(exclude = "userId")
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "time.entry.withUser",
                attributeNodes = @NamedAttributeNode("userId")
        )
})
public class TimeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDate date = LocalDate.now();

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "time_spent", nullable = false)
    private int timeSpent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @Getter
    @Setter
    private User userId;

}
