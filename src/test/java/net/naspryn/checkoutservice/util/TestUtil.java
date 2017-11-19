package net.naspryn.checkoutservice.util;

import com.google.common.collect.ImmutableMap;
import org.javamoney.moneta.Money;
import org.testng.annotations.DataProvider;

public class TestUtil {

    @DataProvider(name = "ProductBasket")
    public static Object[][] getSampleProductsBasket() {
        return new Object[][]{
                {
                        ImmutableMap.<Long, Integer>builder().put(1L, 5).put(8L, 4).put(12L, 3).put(10L, 2).build(),
                        Money.of(315, "USD")
                },
                {
                        ImmutableMap.<Long, Integer>builder().put(1L, 1).put(23L, 16).put(10L, 14).build(),
                        Money.of(621.99, "USD")
                },
                {
                        ImmutableMap.<Long, Integer>builder().put(18L, 3).put(23L, 2).build(),
                        Money.of(223.97, "USD")
                },
                {
                        ImmutableMap.<Long, Integer>builder().put(4L, 3).put(18L, 2).put(10L, 1).put(8L, 2).build(),
                        Money.of(475, "USD")
                },
                {
                        ImmutableMap.<Long, Integer>builder().put(23L, 5).build(),
                        Money.of(50, "USD")
                }
        };
    }

    public static ImmutableMap<Long, Integer> getSampleProductsBasketWithNonExistingProduct() {
        return ImmutableMap.<Long, Integer>builder()
                .put(8L, 5)
                .put(999999L, 4)
                .build();
    }
}
