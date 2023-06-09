package ht.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "version_reference")
public class VersionReference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "version_reference_id")
    private Long id;

    @Column(name = "href")
    private String href;

    @Column(name = "name")
    private String name;

    @Column(name = "version")
    private String version;

}