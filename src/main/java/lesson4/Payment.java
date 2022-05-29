package lesson4;

public class Payment {
    private Product[] products;
    private int totalCost;

    public int getTotalCost() {
        for (Product product : this.products) {
            totalCost += product.getPrice();
        }
        return totalCost;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public class Product {
        private String name;
        private int price;

        public Product(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }
    }
}
