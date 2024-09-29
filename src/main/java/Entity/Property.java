package Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long property_id;
    private String name;
    private String address;
    private String city;
    private String country;
    private Double pricePerNight;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

}
