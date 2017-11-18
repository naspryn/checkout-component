package net.naspryn.checkoutservice.api;

import org.javamoney.moneta.Money;

import java.util.Map;

public interface Checkout {

    /**
     * Methods returns total price for given products
     * @param products Map contains products id - products count pairs
     * @return total price for products in USD
     */
    Money checkout(Map<Long, Integer> products);
}
