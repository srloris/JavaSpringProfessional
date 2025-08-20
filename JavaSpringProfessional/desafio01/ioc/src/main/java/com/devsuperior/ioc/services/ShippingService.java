package com.devsuperior.ioc.services;

import com.devsuperior.ioc.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public Double shipment(Order order) {
        Double basic = order.getBasic();

        if(basic < 100) {
            return 20.0;
        } else if (basic <= 200) {
            return 12.0;
        } else {
            return 0.0;
        }
    }
}
