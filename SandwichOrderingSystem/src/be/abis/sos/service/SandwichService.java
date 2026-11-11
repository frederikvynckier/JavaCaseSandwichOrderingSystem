package be.abis.sos.service;

import be.abis.sos.enumeration.Language;
import be.abis.sos.model.Sandwich;
import be.abis.sos.repository.SandwichRepository;

import java.util.Collections;
import java.util.List;

public class SandwichService {

    SandwichRepository sr = new SandwichRepository();

    public List<Sandwich> sortAllSandwichesByTypeAndPrice() {
        List<Sandwich> sandwiches = sr.getSandwiches();
        Collections.sort(sandwiches, new Sandwich.SandwichPricePerTypeComparator());
        return sandwiches;
    }

    public void printAllSandwichesByTypeAndPrice(Language language) {
        List<Sandwich> sandwiches = sortAllSandwichesByTypeAndPrice();
        int i = 0;
        for (Sandwich sandwich : sandwiches) {
            i++;
            System.out.println(i + ". " + sandwich.toString(language));
        }
    }

    public Sandwich findSandwichById(int id) {
        List<Sandwich> sandwiches = sortAllSandwichesByTypeAndPrice();
        Sandwich sandwich = sandwiches.get(id+1);
        return sandwich;
    }

    public void removeSandwich(Sandwich sandwich) {
        sr.removeSandwich(sandwich);
    }

    public void addSandwich(Sandwich sandwich) {
        sr.addSandwich(sandwich);
    }


}
