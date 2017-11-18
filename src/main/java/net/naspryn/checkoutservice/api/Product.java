package net.naspryn.checkoutservice.api;

import org.javamoney.moneta.Money;

import java.util.Optional;

public class Product {

    private final Long id;

    private final String name;

    private final Money regularPriceUSD;

    private final SpecialPriceUSD specialPriceUSD;

    public Product(Long id, String name, double regularPriceUSD, SpecialPriceUSD specialPriceUSD) {
        this.id = id;
        this.name = name;
        this.regularPriceUSD = Money.of(regularPriceUSD, "USD");
        this.specialPriceUSD = specialPriceUSD;
    }

    public Product(Long id, String name, double regularPriceUSD) {
        this.id = id;
        this.name = name;
        this.regularPriceUSD = Money.of(regularPriceUSD, "USD");
        this.specialPriceUSD = null;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Money getRegularPriceUSD() {
        return regularPriceUSD;
    }

    public Optional<SpecialPriceUSD> getSpecialPriceUSD() {
        return Optional.ofNullable(specialPriceUSD);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", regularPriceUSD=" + regularPriceUSD +
                ", specialPriceUSD=" + specialPriceUSD +
                '}';
    }
}
