package kg.easy.megasubsorderservice.models.dto;

import kg.easy.megasubsorderservice.models.enums.OrderStatus;
import lombok.Data;

import java.util.Date;

@Data
public class OrderHistoryDto {

    private Long id;

    private Date startDate;
    private Date endDate;

    private OrderStatus orderStatus;
}
