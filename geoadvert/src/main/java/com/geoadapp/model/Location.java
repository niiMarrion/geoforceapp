package com.geoadapp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Entity
@Table(name = "location")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Digits(integer = 3, fraction = 7)
    private Double latitude;

    @NonNull
    @Digits(integer = 3, fraction = 7)
    private Double longitude;


    private Double radius;

    public Location(@NonNull @Digits(integer = 3, fraction = 7) Double latitude, @NonNull @Digits(integer = 3, fraction = 7) Double longitude, Double radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }
}
