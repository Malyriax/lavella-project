package com.lavella.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateOrderRequest {
    @NotEmpty
    @Valid
    private List<OrderItemRequest> items;

    @Getter
    @Setter
    public static class OrderItemRequest {
        @NotNull
        private Long dishId;

        @NotNull
        @Positive
        private Integer quantity;

        public OrderItemRequest() {}

    }

    public CreateOrderRequest() {}
}
