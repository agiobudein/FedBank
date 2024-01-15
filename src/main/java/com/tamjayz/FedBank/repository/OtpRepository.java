package com.tamjayz.FedBank.repository;

import com.tamjayz.FedBank.model.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpRepository extends JpaRepository<Otp, Long> {

    Otp findByEmail(String email);
}
