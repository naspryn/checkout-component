package net.naspryn.checkoutservice.api;

import java.util.Set;

public interface ProductsService {

    Product getProductById(Long id);

    Set<Product> getProductsByIds(Set<Long> ids);
}
