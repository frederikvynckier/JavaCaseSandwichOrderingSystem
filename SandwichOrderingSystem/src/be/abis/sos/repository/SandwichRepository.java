package be.abis.sos.repository;

import be.abis.sos.exception.SandwichParseException;
import be.abis.sos.model.Sandwich;
import be.abis.sos.utils.SandwichParser;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SandwichRepository {

    private Path getFilePath() {
        Path directory = Path.of("out", "sos");
        Path input = directory.resolve("sandwiches.txt");
        return input;
    }

    private List<Sandwich> sandwiches = new ArrayList<Sandwich>();

    public SandwichRepository() {
    }

    public List<Sandwich> getCompanies() {
        return sandwiches;
    }

    public void setSandwiches(List<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void removeSandwich(Sandwich sandwich) {
        sandwiches.remove(sandwich);
    }

    public void readSandwiches() throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(getFilePath().toFile()))) {
            String nextLine;
            Sandwich sandwich;
            while ((nextLine = in.readLine()) != null) {
                if (!nextLine.trim().isBlank()) {
                    System.out.println(nextLine);
                    try {
                        sandwich = SandwichParser.parse(nextLine);
                        sandwiches.add(sandwich);
                    } catch (SandwichParseException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            in.close();

        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
    }

    public void writeSandwiches() throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(getFilePath().toFile()))) {
            for (Sandwich s : sandwiches) {
                System.out.println("Output : " + s.toFileString());
                pw.println(s.toFileString());
            }
            System.out.println("Write successfull");
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
    }


}
