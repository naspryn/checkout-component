package net.naspryn.checkoutservice.service;

import net.naspryn.checkoutservice.api.Checkout;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class CheckoutService implements Checkout {

    @Override
    public Money checkout(Map<Long, Integer> productsBasket) {


        Set<Long> productsIds = productsBasket.keySet();


        return Money.of(99.95, "USD");
    }
}
