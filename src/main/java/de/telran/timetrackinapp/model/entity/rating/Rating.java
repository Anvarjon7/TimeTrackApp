package de.telran.timetrackinapp.model.entity.rating;

import com.fasterxml.jackson.annotation.JsonFormat;
import de.telran.timetrackinapp.model.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;

@Data
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode(exclude = "toUserId")
@ToString(exclude = "toUserId")
@Table(name = "rating")
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "rating.withUser",
                attributeNodes = @NamedAttributeNode("toUserId")
        )
})
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long fromUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_user_id", nullable = false)
    @Getter
    @Setter
    private User toUserId;

    @Column(name = "rate", nullable = false)
    private int rating;

    private Long grade;

    private String comment;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @Column(name = "created_on", nullable = false, updatable = false)
    private Timestamp createdOn;
}


