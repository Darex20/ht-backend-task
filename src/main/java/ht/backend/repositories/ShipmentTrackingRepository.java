package ht.backend.repositories;

import ht.backend.enums.ShipmentStatus;
import ht.backend.model.ShipmentTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface ShipmentTrackingRepository extends JpaRepository<ShipmentTracking, Long> {

    Optional<ShipmentTracking> findShipmentTrackingById(Long id);

    Optional<List<ShipmentTracking>> findAllByStatus(ShipmentStatus status);

    Optional<ShipmentTracking> findShipmentTrackingByCreateDate(Timestamp date);

    @Query(value = "SELECT * from shipment_tracking s where s.create_date >= :date1 and s.create_date <= :date2", nativeQuery = true)
    Optional<List<ShipmentTracking>> findAllBetweenCreationDates(Timestamp date1, Timestamp date2);
}
