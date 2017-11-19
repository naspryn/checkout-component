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
                new Product(12L, "D", 25),
                new Product(4L, "E", 100, new SpecialPriceUSD(2, 170)),
                new Product(23L, "F", 11.99, new SpecialPriceUSD(5, 50)),
                new Product(18L, "G", 80, new SpecialPriceUSD(3, 199.99)));
    }
}
