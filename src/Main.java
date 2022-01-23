import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Market market = new Market();

        Seller firstSeller = createFirstSeller();
        Seller secondSeller = createSecondSeller();

        market.addSellers(firstSeller);
        market.addSellers(secondSeller);

        Customer firstCustomer = createFirstCustomer();
        firstCustomer.findProductMarket(market);
        firstCustomer.info();

        Customer secondCustomer = createSecondCustomer();
        secondCustomer.findSellerMarket(market);
        secondCustomer.info();
    }

    private static Customer createFirstCustomer(){
        Product firstProduct = new Product();
        firstProduct.setName(MarketConstants.TOMATOES_PRODUCT_NAME);
        firstProduct.setCount(4);

        Product secondProduct = new Product();
        secondProduct.setName(MarketConstants.CUCUMBER_PRODUCT_NAME);
        secondProduct.setCount(2);

        Seller expectedSeller = new Seller();

        return new Customer(List.of(firstProduct, secondProduct),List.of(expectedSeller),50);
    }

    private static Customer createSecondCustomer(){
        Product firstProduct = new Product();
        firstProduct.setName(MarketConstants.TOMATOES_PRODUCT_NAME);
        firstProduct.setCount(3);

        Product secondProduct = new Product();
        secondProduct.setName(MarketConstants.CUCUMBER_PRODUCT_NAME);
        secondProduct.setCount(3);

        Seller expectedSeller = new Seller();
        expectedSeller.setName("Алексей");
        expectedSeller.setLastName("Ушаков");

        return new Customer(List.of(firstProduct, secondProduct),List.of(expectedSeller),100);
    }

    private static Seller createFirstSeller(){
        Seller seller = new Seller();
        seller.setName("Виталий");
        seller.setLastName("Еремин");
        seller.setCash(0);

        Product firstProduct = new Product();
        firstProduct.setName(MarketConstants.TOMATOES_PRODUCT_NAME);
        firstProduct.setPrice(10);
        firstProduct.setCount(20);

        Product secondProduct = new Product();
        secondProduct.setName(MarketConstants.CUCUMBER_PRODUCT_NAME);
        secondProduct.setPrice(10);
        secondProduct.setCount(100);

        List<Product> products = new ArrayList<>();
        products.add(firstProduct);
        products.add(secondProduct);
        seller.setProducts(products);

        return seller;
    }

    private static Seller createSecondSeller(){
        Seller seller = new Seller();
        seller.setName("Алексей");
        seller.setLastName("Ушаков");
        seller.setCash(0);

        Product firstProduct = new Product();
        firstProduct.setName(MarketConstants.TOMATOES_PRODUCT_NAME);
        firstProduct.setPrice(8);
        firstProduct.setCount(40);

        Product secondProduct = new Product();
        secondProduct.setName(MarketConstants.CUCUMBER_PRODUCT_NAME);
        secondProduct.setPrice(5);
        secondProduct.setCount(10);

        List<Product> products = new ArrayList<>();
        products.add(firstProduct);
        products.add(secondProduct);
        seller.setProducts(products);

        return seller;
    }

}
