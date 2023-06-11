package ht.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import ht.backend.enums.ErrorSeverity;
import ht.backend.enums.ShipmentStatus;
import ht.backend.model.CustomError;
import ht.backend.model.ShipmentTracking;
import ht.backend.service.ShipmentTrackingService;
import jakarta.persistence.EntityNotFoundException;
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
    public ResponseEntity getShipmentTrackingById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(shipmentTrackingService.getShipmentTrackingById(id));
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomError(e, ErrorSeverity.FATAL));
        }

    }

    @GetMapping("/status/{status}")
    public ResponseEntity getShipmentTrackingByStatus(@PathVariable ShipmentStatus status){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(shipmentTrackingService.getAllShipmentTrackingByStatus(status));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomError(e, ErrorSeverity.FATAL));
        }
    }

    @GetMapping("/date")
    public ResponseEntity getShipmentTrackingDate(@RequestParam(required = false) String start,
                                                          @RequestParam(required = false) String end) throws Exception{
        if (start != null && end != null) {
            Timestamp dateA = Timestamp.valueOf(start);
            Timestamp dateB = Timestamp.valueOf(end);
            if (dateA.after(dateB)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomError(new Exception("Start date should be before end date"), ErrorSeverity.FATAL));
            }
            return ResponseEntity.status(HttpStatus.OK).body(shipmentTrackingService.getAllShipmentTrackingBetweenCreationDates(dateA, dateB));
        } else if (start != null) {
            Timestamp dateA = Timestamp.valueOf(start);
            List<ShipmentTracking> list = new ArrayList<ShipmentTracking>();
            try {
                list.add(shipmentTrackingService.getShipmentTrackingByCreateDate(dateA));
            } catch (EntityNotFoundException e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomError(e, ErrorSeverity.FATAL));
            }
            return ResponseEntity.status(HttpStatus.OK).body(list);
        } else if (end != null){
            Timestamp dateB = Timestamp.valueOf(end);
            List<ShipmentTracking> list = new ArrayList<ShipmentTracking>();
            try {
                list.add(shipmentTrackingService.getShipmentTrackingByCreateDate(dateB));
            } catch (EntityNotFoundException e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomError(e, ErrorSeverity.FATAL));
            }
            return ResponseEntity.status(HttpStatus.OK).body(list);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(shipmentTrackingService.getAllShipmentTracking());
        }

    }

    @PostMapping
    public ResponseEntity<ShipmentTracking> addShipmentTracking(@RequestBody ShipmentTracking shipmentTracking){
        ShipmentTracking saved = shipmentTrackingService.addNewShipmentTracking(shipmentTracking);
        return ResponseEntity.created(URI.create("/" + saved.getId())).body(saved);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateShipment(@PathVariable("id") Long id, @RequestBody JsonMergePatch patch) throws JsonPatchException, JsonProcessingException {
        try{
            ShipmentTracking shipmentTracking = shipmentTrackingService.getShipmentTrackingById(id);
            ShipmentTracking shipmentPatched = shipmentTrackingService.applyPatchToShipmentTracking(patch, shipmentTracking);
            shipmentTrackingService.updateShipmentTracking(shipmentPatched);
            return ResponseEntity.ok(shipmentPatched);
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomError(e, ErrorSeverity.FATAL));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomError(new Exception(e), ErrorSeverity.FATAL));
        }
    }

}
