package spring.webapplication.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    private String username;
    private String name;
    private String surname;

    private String password;

    private String feedback;
    private boolean isSatisfied;

    public User(String name, String surname, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.feedback = "";
        this.isSatisfied = true;
    }
}
