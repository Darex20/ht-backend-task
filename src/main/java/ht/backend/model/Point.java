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

    public Point(Long id, String x, String y, String z) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }
}
