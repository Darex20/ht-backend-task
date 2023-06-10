package ht.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long id;

    @Column
    private String href;

    @Column
    private String name;

    @Column
    private String geometryType;

    @Column
    private String accuracy;

    @Column
    private String spatialRef;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "location_point_id", referencedColumnName = "point_id")
    private Point geometry;

    public Location() {
    }

    public Location(Long id, String href, String name, String geometryType, String accuracy, String spatialRef, Point geometry) {
        this.id = id;
        this.href = href;
        this.name = name;
        this.geometryType = geometryType;
        this.accuracy = accuracy;
        this.spatialRef = spatialRef;
        this.geometry = geometry;
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

    public String getGeometryType() {
        return geometryType;
    }

    public void setGeometryType(String geometryType) {
        this.geometryType = geometryType;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getSpatialRef() {
        return spatialRef;
    }

    public void setSpatialRef(String spatialRef) {
        this.spatialRef = spatialRef;
    }

    public Point getGeometry() {
        return geometry;
    }

    public void setGeometry(Point geometry) {
        this.geometry = geometry;
    }
}
