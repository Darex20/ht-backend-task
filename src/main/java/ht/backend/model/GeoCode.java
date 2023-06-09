package ht.backend.model;

import jakarta.persistence.*;

// Used to provide information on geographic code. Deprecated and shouldn't be used. Use "location" instead.
@Entity
@Table(name = "geo_code")
public class GeoCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "geo_code_id")
    private Long id;

    @Column
    private String latitude;

    @Column
    private String longitude;

    @Column
    private String geographicDatum;

}
