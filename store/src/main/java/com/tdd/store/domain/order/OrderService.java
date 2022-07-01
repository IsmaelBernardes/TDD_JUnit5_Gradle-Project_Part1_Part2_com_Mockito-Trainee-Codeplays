package com.tdd.store.domain.order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tdd.store.domain.payment.PaymentService;
import com.tdd.store.domain.user.UserService;

@Service
public class OrderService {
  
  private UserService userService;
  private PaymentService paymentService;
  private Boolean flag;
  
  public OrderService(UserService userService, PaymentService paymentService, @Value("${flag}") Boolean flag) {
    this.userService = userService;
    this.paymentService = paymentService;
    this.flag = flag;
  }

  public void create(Order order) {

    boolean isUserMinor = userService.isUserMinor(order.getUserId());

    if (flag || isUserMinor) {
      throw new IllegalStateException("O usuário não pode ser menor de idade");
    }

    paymentService.pay();
  }
}
