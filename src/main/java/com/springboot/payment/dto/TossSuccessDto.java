package com.springboot.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TossSuccessDto {
    private String paymentKey;
    private String orderId;
    private Long amount;
}
