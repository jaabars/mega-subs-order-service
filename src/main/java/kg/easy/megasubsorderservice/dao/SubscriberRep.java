package kg.easy.megasubsorderservice.dao;

import kg.easy.megasubsorderservice.models.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRep extends JpaRepository<Subscriber,Long> {
    Subscriber findByMsisdn(String msisdn);
}
