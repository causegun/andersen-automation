package lesson4;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Rex");
        dog.run(100);
        dog.run(500);
        dog.run(501);
        dog.swim(9);
        dog.swim(12);
        Cat cat = new Cat("Murzik");
        cat.run(100);
        cat.run(200);
        cat.run(201);
        cat.swim(5);
        System.out.println("Количество созданных животных: " + Animal.animalCount);

        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Oliver", 10);
        cats[1] = new Cat("Leo", 20);
        cats[2] = new Cat("Loki", 30);
        cats[3] = new Cat("Bella", 40);
        cats[4] = new Cat("Charlie", 50);
        Plate plate = new Plate(99);
        for (Cat eatingCat : cats) {
            plate.info();
            System.out.println("Cat before eating: " + eatingCat);
            eatingCat.eat(plate);
            plate.info();
            System.out.println("Cat after eating: " + eatingCat + "\n");
        }
        plate.increaseFood(1);
        plate.info();

        Payment payment = new Payment();
        Payment.Product[] products = new Payment.Product[5];
        products[0] = payment.new Product("Whiskas", 15);
        products[1] = payment.new Product("Kitekat", 25);
        products[2] = payment.new Product("Felix", 35);
        products[3] = payment.new Product("Royal Canin", 45);
        products[4] = payment.new Product("Pro Plan", 55);
        payment.setProducts(products);
        System.out.println("payment total cost: " + payment.getTotalCost());

        Park park = new Park();
        Park.Attraction[] attractions = new Park.Attraction[3];
        attractions[0] = park.new Attraction("attraction 1", 4, 10);
        attractions[1] = park.new Attraction("attraction 2", 8, 20);
        attractions[2] = park.new Attraction("attraction 3", 12, 40);
        park.setAttractions(attractions);
        System.out.println(park);
    }
}
