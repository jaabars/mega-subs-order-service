package kg.easy.megasubsorderservice.dao;

import kg.easy.megasubsorderservice.models.Order;
import kg.easy.megasubsorderservice.models.OrderHistory;
import kg.easy.megasubsorderservice.models.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderHistoryRep extends JpaRepository<OrderHistory,Long> {

    boolean existsByOrderAndEndDateIsNull(Order order);
    OrderHistory findByOrderAndEndDateIsNull(Order order);
    List<OrderHistory> findAllByOrderStatusAndEndDateIsNull(OrderStatus orderStatus);
}
