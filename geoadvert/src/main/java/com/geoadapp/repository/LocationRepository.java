package com.geoadapp.repository;

import com.geoadapp.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    Location findByLatitudeAndLongitude(Double latitude, Double longitude);

    Long findByLongitudeAndLatitude(Location location);

    Long findByLongitudeAndLatitude(Double longitude, Double latitude);


}
