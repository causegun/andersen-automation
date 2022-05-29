package lesson4;

import java.util.Arrays;

public class Park {
    private Attraction[] attractions;

    public void setAttractions(Attraction[] attractions) {
        this.attractions = attractions;
    }

    @Override
    public String toString() {
        return "Park{" +
                "attractions=" + Arrays.toString(attractions) +
                '}';
    }

    public class Attraction {
        private String name;
        private int workingTime;
        private int price;

        public Attraction(String name, int workingTime, int price) {
            this.name = name;
            this.workingTime = workingTime;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Attraction{" +
                    "name='" + name + '\'' +
                    ", workingTime=" + workingTime +
                    ", price=" + price +
                    '}';
        }
    }
}