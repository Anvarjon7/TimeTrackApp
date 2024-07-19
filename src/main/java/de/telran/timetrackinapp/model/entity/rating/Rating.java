package de.telran.timetrackinapp.model.entity.rating;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@EqualsAndHashCode(exclude = "user")
@ToString(exclude = "user")
@Table(name = "rating")
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "rating.withUser",
                attributeNodes = @NamedAttributeNode("user")
        )
})
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fromUserId", nullable = false)
    private Long fromUser;

    @Column(name = "toUserId", nullable = false)
    private Long toUser;

    @Column(name = "rate", nullable = false)
    private Long grade;

    private String comment;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @Column(name = "creationDate", nullable = false, updatable = false)
    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JsonBackReference
    private User user;
}


