package kg.easy.megasubsorderservice.mappers;

import kg.easy.megasubsorderservice.models.Order;
import kg.easy.megasubsorderservice.models.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toOrder(OrderDto orderDto);
    OrderDto toOrderDto(Order order);
}
