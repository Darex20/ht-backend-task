package ht.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column
    private String href;

    @Column
    private String streetNr;

    @Column
    private String streetNrSuffix;

    @Column
    private String streetNrLast;

    @Column
    private String streetNrLastSuffix;

    @Column
    private String streetName;

    @Column
    private String streetType;

    @Column
    private String streetSuffix;

    @Column
    private String postcode;

    @Column
    private String locality;

    @Column
    private String city;

    @Column
    private String stateOrProvidence;

    @Column
    private String country;

    @Column
    private String fullAddressName;

    @Column
    private String note;

    @OneToOne
    @JoinColumn(name = "address_role_id", referencedColumnName = "address_role_reference_id")
    private AddressRoleReference addressRole;

    @OneToOne
    @JoinColumn(name = "address_valid_for_id", referencedColumnName = "time_period_id")
    private TimePeriod validFor;

    @OneToOne
    @JoinColumn(name = "address_geo_code_id", referencedColumnName = "geo_code_id")
    private GeoCode geoCode;

    @JsonManagedReference
    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private Set<Characteristic> characteristics = new HashSet<Characteristic>();

    @JsonManagedReference
    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private Set<SubAddress> subAddresses = new HashSet<SubAddress>();

    @OneToOne
    @JoinColumn(name = "address_audit_id", referencedColumnName = "audit_id")
    private Audit audit;

    @OneToOne
    @JoinColumn(name = "address_spec_ref_id", referencedColumnName = "version_reference_id")
    private VersionReference addressSpecRef;

    public Address() {
    }

    public Address(Long id, String href, String streetNr, String streetNrSuffix, String streetNrLast, String streetNrLastSuffix, String streetName, String streetType, String streetSuffix, String postcode, String locality, String city, String stateOrProvidence, String country, String fullAddressName, String note, AddressRoleReference addressRole, TimePeriod validFor, GeoCode geoCode, Set<Characteristic> characteristics, Set<SubAddress> subAddresses, Audit audit, VersionReference addressSpecRef) {
        this.id = id;
        this.href = href;
        this.streetNr = streetNr;
        this.streetNrSuffix = streetNrSuffix;
        this.streetNrLast = streetNrLast;
        this.streetNrLastSuffix = streetNrLastSuffix;
        this.streetName = streetName;
        this.streetType = streetType;
        this.streetSuffix = streetSuffix;
        this.postcode = postcode;
        this.locality = locality;
        this.city = city;
        this.stateOrProvidence = stateOrProvidence;
        this.country = country;
        this.fullAddressName = fullAddressName;
        this.note = note;
        this.addressRole = addressRole;
        this.validFor = validFor;
        this.geoCode = geoCode;
        this.characteristics = characteristics;
        this.subAddresses = subAddresses;
        this.audit = audit;
        this.addressSpecRef = addressSpecRef;
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

    public String getStreetNr() {
        return streetNr;
    }

    public void setStreetNr(String streetNr) {
        this.streetNr = streetNr;
    }

    public String getStreetNrSuffix() {
        return streetNrSuffix;
    }

    public void setStreetNrSuffix(String streetNrSuffix) {
        this.streetNrSuffix = streetNrSuffix;
    }

    public String getStreetNrLast() {
        return streetNrLast;
    }

    public void setStreetNrLast(String streetNrLast) {
        this.streetNrLast = streetNrLast;
    }

    public String getStreetNrLastSuffix() {
        return streetNrLastSuffix;
    }

    public void setStreetNrLastSuffix(String streetNrLastSuffix) {
        this.streetNrLastSuffix = streetNrLastSuffix;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public String getStreetSuffix() {
        return streetSuffix;
    }

    public void setStreetSuffix(String streetSuffix) {
        this.streetSuffix = streetSuffix;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateOrProvidence() {
        return stateOrProvidence;
    }

    public void setStateOrProvidence(String stateOrProvidence) {
        this.stateOrProvidence = stateOrProvidence;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFullAddressName() {
        return fullAddressName;
    }

    public void setFullAddressName(String fullAddressName) {
        this.fullAddressName = fullAddressName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public AddressRoleReference getAddressRole() {
        return addressRole;
    }

    public void setAddressRole(AddressRoleReference addressRole) {
        this.addressRole = addressRole;
    }

    public TimePeriod getValidFor() {
        return validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }

    public GeoCode getGeoCode() {
        return geoCode;
    }

    public void setGeoCode(GeoCode geoCode) {
        this.geoCode = geoCode;
    }

    public Set<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Set<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public Set<SubAddress> getSubAddresses() {
        return subAddresses;
    }

    public void setSubAddresses(Set<SubAddress> subAddresses) {
        this.subAddresses = subAddresses;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public VersionReference getAddressSpecRef() {
        return addressSpecRef;
    }

    public void setAddressSpecRef(VersionReference addressSpecRef) {
        this.addressSpecRef = addressSpecRef;
    }
}
