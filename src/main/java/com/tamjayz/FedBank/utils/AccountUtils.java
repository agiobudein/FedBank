package com.tamjayz.FedBank.utils;

import java.time.Year;
import java.util.Random;

public class AccountUtils {

    public static final String ACCOUNT_EXIST_CODE = "001";

    public static final String ACCOUNT_EXIST_MESSAGE = "This user already has an account created!";
    public static final String ACCOUNT_CREATION_SUCCESS = "002";
    public static final String ACCOUNT_CREATION_MESSAGE = "Account has been created successfully!";

    public static final String ACCOUNT_NOT_EXIST_CODE= "003";
    public static final String ACCOUNT_NOT_EXIST_MESSAGE = "User with the Account Number does not exist";

    public static final String ACCOUNT_FOUND_CODE = "004";
    public static final String ACCOUNT_FOUND_MESSAGE = "User Account Found";

    public static final String ACCOUNT_CREDITED_SUCCESS_CODE = "005";
    public static final String ACCOUNT_CREDITED_SUCCESS_MESSAGE = "The User Account was credited successfully";

    public static final String INSUFFICIENT_BALANCE_CODE = "006";
    public static final String INSUFFICIENT_BALANCE_MESSAGE = "Insufficient Balance in your Account!";

    public static final String ACCOUNT_DEBITED_SUCCESS_CODE = "007";
    public static final String ACCOUNT_DEBITED_SUCCESS_MESSAGE = "Your Account was debited successfully.";

    public static final String TRANSFER_SUCCESS_CODE = "008";
    public static final String TRANSFER_SUCCESS_MESSAGE = "Transfer Successfully completed";

    public static String generateAccountNumber(){
        /*
         * Random number that start with
         * year 2023 + randomSixDigits
         *
         * */

        Year currentYear = Year.now();

        int min = 100000;
        int max = 999999;
        // Generate a random number between min and max

        int randNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);

        // convert year and randNumber to String
        String year = String.valueOf(currentYear);
        String randomNumber = String.valueOf(randNumber);

        StringBuilder accountNumber = new StringBuilder();
        return  accountNumber.append(year).append(randomNumber).toString();

    }

    // Method to generate random otp
    public static String generateToken(){
        StringBuilder otp = new StringBuilder();

        Random random = new Random();
        int count = 0;

        while (count < 4){
            otp.append(random.nextInt(10));
            ++count;
        }
        return otp.toString();
    }

}
