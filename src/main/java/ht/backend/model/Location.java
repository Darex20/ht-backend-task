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

    @OneToOne
    @JoinColumn(name = "location_point_id", referencedColumnName = "point_id")
    private Point geometry;

}
