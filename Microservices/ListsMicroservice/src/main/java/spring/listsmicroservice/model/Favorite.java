package spring.listsmicroservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@IdClass(FavouriteId.class)
@NoArgsConstructor
@Table(schema = "dians-proba-mapa")
public class Favorite {
    /* For storing tables of monuments by user who has them as favorite */
    @Id
    @ManyToOne
    private User user;

    @Id
    @ManyToOne
    private Monument monument;

    public Favorite(User user, Monument monument) {
        this.user = user;
        this.monument = monument;
    }
}
