package net.naspryn.checkoutservice.service;

import com.google.common.collect.ImmutableSet;
import net.naspryn.checkoutservice.api.Product;
import net.naspryn.checkoutservice.api.ProductsService;
import net.naspryn.checkoutservice.api.SpecialPriceUSD;

import java.util.Set;


public class ProductsServiceClient implements ProductsService{

    @Override
    public Product getProductById(Long id) {
        return new Product(10532L, "C", 75.99, new SpecialPriceUSD(3, 250));
    }

    @Override
    public Set<Product> getProductsByIds(Set<Long> ids) {
        // Stub
        return ImmutableSet.of(
        new Product(1L, "A", 40, new SpecialPriceUSD(3, 70)),
        new Product(8L, "B", 10, new SpecialPriceUSD(2, 15)),
        new Product(10L, "C", 30),
        new Product(12L, "D", 25));
    }
}
