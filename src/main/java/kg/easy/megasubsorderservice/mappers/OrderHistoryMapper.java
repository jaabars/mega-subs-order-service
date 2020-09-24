package kg.easy.megasubsorderservice.mappers;

import kg.easy.megasubsorderservice.models.OrderHistory;
import kg.easy.megasubsorderservice.models.dto.OrderHistoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderHistoryMapper {

    OrderHistoryMapper INSTANCE = Mappers.getMapper(OrderHistoryMapper.class);

    OrderHistory toOrderHistory(OrderHistoryDto orderHistoryDto);
    OrderHistoryDto toOrderHistoryDto(OrderHistory orderHistory);
}
