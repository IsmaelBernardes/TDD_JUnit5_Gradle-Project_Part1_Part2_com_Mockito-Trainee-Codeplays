package com.tdd.store.domain.order;

import com.tdd.store.domain.payment.PaymentService;
import com.tdd.store.domain.user.UserService;

public class OrderService {
  
  private UserService userService;
  private PaymentService paymentService;
  
  public OrderService(UserService userService, PaymentService paymentService) {
    this.userService = userService;
    this.paymentService = paymentService;
  }

  public void create(Order order) {

    boolean isUserMinor = userService.isUserMinor(order.getUserId());

    if (isUserMinor) {
      throw new IllegalStateException("O usuário não pode ser menor de idade");
    }

    paymentService.pay();
  }
}
