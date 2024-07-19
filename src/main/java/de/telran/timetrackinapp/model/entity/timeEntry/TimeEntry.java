package de.telran.timetrackinapp.model.entity.timeEntry;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.telran.timetrackinapp.model.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(exclude = "user")
@ToString(exclude = "user")
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "time.entry.withUser",
                attributeNodes = @NamedAttributeNode("user")
        )
})
@Table(name = "timeEntry")
public class TimeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDate date = LocalDate.now();

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "timeSpent", nullable = false)
    private Integer timeSpent;

    @Column(name = "user_id",insertable = false, updatable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JsonBackReference
    @Getter
    @Setter
    private User user;
}
