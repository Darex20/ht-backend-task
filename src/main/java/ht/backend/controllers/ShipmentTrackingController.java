package ht.backend.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import ht.backend.model.ShipmentTracking;
import ht.backend.services.ShipmentTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PatchMapping("/{id}")
    public ResponseEntity<ShipmentTracking> updateShipment(@PathVariable("id") Long id, @RequestBody JsonMergePatch patch) throws JsonPatchException, JsonProcessingException {
        try{
            ShipmentTracking shipmentTracking = shipmentTrackingService.getShipmentTrackingById(id);
            ShipmentTracking shipmentPatched = shipmentTrackingService.applyPatchToShipmentTracking(patch, shipmentTracking);
            shipmentTrackingService.updateShipmentTracking(shipmentPatched);
            return ResponseEntity.ok(shipmentPatched);
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
