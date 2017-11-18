package net.naspryn.checkoutservice.api;

import org.javamoney.moneta.Money;

public class SpecialPriceUSD {

    private final int count;
    private final Money price;

    public SpecialPriceUSD(int count, double price) {
        this.count = count;
        this.price = Money.of(price, "USD");
    }

    public int getCount() {
        return count;
    }

    public Money getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "SpecialPriceUSD{" +
                "count=" + count +
                ", price=" + price +
                '}';
    }
}
