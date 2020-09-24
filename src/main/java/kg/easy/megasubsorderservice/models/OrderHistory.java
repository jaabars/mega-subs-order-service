package kg.easy.megasubsorderservice.models;

import kg.easy.megasubsorderservice.models.enums.OrderStatus;
import lombok.Data;
import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "order_histories")
public class OrderHistory {

    @Id
    @GeneratedValue
    private Long id;

    private Date startDate;
    private Date endDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
