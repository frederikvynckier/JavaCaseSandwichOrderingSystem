package be.abis.sos.service;

import be.abis.sos.enumeration.Language;
import be.abis.sos.model.Sandwich;
import be.abis.sos.repository.SandwichRepository;

import java.util.Collections;
import java.util.List;

public class SandwichService {

    SandwichRepository sr = new SandwichRepository();

    public List<Sandwich> sortAllSandwichesByTypeAndPrice() {
        List<Sandwich> sandwiches = ((SandwichRepository) sr).getSandwiches();
        Collections.sort(sandwiches, new Sandwich.SandwichPricePerTypeComparator());
        return sandwiches;
    }

    public void printAllSandwichesByTypeAndPrice(Language language) {
        List<Sandwich> sandwiches = sortAllSandwichesByTypeAndPrice();
        sandwiches.forEach(s -> System.out.println(s.toString(language)));
    }

}
