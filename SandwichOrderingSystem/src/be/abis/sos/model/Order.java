package be.abis.sos.model;

import java.time.LocalDate;

public class Order {
    private int id;
    private Person person;
    private Session session;
    private LocalDate date;
    private SandwichOrder[] sandwichOrders;
    private String remarks;

    public Order(int id,
                 Person person,
                 Session session,
                 LocalDate date,
                 String remarks) {
        this.id = id;
        this.person = person;
        this.session = session;
        this.date = date;
        this.remarks = remarks;
        this.sandwichOrders = new SandwichOrder[2];
    }

    public void addSandwich(SandwichOrder sandwichOrder) {
        for (int i = 0; i < sandwichOrders.length; i++) {
            if (sandwichOrders[i] == null) {
                sandwichOrders[i] = sandwichOrder;
                return;
            }
        }

        System.out.println("Maximum 2 sandwich orders allowed");
    }

    public void removeSandwich(int index) {
        if (index >= 0 && index < sandwichOrders.length) {
           sandwichOrders[index] = null;
        }
    }

    public void updateSandwich(int index, SandwichOrder sandwichOrder) {
        if (index >= 0 && index < sandwichOrders.length) {
            sandwichOrders[index] = sandwichOrder;
        }
    }


        public SandwichOrder[] listSandwiches()
        {
            return sandwichOrders;
        }

        public int getId()
        {
            return id;
        }

        public Person getPerson()
        {
            return person;
        }

    public Session getSession() {
            return session;
    }
    public LocalDate getDate() {
        return date;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", person=" + person
 + ", session=" + session + ", date=" + date + ", remarks=" + remarks + '}';    }
}

