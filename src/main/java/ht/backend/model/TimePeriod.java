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

    public TimePeriod() {
    }

    public TimePeriod(Long id, Timestamp startDateTime, Timestamp endDateTime) {
        this.id = id;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Timestamp startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Timestamp getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Timestamp endDateTime) {
        this.endDateTime = endDateTime;
    }
}
