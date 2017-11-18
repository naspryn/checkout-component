package net.naspryn.checkoutservice.service;


import com.google.common.collect.ImmutableMap;
import org.javamoney.moneta.Money;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CheckoutServiceTest {

    private static CheckoutService checkoutService;

    @BeforeClass
    public static void setupCheckoutService() {
        checkoutService = new CheckoutService(new ProductsServiceClient());
    }

    @Test
    public void checkoutShouldReturnExpectedTotalPrice() throws Exception {
        assertThat(checkoutService.checkout(getSampleProductsBasket()))
                .as("Checkout service should return expected total price")
                .isEqualTo(Money.of(320, "USD"));
    }

    private ImmutableMap<Long, Integer> getSampleProductsBasket() {
        return ImmutableMap.<Long, Integer>builder()
                .put(1L, 5)
                .put(8L, 4)
                .put(12L, 3)
                .put(10L, 2)
                .build();
    }
}