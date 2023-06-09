package ht.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

// Used to provide information on geographic code. Deprecated and shouldn't be used. Use "location" instead.
@Entity
@Table(name = "geo_code")
public class GeoCode {

    @JsonIgnore
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

    public GeoCode() {
    }

    public GeoCode(Long id, String latitude, String longitude, String geographicDatum) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.geographicDatum = geographicDatum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getGeographicDatum() {
        return geographicDatum;
    }

    public void setGeographicDatum(String geographicDatum) {
        this.geographicDatum = geographicDatum;
    }
}
