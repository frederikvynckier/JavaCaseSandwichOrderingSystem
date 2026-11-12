package be.abis.sos.service;

import be.abis.sos.enumeration.Language;
import be.abis.sos.model.Sandwich;
import be.abis.sos.repository.SandwichRepository;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class SandwichService {

    SandwichRepository sr = new SandwichRepository();

    public List<Sandwich> sortAllSandwichesByTypeAndPrice() {
        List<Sandwich> sandwiches = sr.getSandwiches();
        Collections.sort(sandwiches, new Sandwich.SandwichPricePerTypeComparator());
        return sandwiches;
    }

    public void printAllSandwichesByTypeAndPrice(Language language) {

        String baseName = "be.abis.sos.translations";
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, language.getLocale());

        String seperator = "*".repeat(103);
        System.out.println(bundle.getString("sandwich.list"));
        System.out.println(seperator);
        sortAllSandwichesByTypeAndPrice().forEach(s -> System.out.println(s.toString(language)));
        System.out.println(seperator);
    }

    public void saveSandwiches() {

        try {
            sr.writeSandwiches();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Sandwich findSandwichById(int id) {
        Sandwich sandwich = sr.findSandwichById(id);
        return sandwich;
    }

    public void removeSandwich(Sandwich sandwich) {
        sr.removeSandwich(sandwich);
    }

    public void addSandwich(Sandwich sandwich) {
        sr.addSandwich(sandwich);
    }


}
