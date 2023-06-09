package ht.backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sub_address")
public class SubAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_address_id")
    private Long id;

    @Column(name = "href")
    private String href;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "sub_unit_type")
    private String subUnitType;

    @Column(name = "sub_unit_number")
    private String subUnitNumber;

    @Column(name = "level_type")
    private String levelType;

    @Column(name = "level_number")
    private String levelNumber;

    @Column(name = "building_name")
    private String buildingName;

    @Column(name = "private_street_number")
    private String privateStreetNumber;

    @Column(name = "private_street_name")
    private String privateStreetName;

    // Relationships

    @OneToMany(mappedBy = "subAddress")
    private List<Characteristic> characteristics;

    @ManyToOne
    @JoinColumn(name="address_id", nullable=false)
    private Address address;
}
