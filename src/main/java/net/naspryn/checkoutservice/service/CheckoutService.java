package net.naspryn.checkoutservice.service;

import net.naspryn.checkoutservice.api.Checkout;
import net.naspryn.checkoutservice.api.Product;
import net.naspryn.checkoutservice.api.ProductsService;
import net.naspryn.checkoutservice.api.SpecialPriceUSD;
import net.naspryn.checkoutservice.exceptions.NoSuchProductAvailable;
import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class CheckoutService implements Checkout {

    private ProductsService productsServiceClient;

    @Autowired
    public CheckoutService(ProductsService productsServiceClient) {
        this.productsServiceClient = productsServiceClient;
    }

    @Override
    public Money checkout(Map<Long, Integer> productsBasket) {
        Set<Long> productsIds = productsBasket.keySet();
        Set<Product> products = productsServiceClient.getProductsByIds(productsIds);

        if (products.size() != productsIds.size()) {
            throw new NoSuchProductAvailable();
        }

        return products.stream()
                .map(p -> calculatePriceForProductStack(p, productsBasket.get(p.getId())))
                .reduce(Money.of(0, "USD"), (a, b) -> a.add(b));
    }

    private Money calculatePriceForProductStack(Product product, Integer count) {
        Money regularPrice = product.getRegularPriceUSD();
        Optional<SpecialPriceUSD> specialPriceUSD = product.getSpecialPriceUSD();
        SpecialPriceUSD specialPrice = specialPriceUSD.orElseGet(() -> new SpecialPriceUSD(0, 0));
        int specialCount = specialPrice.getCount();

        Money price = Money.of(0, "USD");

        while (count > 0) {
            if (count >= specialCount && specialCount > 0) {
                count -= specialCount;
                price = price.add(specialPrice.getPrice());
                continue;
            }
            price = price.add(regularPrice.multiply(count));
            break;
        }
        return price;
    }
}
