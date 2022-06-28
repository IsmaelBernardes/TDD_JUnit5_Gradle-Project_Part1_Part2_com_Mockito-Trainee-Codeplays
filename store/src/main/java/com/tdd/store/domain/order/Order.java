package com.tdd.store.domain.order;

public class Order {

  private Long userId;

  public Order(Long userId) {
    this.userId = userId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

}
