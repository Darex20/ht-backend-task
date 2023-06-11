package ht.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import ht.backend.enums.ShipmentStatus;
import ht.backend.model.ShipmentTracking;
import ht.backend.service.ShipmentTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.sql.Timestamp;
import java.util.ArrayList;
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
        return shipmentTrackingService.getAllShipmentTracking();
    }

    @GetMapping("/{id}")
    public ShipmentTracking getShipmentTrackingById(@PathVariable Long id){
        return shipmentTrackingService.getShipmentTrackingById(id);
    }

    @GetMapping("/status/{status}")
    public List<ShipmentTracking> getShipmentTrackingByStatus(@PathVariable ShipmentStatus status){
        return shipmentTrackingService.getAllShipmentTrackingByStatus(status);
    }

    @GetMapping("/date")
    public List<ShipmentTracking> getShipmentTrackingDate(@RequestParam(required = false) String start,
                                                          @RequestParam(required = false) String end) throws Exception{
        if (start != null && end != null) {
            Timestamp dateA = Timestamp.valueOf(start);
            Timestamp dateB = Timestamp.valueOf(end);
            if (dateA.after(dateB)){
                throw new Exception("First date should be before second one.");
            }
            return shipmentTrackingService.getAllShipmentTrackingBetweenCreationDates(dateA, dateB);
        } else if (start != null) {
            Timestamp dateA = Timestamp.valueOf(start);
            List<ShipmentTracking> list = new ArrayList<ShipmentTracking>();
            list.add(shipmentTrackingService.getShipmentTrackingByCreateDate(dateA));
            return list;
        } else if (end != null){
            Timestamp dateB = Timestamp.valueOf(end);
            List<ShipmentTracking> list = new ArrayList<ShipmentTracking>();
            list.add(shipmentTrackingService.getShipmentTrackingByCreateDate(dateB));
            return list;
        } else {
            return shipmentTrackingService.getAllShipmentTracking();
        }

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
