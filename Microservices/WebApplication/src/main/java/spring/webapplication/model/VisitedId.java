package spring.webapplication.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class VisitedId implements Serializable {

    private User user;
    private Monument monument;

    public VisitedId(User user, Monument monument) {
        this.user = user;
        this.monument = monument;
    }
}

