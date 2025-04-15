package com.springboot.helper.email;

import com.springboot.exception.BusinessLogicException;
import com.springboot.exception.EmailVerificationException;
import com.springboot.exception.ExceptionCode;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/auth/email")
public class EmailAuthController {
    private final RedisTemplate<String, String> redisTemplate;
    private final EmailSender emailSender;

    public EmailAuthController(RedisTemplate<String, String> redisTemplate, EmailSender emailSender) {
        this.redisTemplate = redisTemplate;
        this.emailSender = emailSender;
    }

    @PostMapping("/verify")
    public ResponseEntity sendVerificationCode(@RequestBody EmailDto.Request dto) throws InterruptedException {
        String code = generateCode(); // ex: 6자리
        redisTemplate.opsForValue().set(dto.getEmail(), code, 5, TimeUnit.MINUTES);
        emailSender.sendEmail(
                new String[]{dto.getEmail()},
                "쿡킹 🍳 회원가입을 위한 인증번호 안내드립니다",
                "인증번호는 " + code + " 입니다.",
                "email-verification"
        );
        return ResponseEntity.ok().build();
    }

    @PostMapping("/confirm")
    public ResponseEntity checkVerificationCode(@RequestBody EmailDto.Confirm dto) {
        String savedCode = redisTemplate.opsForValue().get(dto.getEmail());
        if (savedCode == null || !savedCode.equals(dto.getCode())) {
            throw new EmailVerificationException();
        }
        redisTemplate.delete(dto.getEmail()); // 인증 완료되면 제거
        redisTemplate.opsForValue().set(dto.getEmail() + ":verified", "true", 10, TimeUnit.MINUTES);
        return ResponseEntity.ok().build();
    }

    // 인증번호 6자리 숫자 생성
    private String generateCode() {
        Random random = new Random();
        int number = 100000 + random.nextInt(900000); // 100000 ~ 999999
        return String.valueOf(number);
    }
}
