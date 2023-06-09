package ht.backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "characteristic")
public class Characteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "characteristic_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "sub_address_id", nullable = false)
    private SubAddress subAddress;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable=false)
    private Address address;

    @ManyToOne
    @JoinColumn(name = "audit_id", nullable = false)
    private Audit audit;

    @ManyToOne
    @JoinColumn(name = "checkpoint_type_id", nullable = false)
    private CheckpointType checkpointType;

    @ManyToOne
    @JoinColumn(name = "shipment_tracking_id", nullable = false)
    private ShipmentTracking shipmentTracking;

}
