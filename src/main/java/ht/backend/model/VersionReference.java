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

    public VersionReference() {
    }

    public VersionReference(Long id, String href, String name, String version) {
        this.id = id;
        this.href = href;
        this.name = name;
        this.version = version;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}