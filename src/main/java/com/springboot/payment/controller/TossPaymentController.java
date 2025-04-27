package com.springboot.payment.controller;

import com.springboot.member.entity.Member;
import com.springboot.payment.dto.PaymentRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments/toss")
public class TossPaymentController {

//    @PostMapping("/request")
//    public ResponseEntity<?> requestTossPayment(@RequestBody PaymentRequestDto requestDto) {
//        // 결제 요청 처리 (DB에 order 저장, orderId 생성)
//    }
//
//    @PostMapping("/success")
//    public ResponseEntity<?> tossPaymentSuccess(@RequestBody TossSuccessDto successDto) {
//        // 결제 성공 처리 (토스 confirm, DB 상태 변경)
//    }
//
//    @PostMapping("/fail")
//    public ResponseEntity<?> tossPaymentFail(@RequestBody TossFailDto failDto) {
//        // 결제 실패 처리
//    }
//
//    @PostMapping("/cancel")
//    public ResponseEntity<?> tossPaymentCancel(@RequestBody TossCancelDto cancelDto) {
//        // 결제 취소 처리 (토스 취소 API 호출)
//    }
//
//    @GetMapping("/history")
//    public ResponseEntity<?> getChargingHistory(@AuthenticationPrincipal Member member) {
//        // 결제 내역 조회
//    }
}
