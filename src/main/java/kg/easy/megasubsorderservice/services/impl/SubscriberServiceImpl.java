package kg.easy.megasubsorderservice.services.impl;

import kg.easy.megasubsorderservice.dao.SubscriberRep;
import kg.easy.megasubsorderservice.mappers.SubscriberMapper;
import kg.easy.megasubsorderservice.models.Subscriber;
import kg.easy.megasubsorderservice.models.dto.SubscriberDto;
import kg.easy.megasubsorderservice.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private SubscriberRep subscriberRep;

    @Override
    public SubscriberDto findSubsByMsisdn(String msisdn) {
        Subscriber subscriber = subscriberRep.findByMsisdn(msisdn);
        return SubscriberMapper.INSTANCE.toSubscriberDto(subscriber);
    }

    @Override
    public SubscriberDto saveSubscriber(SubscriberDto subscriberDto) {
        Subscriber subscriber = subscriberRep.save(SubscriberMapper.INSTANCE.toSubscriber(subscriberDto));
        return SubscriberMapper.INSTANCE.toSubscriberDto(subscriber);
    }
}
