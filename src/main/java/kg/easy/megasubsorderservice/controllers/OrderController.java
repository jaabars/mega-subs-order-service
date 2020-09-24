package kg.easy.megasubsorderservice.controllers;

import kg.easy.megasubsorderservice.models.appDto.OrderAppDto;
import kg.easy.megasubsorderservice.models.responses.Response;
import kg.easy.megasubsorderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public Response saveOrder(@RequestBody OrderAppDto orderAppDto){

        return orderService.saveOrder(orderAppDto);
    }
}
