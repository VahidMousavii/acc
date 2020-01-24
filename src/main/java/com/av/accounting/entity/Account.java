package com.av.accounting.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Account")
@Component
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Account_generator")
    @SequenceGenerator(name = "Account_generator", allocationSize = 1, sequenceName = "Account_seq")
    private Long accountID;
    private String cardNumber;
    private String CVV2;
    private String expiryDate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
    private List<Transaction> transactionList;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    @JsonIgnore
    private User user;
    private Date createDate;


}