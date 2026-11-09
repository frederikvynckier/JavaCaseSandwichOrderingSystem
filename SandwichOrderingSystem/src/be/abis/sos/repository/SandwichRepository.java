package be.abis.sos.repository;

import be.abis.sos.model.Sandwich;

import java.util.ArrayList;
import java.util.List;

public class SandwichRepository {

    private String filePath = "C:\\Users\\Duser\\IdeaProjects\\JavaProgramming\\files\\companies.txt";

    private List<Sandwich> sandwiches = new ArrayList<Sandwich>();

    public SandwichRepository() {
    }

    public List<Sandwich> getCompanies() {
        return sandwiches;
    }

    public void setCompanies(List<Sandwich> companies) {
        this.sandwiches = companies;
    }


}
