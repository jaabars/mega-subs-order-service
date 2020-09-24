package kg.easy.megasubsorderservice.services.impl;

import kg.easy.megasubsorderservice.dao.OrderRep;
import kg.easy.megasubsorderservice.mappers.DistrictMapper;
import kg.easy.megasubsorderservice.mappers.OrderMapper;
import kg.easy.megasubsorderservice.mappers.RegionMapper;
import kg.easy.megasubsorderservice.mappers.SubscriberMapper;
import kg.easy.megasubsorderservice.models.Order;
import kg.easy.megasubsorderservice.models.appDto.OrderAppDto;
import kg.easy.megasubsorderservice.models.dto.DistrictDto;
import kg.easy.megasubsorderservice.models.dto.OrderDto;
import kg.easy.megasubsorderservice.models.dto.RegionDto;
import kg.easy.megasubsorderservice.models.dto.SubscriberDto;
import kg.easy.megasubsorderservice.models.enums.OrderStatus;
import kg.easy.megasubsorderservice.models.responses.Response;
import kg.easy.megasubsorderservice.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRep orderRep;

    @Autowired
    private SubscriberService subscriberService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private RegionService regionService;

    @Autowired
    private OrderHistoryService orderHistoryService;

    @Override
    public Response saveOrder(OrderAppDto orderAppDto) {

        Response response = Response.getResponse();

        SubscriberDto subscriberDto = subscriberService.findSubsByMsisdn(orderAppDto.getMsisdn());
        if (subscriberDto==null){
            subscriberDto = new SubscriberDto();
            subscriberDto.setMsisdn(orderAppDto.getMsisdn());
            subscriberDto = subscriberService.saveSubscriber(subscriberDto);

            Order order = new Order();
            order.setAddDate(new Date());

            DistrictDto districtDto = districtService.findById(orderAppDto.getDistrictId());
            order.setDistrict(DistrictMapper.INSTANCE.toDistrict(districtDto));

            RegionDto regionDto = regionService.findById(orderAppDto.getRegionId());
            order.setRegion(RegionMapper.INSTANCE.toRegion(regionDto));

            order.setSchool(orderAppDto.getSchool());

            order.setSubscriber(SubscriberMapper.INSTANCE.toSubscriber(subscriberDto));

            order = orderRep.save(order);

            OrderDto orderDto = orderHistoryService.appendHistory(OrderMapper.INSTANCE.toOrderDto(order), OrderStatus.NEW);
            response.setObject(orderDto);


        }

        return response;
    }
}
