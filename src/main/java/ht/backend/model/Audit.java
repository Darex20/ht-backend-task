package ht.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "audit")
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_id")
    private Long id;

    @Column
    private String createdBy;

    @Column
    // @JsonFormat(pattern="yyyy-MM-dd-HH:mm:ss")
    private Timestamp createdDate;

    @Column
    private String entityVersion;

    @Column
    private String tagId;

    @Column
    private String spanId;

    @Column
    private String changeReason;

    @Column
    private String sourceSystem;

    @Column
    private String sourceSystemUser;

    @OneToMany(mappedBy = "audit", fetch = FetchType.LAZY)
    private Set<Characteristic> characteristics = new HashSet<Characteristic>();

    public Audit() {
    }

    public Audit(Long id, String createdBy, Timestamp createdDate, String entityVersion, String tagId, String spanId, String changeReason, String sourceSystem, String sourceSystemUser, Set<Characteristic> characteristics) {
        this.id = id;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.entityVersion = entityVersion;
        this.tagId = tagId;
        this.spanId = spanId;
        this.changeReason = changeReason;
        this.sourceSystem = sourceSystem;
        this.sourceSystemUser = sourceSystemUser;
        this.characteristics = characteristics;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getEntityVersion() {
        return entityVersion;
    }

    public void setEntityVersion(String entityVersion) {
        this.entityVersion = entityVersion;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getSpanId() {
        return spanId;
    }

    public void setSpanId(String spanId) {
        this.spanId = spanId;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getSourceSystemUser() {
        return sourceSystemUser;
    }

    public void setSourceSystemUser(String sourceSystemUser) {
        this.sourceSystemUser = sourceSystemUser;
    }

    public Set<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Set<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }
}
