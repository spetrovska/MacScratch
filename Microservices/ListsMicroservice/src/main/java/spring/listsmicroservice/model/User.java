package spring.listsmicroservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
/*Because "User" is a reserved word, the entity table needs to be renamed */
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    private String username;

    public User(String username) {
        this.username = username;
    }
}
