package com.Spring.CarRental.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @PostMapping("/upi/{amount}")
    public String payUsingUpi(@PathVariable double amount){

        return "The Amount of "+ amount+" has been paid Successfully using upi";
    }

    @PostMapping("/credit/{amount}")
    public String payUsingCredit(@PathVariable double amount){

        return "The Amount of "+ amount+" has been paid Successfully using credit";
    }

    @PostMapping("/debit/{amount}")
    public String payUsingDebit(@PathVariable double amount){

        return "The Amount of "+ amount+" has been paid Successfully using upi debit";
    }


}
