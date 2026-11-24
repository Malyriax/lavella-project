package com.lavella.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.lavella.entity.OrderStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OrderResponse {

    private Long id;

    private OrderStatus orderStatus;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    private List<OrderItemResponse> orderItems;

    @Getter
    @Setter
    public static class OrderItemResponse {

        private String dishName;
        private Integer quantity;
        private BigDecimal priceAtOrder;

        public OrderItemResponse() {
        }
    }

    public OrderResponse() {
    }
}
