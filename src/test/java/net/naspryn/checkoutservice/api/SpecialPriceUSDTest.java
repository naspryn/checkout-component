package net.naspryn.checkoutservice.api;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpecialPriceUSDTest {

    @Test
    public void specialPriceToStringTest() {
        SpecialPriceUSD specialPriceUSD = new SpecialPriceUSD(3, 74.99);
        assertThat(specialPriceUSD.toString()).isEqualTo("SpecialPriceUSD{count=3, price=USD 74.99}");
    }
}