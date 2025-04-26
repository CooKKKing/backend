package com.springboot.payment;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "payment")
public class PaymentProperties {
    private String secretKey;
    private String baseUrl;
    private String confirmEndpoint;
}