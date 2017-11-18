package net.naspryn.checkoutservice.api;

import java.util.Set;

public interface ProductsService {

    /**
     * Method returns product entity for given id
     * @param id Product id
     * @return Product entity with id, name, regular price and special price
     */
    Product getProductById(Long id);

    /**
     * Method returns products entities by a set of ids
     * @param ids Set of products ids
     * @return Set of products entities with id, name, regular price and special price
     */
    Set<Product> getProductsByIds(Set<Long> ids);
}
