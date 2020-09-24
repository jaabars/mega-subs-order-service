package kg.easy.megasubsorderservice.mappers;

import kg.easy.megasubsorderservice.models.Subscriber;
import kg.easy.megasubsorderservice.models.dto.SubscriberDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubscriberMapper {

    SubscriberMapper INSTANCE = Mappers.getMapper(SubscriberMapper.class);

    Subscriber toSubscriber(SubscriberDto subscriberDto);
    SubscriberDto toSubscriberDto(Subscriber subscriber);
}
