package kg.easy.megasubsorderservice.dao;

import kg.easy.megasubsorderservice.models.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHistoryRep extends JpaRepository<OrderHistory,Long> {
}
