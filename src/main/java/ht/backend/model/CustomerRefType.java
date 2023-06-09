package ht.backend.model;

import jakarta.persistence.*;

// Related customer on shipment tracking
@Entity
@Table(name = "customer_ref_type")
public class CustomerRefType {

    // Customer ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_ref_type_id")
    private Long id;

    // Resource URI
    @Column
    private String href;

    // Customer name
    @Column
    private String name;

    // Customer description
    @Column
    private String description;
}
