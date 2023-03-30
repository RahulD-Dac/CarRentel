package com.saurav.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.saurav.model.Payment;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Integer> {

}
