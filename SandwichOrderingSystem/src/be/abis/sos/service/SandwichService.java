package be.abis.sos.service;

import be.abis.sos.model.Sandwich;
import be.abis.sos.repository.SandwichRepository;

import java.util.Collections;
import java.util.List;

public class SandwichService {

    SandwichRepository sr;

    public List<Sandwich> sortAllCompaniesByCompanyNumber() {
        List<Sandwich> sandwiches = ((SandwichRepository) sr).getSandwiches();
        Collections.sort(sandwiches, new Sandwich.SandwichPricePerTypeComparator());
        return sandwiches;
    }

}
