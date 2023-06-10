package ht.backend.model;

import ht.backend.enums.ErrorSeverity;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "error")
public class Error {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "error_id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "is_title_enabled")
    private boolean isTitleEnabled;

    @Column(name = "message")
    private String message;

    @Column(name = "title")
    private String title;

    @Column(name = "html_label")
    private String htmlLabel;

    @Column(name = "label")
    private String label;

    @Column(name = "retryable")
    private boolean retryable;

    @Column(name = "severity")
    private ErrorSeverity severity;

    @Column
    private String details;

    // Constructors, getters, and setters

    public Error() {
    }

    public Error(Long id, String code, Timestamp timestamp, boolean isTitleEnabled, String message, String title, String htmlLabel, String label, boolean retryable, ErrorSeverity severity, String details) {
        this.id = id;
        this.code = code;
        this.timestamp = timestamp;
        this.isTitleEnabled = isTitleEnabled;
        this.message = message;
        this.title = title;
        this.htmlLabel = htmlLabel;
        this.label = label;
        this.retryable = retryable;
        this.severity = severity;
        this.details = details;
    }

    // Getters and setters

    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "timestamp")
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Column(name = "is_title_enabled")
    public boolean isTitleEnabled() {
        return isTitleEnabled;
    }

    public void setTitleEnabled(boolean isTitleEnabled) {
        this.isTitleEnabled = isTitleEnabled;
    }

    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "html_label")
    public String getHtmlLabel() {
        return htmlLabel;
    }

    public void setHtmlLabel(String htmlLabel) {
        this.htmlLabel = htmlLabel;
    }

    @Column(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Column(name = "retryable")
    public boolean isRetryable() {
        return retryable;
    }

    public void setRetryable(boolean retryable) {
        this.retryable = retryable;
    }

    @Column(name = "severity")
    public ErrorSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(ErrorSeverity severity) {
        this.severity = severity;
    }
}

