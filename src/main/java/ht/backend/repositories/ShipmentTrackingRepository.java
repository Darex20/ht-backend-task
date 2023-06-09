package ht.backend.repositories;

import ht.backend.model.ShipmentTracking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentTrackingRepository extends JpaRepository<ShipmentTracking, Long> {
}
