package ht.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "characteristic")
public class Characteristic {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "characteristic_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sub_address_id", nullable = false)
    private SubAddress subAddress;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "address_id", nullable=false)
    private Address address;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "audit_id", nullable = false)
    private Audit audit;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "checkpoint_type_id", nullable = false)
    private CheckpointType checkpointType;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "shipment_tracking_id", nullable = false)
    private ShipmentTracking shipmentTracking;

    public Characteristic() {
    }

    public Characteristic(Long id, String name, String value, SubAddress subAddress, Address address, Audit audit, CheckpointType checkpointType, ShipmentTracking shipmentTracking) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.subAddress = subAddress;
        this.address = address;
        this.audit = audit;
        this.checkpointType = checkpointType;
        this.shipmentTracking = shipmentTracking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public SubAddress getSubAddress() {
        return subAddress;
    }

    public void setSubAddress(SubAddress subAddress) {
        this.subAddress = subAddress;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public CheckpointType getCheckpointType() {
        return checkpointType;
    }

    public void setCheckpointType(CheckpointType checkpointType) {
        this.checkpointType = checkpointType;
    }

    public ShipmentTracking getShipmentTracking() {
        return shipmentTracking;
    }

    public void setShipmentTracking(ShipmentTracking shipmentTracking) {
        this.shipmentTracking = shipmentTracking;
    }
}
