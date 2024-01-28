package spring.webapplication.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@IdClass(FavouriteId.class)
@NoArgsConstructor
public class Favorite {
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
