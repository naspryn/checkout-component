package net.naspryn.checkoutservice.stub;

import com.google.common.collect.ImmutableSet;
import net.naspryn.checkoutservice.api.Product;
import net.naspryn.checkoutservice.api.SpecialPriceUSD;

import java.util.Set;

public class ProductServiceStub {

    public static Set<Product> getSampleProducts() {
        return ImmutableSet.of(
                new Product(1L, "A", 40, new SpecialPriceUSD(3, 70)),
                new Product(8L, "B", 10, new SpecialPriceUSD(2, 15)),
                new Product(10L, "C", 30),
                new Product(12L, "D", 25));
    }
}
