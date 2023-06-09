package ht.backend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    @OneToMany(mappedBy = "address")
    private ArrayList<Characteristic> characteristics;

    @OneToMany(mappedBy = "address")
    private ArrayList<SubAddress> subAddresses;

    @OneToOne
    @JoinColumn(name = "address_audit_id", referencedColumnName = "audit_id")
    private Audit audit;

    @OneToOne
    @JoinColumn(name = "address_spec_ref_id", referencedColumnName = "version_reference_id")
    private VersionReference addressSpecRef;

    public Address() {
    }

    public Address(String href, AddressRoleReference addressRole, TimePeriod validFor, String streetNr, String streetNrSuffix, String streetNrLast, String streetNrLastSuffix, String streetName, String streetType, String streetSuffix, String postcode, String locality, String city, String stateOrProvidence, String country, GeoCode geoCode, String fullAddressName, ArrayList<Characteristic> characteristics, ArrayList<SubAddress> subAddresses, String note, Audit audit, VersionReference addressSpecRef) {
        this.href = href;
        this.addressRole = addressRole;
        this.validFor = validFor;
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
        this.geoCode = geoCode;
        this.fullAddressName = fullAddressName;
        this.characteristics = characteristics;
        this.subAddresses = subAddresses;
        this.note = note;
        this.audit = audit;
        this.addressSpecRef = addressSpecRef;
    }
}
