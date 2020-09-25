package kg.easy.megasubsorderservice.services;

import kg.easy.megasubsorderservice.models.appDto.OrderAppDto;
import kg.easy.megasubsorderservice.models.enums.OrderStatus;
import kg.easy.megasubsorderservice.models.responses.Response;

public interface OrderService {
    Response saveOrder(OrderAppDto orderAppDto);

    Response getOrdersByStatus(OrderStatus orderStatus);
}
