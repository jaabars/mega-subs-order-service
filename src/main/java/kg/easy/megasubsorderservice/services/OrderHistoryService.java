package kg.easy.megasubsorderservice.services;

import kg.easy.megasubsorderservice.models.Order;
import kg.easy.megasubsorderservice.models.OrderHistory;
import kg.easy.megasubsorderservice.models.dto.OrderDto;
import kg.easy.megasubsorderservice.models.enums.OrderStatus;

import java.util.List;

public interface OrderHistoryService {

    OrderDto appendHistory(OrderDto orderDto, OrderStatus newStatus);

    void closeHistory(Order currOrder);
    List<OrderHistory> findOrderHistoriesByStatus(OrderStatus orderStatus);
}
