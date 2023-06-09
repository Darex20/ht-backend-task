package ht.backend.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "time_period")
public class TimePeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_period_id")
    private Long id;

    @Column(name = "start_date_time")
    private Timestamp startDateTime;

    @Column(name = "end_date_time")
    private Timestamp endDateTime;

}
