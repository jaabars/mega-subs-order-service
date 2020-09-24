package kg.easy.megasubsorderservice.services;

import kg.easy.megasubsorderservice.models.dto.OrderDto;
import kg.easy.megasubsorderservice.models.enums.OrderStatus;

public interface OrderHistoryService {

    OrderDto appendHistory(OrderDto orderDto, OrderStatus newStatus);
}
