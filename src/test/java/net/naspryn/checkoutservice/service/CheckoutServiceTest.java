package net.naspryn.checkoutservice.service;

import net.naspryn.checkoutservice.exceptions.NoSuchProductAvailable;
import net.naspryn.checkoutservice.util.TestUtil;
import org.javamoney.moneta.Money;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

import static net.naspryn.checkoutservice.util.TestUtil.getSampleProductsBasketWithNonExistingProduct;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CheckoutServiceTest {

    private static CheckoutService checkoutService;

    @BeforeClass
    public static void setupCheckoutService() {
        checkoutService = new CheckoutService(new ProductsServiceClient());
    }

    @Test(dataProvider = "ProductBasket", dataProviderClass = TestUtil.class)
    public void checkoutShouldReturnExpectedTotalPrice(Map<Long, Integer> products, Money expected) throws Exception {
        assertThat(checkoutService.checkout(products))
                .as("Checkout service should return expected total price")
                .isEqualTo(expected);
    }

    @Test
    public void checkoutShouldThrowNoSuchProductAvailableException() {
        assertThatThrownBy(() -> checkoutService.checkout(getSampleProductsBasketWithNonExistingProduct()))
                .as("Checkout service should throw NoSuchProductAvailable exception if product not exists")
                .isInstanceOf(NoSuchProductAvailable.class);
    }
}