package ht.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Checkpoint Type
@Entity
@Table(name = "checkpoint_type")
public class CheckpointType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checkpoint_type_id")
    private Long id;

    @Column
    private String status;

    @Column
    private String message;

    @JsonFormat(pattern="yyyy-MM-dd-HH:mm:ss")
    @Column
    private Timestamp date;

    @Column
    private String checkPost;

    @Column
    private String city;

    @Column
    private String stateOrProvince;

    @Column
    private String country;

    @JsonManagedReference
    @OneToMany(mappedBy = "checkpointType", fetch = FetchType.LAZY)
    private Set<Characteristic> characteristics = new HashSet<Characteristic>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "shipment_tracking_id", nullable = false)
    private ShipmentTracking shipmentTracking;

    public CheckpointType() {
    }

    public CheckpointType(Long id, String status, String message, Timestamp date, String checkPost, String city, String stateOrProvince, String country, Set<Characteristic> characteristics, ShipmentTracking shipmentTracking) {
        this.id = id;
        this.status = status;
        this.message = message;
        this.date = date;
        this.checkPost = checkPost;
        this.city = city;
        this.stateOrProvince = stateOrProvince;
        this.country = country;
        this.characteristics = characteristics;
        this.shipmentTracking = shipmentTracking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getCheckPost() {
        return checkPost;
    }

    public void setCheckPost(String checkPost) {
        this.checkPost = checkPost;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Set<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public ShipmentTracking getShipmentTracking() {
        return shipmentTracking;
    }

    public void setShipmentTracking(ShipmentTracking shipmentTracking) {
        this.shipmentTracking = shipmentTracking;
    }
}
