package ht.backend.model;

import ht.backend.enums.AddressRole;
import jakarta.persistence.*;

@Entity
@Table(name = "address_role_reference")
public class AddressRoleReference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_role_reference_id")
    private Long id;

    @Column(name = "href")
    private String href;

    @Column(name = "role")
    private AddressRole role;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "address_role_time_period_id", referencedColumnName = "time_period_id")
    private TimePeriod validFor;

    public AddressRoleReference() {
    }

    public AddressRoleReference(Long id, String href, AddressRole role, String name, TimePeriod validFor) {
        this.id = id;
        this.href = href;
        this.role = role;
        this.name = name;
        this.validFor = validFor;
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

    public AddressRole getRole() {
        return role;
    }

    public void setRole(AddressRole role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TimePeriod getValidFor() {
        return validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }
}
