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

}
