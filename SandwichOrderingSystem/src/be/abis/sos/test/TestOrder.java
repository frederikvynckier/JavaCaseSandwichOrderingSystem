package be.abis.sos.test;

import be.abis.sos.model.Order;
import be.abis.sos.model.Session;
import be.abis.sos.model.Student;
import be.abis.sos.repository.OrderRepository;

import java.time.LocalDate;

public class TestOrder {
    public static void main(String[] args) {
        Student student1 = new Student("Purnima","Kashyap");
        Student student2 = new Student("Kashyap","Purnima");

        Session session = new Session(
                "Java Training",
                LocalDate.of(2026,11,10),
                LocalDate.of(2026,11,14)
        );

        OrderRepository repository = new OrderRepository();

        Order order1 = new Order(1,
                student1,
                session,
                LocalDate.of(2026,11,10),
                "No Remarks"
                );

        Order order2 = new Order(2,
                student2,
                session,
                LocalDate.of(2026,11,14),
                "No Remarks"
        );

        repository.add(order1);
        repository.add(order2);

        System.out.println("Orders added");

        for (Order order : repository.getOrders()) {
            System.out.println(order);
        }

        // get orders for 10 nov
        System.out.println("Order for 10 nov");
        for (Order order : repository.getListForDate(LocalDate.of(2026,11,10))) {

            System.out.println(order);
        }

        // Test the remove part
        repository.remove(2);
        System.out.println("After remove");

        for (Order order : repository.getOrders()) {
            System.out.println(order);
        }




    }

}
