package com.tamjayz.FedBank.service;

import com.tamjayz.FedBank.dto.*;
import com.tamjayz.FedBank.model.Otp;
import com.tamjayz.FedBank.repository.OtpRepository;
import com.tamjayz.FedBank.utils.AccountUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class OtpService {

    private OtpRepository otpRepository;
    private EmailService emailService;

    public BankResponse sendOtp(OtpRequest request){
        String otp = AccountUtils.generateToken();
        otpRepository.save(Otp.builder()
                        .email(request.getEmail())
                        .otp(otp)
                        .expiredAt(LocalDateTime.now().plusMinutes(1))
                .build());
        emailService.sendEmailAlert(EmailDetails.builder()
                        .recipient(request.getEmail())
                        .subject("Do not Disclose")
                        .messageBody("This organization has sent you an otp, This otp expires in 2minutes" + otp)
                .build());
        return BankResponse.builder()
                .responseCode("200")
                .responseMessage("Successfully sent")
                .build();
    }

    public BankResponse validateOtp(OtpValidationRequest request){
        // check if the otp exist in the Database
        Otp existOtp = otpRepository.findByEmail(request.getEmail());
        if (existOtp != null){
            otpRepository.delete(existOtp);
        }

        // check if the otp is not null
        Otp otp = otpRepository.findByEmail(request.getEmail());
        if (otp == null){
            return BankResponse.builder()
                    .responseCode("400")
                    .responseMessage("You have not sent am OTP")
                    .build();
        }

        // check if the otp exist in the OTP
        if (otp.getExpiredAt().isBefore(LocalDateTime.now())){
            return BankResponse.builder()
                    .responseCode("400")
                    .responseMessage("Your OTP has expired....")
                    .build();
        }

        // check if the otp is equals
        if (!otp.getOtp().equals(request.getOtp())){
            return BankResponse.builder()
                    .responseCode("400")
                    .responseMessage("You have sent an Invalid Otp")
                    .build();
        }

        return BankResponse.builder()
                .responseCode("200")
                .responseMessage("Success")
                .otpResponse(OtpResponse.builder()
                        .isOtpValid(true)
                        .build())
                .build();

    }
}
