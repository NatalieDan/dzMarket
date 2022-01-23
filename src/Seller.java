import java.util.List;

public class Seller extends Person{
    private String name;
    private String lastName;
    private List<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean sellProducts(Customer customer, Product expectedProduct){
        for(Product product:products){
            if(product.getName().equals(expectedProduct.getName())){
                if(product.getCount() >= expectedProduct.getCount()){
                    long requiredCash = (long) product.getPrice()* expectedProduct.getCount();
                    if(customer.getCash() >= requiredCash){
                        product.setCount(product.getCount() - expectedProduct.getCount());

                        Product customerProduct = new Product();
                        customerProduct.setCount(expectedProduct.getCount());
                        customerProduct.setName(expectedProduct.getName());

                        customer.addProduct(customerProduct);

                        setCash(getCash() + requiredCash);

                        customer.setCash(customer.getCash() - requiredCash);

                        return true;
                    }
                }
            }
        }

        return false;
    }
}
