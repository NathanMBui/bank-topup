package com.abcbank.topup.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "User")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false, nullable = false)
    private long id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "user")
    private Set<Voucher> vouchers;
}
