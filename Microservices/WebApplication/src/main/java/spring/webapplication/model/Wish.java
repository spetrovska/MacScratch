package spring.webapplication.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@IdClass(WishId.class)
@NoArgsConstructor
public class Wish {
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
