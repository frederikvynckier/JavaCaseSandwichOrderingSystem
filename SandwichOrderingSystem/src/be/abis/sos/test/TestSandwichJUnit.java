package be.abis.sos.test;

import be.abis.sos.enumeration.Language;
import be.abis.sos.enumeration.SandwichType;
import be.abis.sos.model.Sandwich;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestSandwichJUnit {

    Sandwich sandwich;

    @BeforeEach
    public void setUp() {
        sandwich = new Sandwich("SandwichNL","SandwichFR", SandwichType.SANDWICH_TYPE_FISH, 5.0);
    }

    @Test
    public void sandwichShouldHaveId() {
        try {
            int id = sandwich.getSandwichId();
            System.out.println(sandwich.toString(Language.LANGUAGE_DUTCH));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
