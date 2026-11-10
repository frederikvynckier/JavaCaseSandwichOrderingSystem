package be.abis.sos.repository;

import be.abis.sos.exception.SandwichParseException;
import be.abis.sos.model.Sandwich;
import be.abis.sos.utils.SandwichUtils;

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

    public void readSandwiches() throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(getFilePath().toFile()))) {
            String nextLine;
            Sandwich sandwich;
            while ((nextLine = in.readLine()) != null) {
                if (!nextLine.trim().isBlank()) {
                    System.out.println(nextLine);
                    try {
                        sandwich = SandwichUtils.parseSandwich(nextLine);
                    } catch (SandwichParseException e) {
                        System.out.println(e.getMessage());
                    }
                    //sandwiches.add(new Sandwich(nextLine));
                }
            }
            in.close();

        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
    }

    public void writeSandwiches() throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(getFilePath().toFile()))) {
            for (Sandwich c : sandwiches) {
                //pw.println(c.getName());
            }
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
    }


}
