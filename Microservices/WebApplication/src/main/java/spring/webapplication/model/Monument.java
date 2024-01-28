package spring.webapplication.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Monument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String enName;
    private String religion;
    private String website;
    private String opening_hours;
    private String phone;
    private String email;

    private String lat;
    private String lon;

    public Monument(String name, String enName, String religion, String website,
                    String opening_hours, String phone, String email, String lat, String lon) {
        this.name = name;
        this.enName = enName;
        this.religion = religion;
        this.website = website;
        this.opening_hours = opening_hours;
        this.phone = phone;
        this.email = email;
        this.lat = lat;
        this.lon = lon;
    }
}
