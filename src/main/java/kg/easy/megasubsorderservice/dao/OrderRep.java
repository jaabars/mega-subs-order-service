package kg.easy.megasubsorderservice.dao;

import kg.easy.megasubsorderservice.models.Order;
import kg.easy.megasubsorderservice.models.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRep extends JpaRepository<Order,Long> {

    Order findTopBySubscriberOrderByIdDesc(Subscriber subscriber);
}
