package ht.backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import ht.backend.enums.ShipmentStatus;
import ht.backend.model.ShipmentTracking;
import ht.backend.repository.ShipmentTrackingRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ShipmentTrackingService {

    private final ShipmentTrackingRepository shipmentTrackingRepository;

    private final ObjectMapper objectMapper;

    @Autowired
    public ShipmentTrackingService(ShipmentTrackingRepository shipmentTrackingRepository, ObjectMapper objectMapper) {
        this.shipmentTrackingRepository = shipmentTrackingRepository;
        this.objectMapper = objectMapper;
    }

    public List<ShipmentTracking> getAllShipmentTracking() {
        return shipmentTrackingRepository.findAll();
    }

    public ShipmentTracking addNewShipmentTracking(ShipmentTracking shipmentTracking) {
        return shipmentTrackingRepository.save(shipmentTracking);
    }

    public ShipmentTracking getShipmentTrackingById(Long id) {
        return shipmentTrackingRepository.findShipmentTrackingById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shipment Tracking with that id was not found."));
    }

    public ShipmentTracking applyPatchToShipmentTracking(JsonMergePatch patch, ShipmentTracking shipmentTracking) throws JsonPatchException, JsonProcessingException {
        JsonNode patched = patch.apply(objectMapper.convertValue(shipmentTracking, JsonNode.class));
        return objectMapper.treeToValue(patched, ShipmentTracking.class);
    }

    public void updateShipmentTracking(ShipmentTracking shipmentTracking) {
        shipmentTrackingRepository.save(shipmentTracking);
    }

    public List<ShipmentTracking> getAllShipmentTrackingByStatus(ShipmentStatus shipmentStatus) {
        return shipmentTrackingRepository.findAllByStatus(shipmentStatus)
                .orElseThrow(() -> new EntityNotFoundException("Shipment Tracking with that id was not found."));
    }

    public List<ShipmentTracking> getAllShipmentTrackingBetweenCreationDates(Timestamp date1, Timestamp date2){
        return shipmentTrackingRepository.findAllBetweenCreationDates(date1, date2)
                .orElseThrow(() -> new EntityNotFoundException("There are no shipments tracked between those dates."));
    }

    public ShipmentTracking getShipmentTrackingByCreateDate(Timestamp date){
        return shipmentTrackingRepository.findShipmentTrackingByCreateDate(date)
                .orElseThrow(() -> new EntityNotFoundException("There are no shipments with selected date."));
    }
}
