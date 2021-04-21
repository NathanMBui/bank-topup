package com.abcbank.topup.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Voucher")
@Getter
@Setter
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @Column(name = "phone")
    private String phone;

    @Column(name = "code")
    @NotBlank
    private String code;

    @Column(name = "type")
    @NotBlank
    private String type;

    @Column(name = "provider")
    @NotBlank
    private String provider;

    @Column(name = "description")
    private String description;
}
