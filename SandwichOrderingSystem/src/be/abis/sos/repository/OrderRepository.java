package be.abis.sos.repository;

import be.abis.sos.model.Order;
import be.abis.sos.model.Session;

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
   }

   public void update(Order order) {
       for (int i = 0; i < orders.size(); i++) {
           if (orders.get(i).getId() == order.getId())
           {
               orders.set(i, order);
               return;
           }
       }
   }

   public void remove(Order order) {
       orders.remove(order);
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
}
