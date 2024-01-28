package spring.listsmicroservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@IdClass(VisitedId.class)
@NoArgsConstructor
public class Visited {

    /* For storing tables of monuments by user who visited them */
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
