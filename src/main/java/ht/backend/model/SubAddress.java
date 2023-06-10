package ht.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "subAddress", fetch = FetchType.LAZY)
    private Set<Characteristic> characteristics = new HashSet<Characteristic>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="address_id", nullable=false)
    private Address address;

    public SubAddress() {
    }

    public SubAddress(Long id, String href, String type, String name, String subUnitType, String subUnitNumber, String levelType, String levelNumber, String buildingName, String privateStreetNumber, String privateStreetName, Set<Characteristic> characteristics, Address address) {
        this.id = id;
        this.href = href;
        this.type = type;
        this.name = name;
        this.subUnitType = subUnitType;
        this.subUnitNumber = subUnitNumber;
        this.levelType = levelType;
        this.levelNumber = levelNumber;
        this.buildingName = buildingName;
        this.privateStreetNumber = privateStreetNumber;
        this.privateStreetName = privateStreetName;
        this.characteristics = characteristics;
        this.address = address;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubUnitType() {
        return subUnitType;
    }

    public void setSubUnitType(String subUnitType) {
        this.subUnitType = subUnitType;
    }

    public String getSubUnitNumber() {
        return subUnitNumber;
    }

    public void setSubUnitNumber(String subUnitNumber) {
        this.subUnitNumber = subUnitNumber;
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }

    public String getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(String levelNumber) {
        this.levelNumber = levelNumber;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getPrivateStreetNumber() {
        return privateStreetNumber;
    }

    public void setPrivateStreetNumber(String privateStreetNumber) {
        this.privateStreetNumber = privateStreetNumber;
    }

    public String getPrivateStreetName() {
        return privateStreetName;
    }

    public void setPrivateStreetName(String privateStreetName) {
        this.privateStreetName = privateStreetName;
    }

    public Set<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Set<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
