package ht.backend.repositories;

import ht.backend.model.ShipmentTracking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShipmentTrackingRepository extends JpaRepository<ShipmentTracking, Long> {

    Optional<ShipmentTracking> findShipmentTrackingById(Long id);
}
