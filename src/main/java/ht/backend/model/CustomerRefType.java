package ht.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

// Related customer on shipment tracking
@Entity
@Table(name = "customer_ref_type")
public class CustomerRefType {

    // Customer ID
    @JsonIgnore
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

    public CustomerRefType() {
    }

    public CustomerRefType(Long id, String href, String name, String description) {
        this.id = id;
        this.href = href;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
