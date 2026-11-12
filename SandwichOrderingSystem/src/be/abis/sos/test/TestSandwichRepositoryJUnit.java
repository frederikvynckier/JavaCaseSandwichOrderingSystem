package be.abis.sos.test;

import be.abis.sos.enumeration.Language;
import be.abis.sos.enumeration.SandwichType;
import be.abis.sos.model.Sandwich;
import be.abis.sos.repository.SandwichRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestSandwichRepositoryJUnit {

    SandwichRepository sr;
    Sandwich sandwich;

    @BeforeEach
    public void setUp() {
        sr = new SandwichRepository();
    }

    @Test
    public void readSandwichesFromFile() {
        try {
            sr.readSandwiches();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
