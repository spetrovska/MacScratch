package spring.listsmicroservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@IdClass(WishId.class)
@NoArgsConstructor
public class Wish {
    /* For storing tables of monuments by user who has them in their wishlist */
    @Id
    @ManyToOne
    private User user;

    @Id
    @ManyToOne
    private Monument monument;

    public Wish(User user, Monument monument) {
        this.user = user;
        this.monument = monument;
    }
}
