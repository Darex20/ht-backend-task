package ht.backend.model;

import jakarta.persistence.*;
import org.aspectj.asm.internal.Relationship;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "shipment_tracking")
public class ShipmentTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipment_tracking_id")
    private Long id;

    @Column(name = "href")
    private String href;

    @Column(name = "carrier")
    private String carrier;

    @Column(name = "tracking_code")
    private String trackingCode;

    @Column(name = "carrier_tracking_url")
    private String carrierTrackingUrl;

    @Column(name = "tracking_date")
    private Timestamp trackingDate;

    @Column(name = "status")
    private String status;

    @Column(name = "status_change_date")
    private Timestamp statusChangeDate;

    @Column(name = "status_change_reason")
    private String statusChangeReason;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "estimated_delivery_date")
    private Timestamp estimatedDeliveryDate;

    @Column(name = "create_date")
    private Timestamp createDate;

    // Relationships

    @OneToOne
    @JoinColumn(name = "shipment_tracking_address_from_id", referencedColumnName = "address_id")
    private Address addressFrom;

    @OneToOne
    @JoinColumn(name = "shipment_tracking_address_to_id", referencedColumnName = "address_id")
    private Address addressTo;

    @OneToMany(mappedBy = "shipmentTracking")
    private List<CheckpointType> checkpoints;

    @OneToMany(mappedBy = "shipmentTracking")
    private List<OrderRefType> orders;

    @OneToOne
    @JoinColumn(name = "shipment_tracking_related_customer_id", referencedColumnName = "customer_ref_type_id")
    private CustomerRefType relatedCustomer;

    @OneToMany(mappedBy = "shipmentTracking")
    private List<Characteristic> characteristics;

}
