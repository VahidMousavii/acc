package com.av.accounting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "USER_PROFILE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_generator")
    @SequenceGenerator(name = "User_generator",allocationSize = 1,sequenceName = "User_seq")
    @JoinColumn(name = "USER_ID", nullable = false)
    private Long ID;
    private String name;
    private String phone;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "user")
    private List<Account> accountList;
    @OneToMany(fetch = FetchType.LAZY,cascade = { CascadeType.ALL}, mappedBy = "user")
    private List<Transaction> transactionList;

}
