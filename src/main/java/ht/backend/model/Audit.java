package ht.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "audit")
    private ArrayList<Characteristic> characteristics;
}
