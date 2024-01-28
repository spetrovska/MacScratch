package spring.citiesmicroservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Monument {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String enName;
    /* For religious objects such as churches and mosques */
    private String religion;
    private String website;
    private String opening_hours;
    private String phone;
    private String email;

    /*Latitude and longitude of the location of each Monument */
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