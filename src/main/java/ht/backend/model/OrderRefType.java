package ht.backend.model;

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

    @ManyToOne
    @JoinColumn(name = "shipment_tracking_id", nullable = false)
    private ShipmentTracking shipmentTracking;
}
