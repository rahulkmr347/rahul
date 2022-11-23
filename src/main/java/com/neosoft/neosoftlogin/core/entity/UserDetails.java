package com.neosoft.neosoftlogin.core.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER_DETAILS")
@Setter
@Getter
@ToString
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_DETAILS_ID")
    private Long userDetailsId;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "JOINING_DATE")
    @UpdateTimestamp
    private Date joiningDate;

    @Column(name = "EXIT_DATE")
    @UpdateTimestamp
    private Date exitDate;

    @Column(name = "ACHIEVEMENTS")
    private String achievements;

    @Column(name = "CTC")
    private String ctc;
}
