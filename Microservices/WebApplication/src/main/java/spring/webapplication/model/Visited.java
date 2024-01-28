package spring.webapplication.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@IdClass(VisitedId.class)
@NoArgsConstructor
public class Visited {
    @Id
    @ManyToOne
    private User user;

    @Id
    @ManyToOne
    private Monument monument;

    public Visited(User user, Monument monument) {
        this.user = user;
        this.monument = monument;
    }
}
