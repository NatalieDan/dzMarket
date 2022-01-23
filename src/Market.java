import java.util.ArrayList;
import java.util.List;

public class Market {
    private List<Seller> sellers;

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    public void addSellers(Seller seller){
        if (sellers == null){
            sellers = new ArrayList<>();
        }
        sellers.add(seller);
    }
}
