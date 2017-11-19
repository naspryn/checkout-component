package net.naspryn.checkoutservice.service;

import net.naspryn.checkoutservice.stub.ProductServiceStub;
import net.naspryn.checkoutservice.api.Product;
import net.naspryn.checkoutservice.api.ProductsService;
import net.naspryn.checkoutservice.api.SpecialPriceUSD;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductsServiceClient implements ProductsService {

    @Override
    public Product getProductById(Long id) {
        // Stub
        return new Product(10532L, "C", 75.99, new SpecialPriceUSD(3, 250));
    }

    @Override
    public Set<Product> getProductsByIds(Set<Long> ids) {
        // Use ProductServiceStub
        return ProductServiceStub.getSampleProducts().stream()
                .filter(p -> ids.contains(p.getId()))
                .collect(Collectors.toSet());
    }
}
