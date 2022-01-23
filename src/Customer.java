import java.util.ArrayList;
import java.util.List;

public class Customer extends Person{
    List<Product> expectedPurchaseList;
    List<Product> purchaseList;
    List<Seller> expectedSellerList;

    public Customer (List<Product> expectedPurchaseList, List<Seller> expectedSellerList, int cash){
        this.purchaseList = new ArrayList<>();
        this.expectedPurchaseList = expectedPurchaseList;
        this.expectedSellerList = expectedSellerList;
        this.setCash(cash);
    }

    public void addProduct(Product product){
        if (purchaseList == null){
            purchaseList = new ArrayList<>();
        }
        purchaseList.add(product);
    }

    public void findProductMarket(Market market){
        for(Product product: getExpectedPurchaseList()){
            for(Seller seller: market.getSellers()){
                boolean isBought = seller.sellProducts(this,product);
                if(isBought){
                    break;
                }
            }
        }
    }

    public void findSellerMarket(Market market){
        for (Seller expectedSeller: getExpectedSellerList()){
            for (Seller seller: market.getSellers()){
                if(expectedSeller.getName().equals(seller.getName()) && expectedSeller.getLastName().equals(seller.getLastName())){
                    for(Product product: getExpectedPurchaseList()) {
                        boolean isBought = seller.sellProducts(this, product);
                        if (isBought) {
                            continue;
                        }
                    }
                }
            }
        }

    }

    public void info(){
        StringBuilder result = new StringBuilder("Я купил ");
        if(purchaseList.size() == 0){
            result.append("ничего");
        } else {
            for(Product product: purchaseList){
                result.append(product.getName());
                result.append(" в количестве ");
                result.append(product.getCount());
                result.append(" ");
            }
        }
        result.append(". У меня осталось: ");
        result.append(getCash());
        result.append(" рублей.");

        System.out.println(result);
    }

    public List<Product> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Product> purchaseList) {
        this.purchaseList = purchaseList;
    }

    public List<Product> getExpectedPurchaseList() {
        return expectedPurchaseList;
    }

    public List<Seller> getExpectedSellerList() {
        return expectedSellerList;
    }

}
