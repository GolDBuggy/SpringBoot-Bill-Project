package com.bill.java.billproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "wallet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {

    @Id
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID")
    @Column(name = "wallet_id")
    private String id;

    @Column(name = "cash")
    private BigDecimal cash;

    @OneToOne
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member member;

}
