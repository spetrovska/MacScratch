package spring.listsmicroservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class WishId implements Serializable {

    private User user;
    private Monument monument;

    public WishId(User user, Monument monument) {
        this.user = user;
        this.monument = monument;
    }
}