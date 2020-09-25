package kg.easy.megasubsorderservice.mappers;

import kg.easy.megasubsorderservice.models.Order;
import kg.easy.megasubsorderservice.models.OrderHistory;
import kg.easy.megasubsorderservice.models.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toOrder(OrderDto orderDto);
    OrderDto toOrderDto(Order order);

    default List<OrderDto> toOrderDtoListFromOrderHistories(List<OrderHistory> orderHistories){
        List<OrderDto> orderDtoList = orderHistories.stream()
                .map(x->{
                    OrderDto orderDto = toOrderDto(x.getOrder());
                    orderDto.setOrderHistory(OrderHistoryMapper.INSTANCE.toOrderHistoryDto(x));
                    return orderDto;
                        }
                ).collect(Collectors.toList());
        return orderDtoList;
    }
}
