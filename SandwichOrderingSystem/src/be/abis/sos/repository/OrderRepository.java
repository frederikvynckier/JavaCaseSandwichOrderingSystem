package be.abis.sos.repository;

import be.abis.sos.model.Order;
import be.abis.sos.model.Session;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

   private List<Order> orders;

   public OrderRepository() {
       orders = new ArrayList<>();
   }

   public void add(Order order) {

       orders.add(order);
       writeToFile();
   }

   public void update(Order updatedOrder) {
       for (int i = 0; i < orders.size(); i++) {
           if (orders.get(i).getId() == updatedOrder.getId())
           {
               orders.set(i, updatedOrder);
               writeToFile();
               return;
           }
       }
   }

   public void remove(int id)
   {
       orders.removeIf(order -> order.getId() == id);
       writeToFile();
   }

    public List<Order> getListForDate(LocalDate date) {
        List<Order> result = new ArrayList<>();
        for (Order order : orders) {
            if(order.getDate().equals(date))
                result.add(order);
        }
        return result;
    }

    public void printListForDate(LocalDate date) {
       List<Order> ordersForDate = getListForDate(date);
       for (Order order : ordersForDate) {
           System.out.println(order);
       }
    }

    public List<Order> getListForSessions(Session session) {
       List<Order> result = new ArrayList<>();
       for (Order order : orders) {
           if(order.getSession().equals(session))
           {
               result.add(order);
           }
       }
       return result;
    }

    public List<Order> getOrders() {
        return orders;
    }

    private void writeToFile() {
       try (PrintWriter writer = new PrintWriter(new FileWriter("orders.txt")) )
       {
           for (Order order : orders) {
               writer.println(order);
           }
       }
       catch (IOException e)
       {
           System.out.println("Error writing to file");
           e.printStackTrace();
       }
    }
}
