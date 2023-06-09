package ht.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;

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

    @OneToMany(mappedBy = "checkpointType")
    private ArrayList<Characteristic> characteristics;

    @ManyToOne
    @JoinColumn(name = "shipment_tracking_id", nullable = false)
    private ShipmentTracking shipmentTracking;
}
