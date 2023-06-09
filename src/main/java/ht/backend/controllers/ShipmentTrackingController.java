package ht.backend.controllers;

import ht.backend.model.ShipmentTracking;
import ht.backend.services.ShipmentTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/shipmentTracking")
public class ShipmentTrackingController {

    private final ShipmentTrackingService shipmentTrackingService;

    @Autowired
    public ShipmentTrackingController(ShipmentTrackingService shipmentTrackingService) {
        this.shipmentTrackingService = shipmentTrackingService;
    }

    @GetMapping
    public List<ShipmentTracking> getShipmentTracking() {
        return shipmentTrackingService.getShipmentTracking();
    }

    @GetMapping("/{id}")
    public ShipmentTracking getShipmentTrackingById(@PathVariable Long id){
        return shipmentTrackingService.getShipmentTrackingById(id);
    }

    @PostMapping
    public ResponseEntity<ShipmentTracking> addShipmentTracking(@RequestBody ShipmentTracking shipmentTracking){
        ShipmentTracking saved = shipmentTrackingService.addNewShipmentTracking(shipmentTracking);
        return ResponseEntity.created(URI.create("/" + saved.getId())).body(saved);
    }

}
