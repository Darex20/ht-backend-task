package ht.backend.model;

import ht.backend.enums.ErrorSeverity;

import java.sql.Timestamp;

import static java.lang.System.currentTimeMillis;

public class CustomError {

    private Long id;

    private String code;

    private Timestamp timestamp;

    private boolean isTitleEnabled;

    private String message;

    private String title;

    private String htmlLabel;

    private String label;

    private boolean retryable;

    private ErrorSeverity severity;

    private String details;

    // Constructors, getters, and setters

    public CustomError() {
    }

    public CustomError(Exception e, ErrorSeverity severity){
        this.code = "code";
        this.timestamp = new Timestamp(currentTimeMillis());
        this.isTitleEnabled = true;
        this.message = e.getMessage();
        this.title = "title";
        this.htmlLabel = "htmlLabel";
        this.label = "label";
        this.retryable = false;
        this.severity = severity;
        this.details = "";
    }

    public CustomError(Long id, String code, Timestamp timestamp, boolean isTitleEnabled, String message, String title, String htmlLabel, String label, boolean retryable, ErrorSeverity severity, String details) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isTitleEnabled() {
        return isTitleEnabled;
    }

    public void setTitleEnabled(boolean isTitleEnabled) {
        this.isTitleEnabled = isTitleEnabled;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHtmlLabel() {
        return htmlLabel;
    }

    public void setHtmlLabel(String htmlLabel) {
        this.htmlLabel = htmlLabel;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isRetryable() {
        return retryable;
    }

    public void setRetryable(boolean retryable) {
        this.retryable = retryable;
    }

    public ErrorSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(ErrorSeverity severity) {
        this.severity = severity;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

