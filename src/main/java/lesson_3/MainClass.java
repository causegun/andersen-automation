package lesson_3;

public class MainClass {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Kendrick Lamar", "Singer", "kendricklamar@mail.com", "891111111", 1000, 35);
        employees[1] = new Employee("Brad Pitt", "Actor", "bradpitt@mail.com", "891111112", 2000, 60);
        employees[2] = new Employee("Robert Lewandowski", "Footballer", "lewa@mail.com", "891111113", 3000, 33);
        employees[3] = new Employee("Steve Hawking", "Physicist", "hawking@mail.com", "891111114", 4000, 76);
        employees[4] = new Employee("Pablo Picasso", "Painter", "pablo@mail.com", "891111115", 5000, 91);

        for (Employee employee : employees) {
            if (employee.getAge() >= 40) {
                System.out.println(employee);
            }
        }
    }
}
