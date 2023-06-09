package ht.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "order_ref_type")
public class OrderRefType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_ref_type_id")
    private Long id;

    @Column(name = "href")
    private String href;

    @Column(name = "name")
    private String name;

    @Column(name = "reffered_type")
    private String referredType;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "shipment_tracking_id", nullable = false)
    private ShipmentTracking shipmentTracking;

    public OrderRefType() {
    }

    public OrderRefType(Long id, String href, String name, String referredType, ShipmentTracking shipmentTracking) {
        this.id = id;
        this.href = href;
        this.name = name;
        this.referredType = referredType;
        this.shipmentTracking = shipmentTracking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReferredType() {
        return referredType;
    }

    public void setReferredType(String referredType) {
        this.referredType = referredType;
    }

    public ShipmentTracking getShipmentTracking() {
        return shipmentTracking;
    }

    public void setShipmentTracking(ShipmentTracking shipmentTracking) {
        this.shipmentTracking = shipmentTracking;
    }
}
