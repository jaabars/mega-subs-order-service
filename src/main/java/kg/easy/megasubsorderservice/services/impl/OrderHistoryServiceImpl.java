package kg.easy.megasubsorderservice.services.impl;

import kg.easy.megasubsorderservice.dao.OrderHistoryRep;
import kg.easy.megasubsorderservice.mappers.OrderHistoryMapper;
import kg.easy.megasubsorderservice.mappers.OrderMapper;
import kg.easy.megasubsorderservice.models.Order;
import kg.easy.megasubsorderservice.models.OrderHistory;
import kg.easy.megasubsorderservice.models.dto.OrderDto;
import kg.easy.megasubsorderservice.models.enums.OrderStatus;
import kg.easy.megasubsorderservice.services.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    @Autowired
    private OrderHistoryRep orderHistoryRep;

    @Override
    public OrderDto appendHistory(OrderDto orderDto, OrderStatus newStatus) {

        if(orderHistoryRep.existsByOrderAndEndDateIsNull(OrderMapper.INSTANCE.toOrder(orderDto))){
            OrderHistory currOrderHistory = orderHistoryRep.findByOrderAndEndDateIsNull(OrderMapper.INSTANCE.toOrder(orderDto));
            currOrderHistory.setEndDate(new Date());
            orderHistoryRep.save(currOrderHistory);
        }
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setStartDate(new Date());
        orderHistory.setOrder(OrderMapper.INSTANCE.toOrder(orderDto));
        orderHistory.setOrderStatus(newStatus);
        orderHistory = orderHistoryRep.save(orderHistory);
        orderDto.setOrderHistory(OrderHistoryMapper.INSTANCE.toOrderHistoryDto(orderHistory));
        return orderDto;
    }

    @Override
    public void closeHistory(Order currOrder) {
        OrderHistory orderHistory = orderHistoryRep.findByOrderAndEndDateIsNull(currOrder);
        orderHistory.setEndDate(new Date());
        orderHistoryRep.save(orderHistory);
    }

    @Override
    public List<OrderHistory> findOrderHistoriesByStatus(OrderStatus orderStatus) {
        return orderHistoryRep.findAllByOrderStatusAndEndDateIsNull(orderStatus);
    }
}
