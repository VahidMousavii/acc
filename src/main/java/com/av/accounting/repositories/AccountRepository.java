package com.av.accounting.repositories;


import com.av.accounting.entity.Account;
import com.av.accounting.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAllByUser(User user);


}
