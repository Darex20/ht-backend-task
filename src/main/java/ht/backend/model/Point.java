package ht.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "point")
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_id")
    private Long id;

    @Column(name = "x")
    private String x;

    @Column(name = "y")
    private String y;

    @Column(name = "z")
    private String z;

    public Point() {
    }

    public Point(String x, String y, String z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
