package kg.easy.megasubsorderservice.services;

import kg.easy.megasubsorderservice.models.dto.SubscriberDto;

public interface SubscriberService {

    SubscriberDto findSubsByMsisdn(String msisdn);
    SubscriberDto saveSubscriber(SubscriberDto subscriberDto);
}
