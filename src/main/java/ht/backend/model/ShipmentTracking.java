package ht.backend.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shipment_tracking")
public class ShipmentTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipment_tracking_id")
    private Long id;

    @Column(name = "href")
    private String href;

    @Column(name = "carrier")
    private String carrier;

    @Column(name = "tracking_code")
    private String trackingCode;

    @Column(name = "carrier_tracking_url")
    private String carrierTrackingUrl;

    @Column(name = "tracking_date")
    private Timestamp trackingDate;

    @Column(name = "status")
    private String status;

    @Column(name = "status_change_date")
    private Timestamp statusChangeDate;

    @Column(name = "status_change_reason")
    private String statusChangeReason;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "estimated_delivery_date")
    private Timestamp estimatedDeliveryDate;

    @Column(name = "create_date")
    private Timestamp createDate;

    // Relationships

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "shipment_tracking_address_from_id", referencedColumnName = "address_id")
    private Address addressFrom;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "shipment_tracking_address_to_id", referencedColumnName = "address_id")
    private Address addressTo;

    @OneToMany(mappedBy = "shipmentTracking", fetch = FetchType.LAZY)
    private Set<CheckpointType> checkpoints = new HashSet<CheckpointType>();

    @OneToMany(mappedBy = "shipmentTracking", fetch = FetchType.LAZY)
    private Set<OrderRefType> orders = new HashSet<OrderRefType>();

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "shipment_tracking_related_customer_id", referencedColumnName = "customer_ref_type_id")
    private CustomerRefType relatedCustomer;

    @OneToMany(mappedBy = "shipmentTracking", fetch = FetchType.LAZY)
    private Set<Characteristic> characteristics = new HashSet<Characteristic>();

    public ShipmentTracking() {
    }

    public ShipmentTracking(Long id, String href, String carrier, String trackingCode, String carrierTrackingUrl, Timestamp trackingDate, String status, Timestamp statusChangeDate, String statusChangeReason, Double weight, Timestamp estimatedDeliveryDate, Timestamp createDate, Address addressFrom, Address addressTo, Set<CheckpointType> checkpoints, Set<OrderRefType> orders, CustomerRefType relatedCustomer, Set<Characteristic> characteristics) {
        this.id = id;
        this.href = href;
        this.carrier = carrier;
        this.trackingCode = trackingCode;
        this.carrierTrackingUrl = carrierTrackingUrl;
        this.trackingDate = trackingDate;
        this.status = status;
        this.statusChangeDate = statusChangeDate;
        this.statusChangeReason = statusChangeReason;
        this.weight = weight;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.createDate = createDate;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.checkpoints = checkpoints;
        this.orders = orders;
        this.relatedCustomer = relatedCustomer;
        this.characteristics = characteristics;
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

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public String getCarrierTrackingUrl() {
        return carrierTrackingUrl;
    }

    public void setCarrierTrackingUrl(String carrierTrackingUrl) {
        this.carrierTrackingUrl = carrierTrackingUrl;
    }

    public Timestamp getTrackingDate() {
        return trackingDate;
    }

    public void setTrackingDate(Timestamp trackingDate) {
        this.trackingDate = trackingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getStatusChangeDate() {
        return statusChangeDate;
    }

    public void setStatusChangeDate(Timestamp statusChangeDate) {
        this.statusChangeDate = statusChangeDate;
    }

    public String getStatusChangeReason() {
        return statusChangeReason;
    }

    public void setStatusChangeReason(String statusChangeReason) {
        this.statusChangeReason = statusChangeReason;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Timestamp getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(Timestamp estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Address getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(Address addressFrom) {
        this.addressFrom = addressFrom;
    }

    public Address getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(Address addressTo) {
        this.addressTo = addressTo;
    }

    public Set<CheckpointType> getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(Set<CheckpointType> checkpoints) {
        this.checkpoints = checkpoints;
    }

    public Set<OrderRefType> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderRefType> orders) {
        this.orders = orders;
    }

    public CustomerRefType getRelatedCustomer() {
        return relatedCustomer;
    }

    public void setRelatedCustomer(CustomerRefType relatedCustomer) {
        this.relatedCustomer = relatedCustomer;
    }

    public Set<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Set<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }
}
