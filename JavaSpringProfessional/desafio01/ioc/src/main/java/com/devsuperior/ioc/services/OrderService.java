package com.devsuperior.ioc.services;

import com.devsuperior.ioc.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public Double total(Order order) {
        return order.getBasic() -
                ((order.getBasic() * (order.getDiscount()) / 100) - shippingService.shipment(order));
    }
}
