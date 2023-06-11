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
import java.util.NoSuchElementException;
import java.util.Optional;

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
        Optional<ShipmentTracking> shipmentTracking = shipmentTrackingRepository.findById(id);
        return shipmentTracking.orElseThrow(() -> new EntityNotFoundException("ShipmentTracking with id " + id + " not found"));
    }

    public ShipmentTracking applyPatchToShipmentTracking(JsonMergePatch patch, ShipmentTracking shipmentTracking) throws JsonPatchException, JsonProcessingException {
        JsonNode patched = patch.apply(objectMapper.convertValue(shipmentTracking, JsonNode.class));
        return objectMapper.treeToValue(patched, ShipmentTracking.class);
    }

    public void updateShipmentTracking(ShipmentTracking shipmentTracking) {
        shipmentTrackingRepository.save(shipmentTracking);
    }

    public List<ShipmentTracking> getAllShipmentTrackingByStatus(ShipmentStatus shipmentStatus) throws EntityNotFoundException {
        try{
            List<ShipmentTracking> list = shipmentTrackingRepository.findAllByStatus(shipmentStatus).get();
            if (list.isEmpty()) throw new EntityNotFoundException("There are no shipments with status: " + shipmentStatus);
            else return list;
        } catch (NoSuchElementException e){
            throw new EntityNotFoundException("There are no shipments with status: " + shipmentStatus);
        }
    }

    public List<ShipmentTracking> getAllShipmentTrackingBetweenCreationDates(Timestamp date1, Timestamp date2){
        List<ShipmentTracking> list = shipmentTrackingRepository.findAllBetweenCreationDates(date1, date2).get();
        if (list.isEmpty()) throw new EntityNotFoundException("There are no shipments tracked between those dates.");
        else return list;
    }

    public ShipmentTracking getShipmentTrackingByCreateDate(Timestamp date){
        return shipmentTrackingRepository.findShipmentTrackingByCreateDate(date)
                .orElseThrow(() -> new EntityNotFoundException("There are no shipments with selected date."));
    }
}
