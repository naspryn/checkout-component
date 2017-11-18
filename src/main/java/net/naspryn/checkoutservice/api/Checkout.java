package net.naspryn.checkoutservice.api;

import org.javamoney.moneta.Money;

import java.util.Map;

public interface Checkout {

    Money checkout(Map<Long, Integer> products);
}
