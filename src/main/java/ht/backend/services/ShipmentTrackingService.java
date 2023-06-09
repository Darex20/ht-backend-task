package ht.backend.services;

import ht.backend.model.Error;
import ht.backend.model.ShipmentTracking;
import ht.backend.repositories.ShipmentTrackingRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentTrackingService {

    private final ShipmentTrackingRepository shipmentTrackingRepository;

    @Autowired
    public ShipmentTrackingService(ShipmentTrackingRepository shipmentTrackingRepository) {
        this.shipmentTrackingRepository = shipmentTrackingRepository;
    }

    public List<ShipmentTracking> getShipmentTracking() {
        return shipmentTrackingRepository.findAll();
    }

    public ShipmentTracking addNewShipmentTracking(ShipmentTracking shipmentTracking) {
        return shipmentTrackingRepository.save(shipmentTracking);
    }

    public ShipmentTracking getShipmentTrackingById(Long id) {
        return shipmentTrackingRepository.findShipmentTrackingById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shipment Tracking was not found."));
    }
}
