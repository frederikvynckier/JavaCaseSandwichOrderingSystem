package be.abis.sos.utils;

import be.abis.sos.enumeration.SandwichType;
import be.abis.sos.exception.SandwichParseException;
import be.abis.sos.model.Sandwich;
import be.abis.sos.repository.SandwichTypeRepository;

public class SandwichUtils {

    public static Sandwich parseSandwich(String s) {

        SandwichTypeRepository str = new SandwichTypeRepository();
        SandwichType st;
        double price;
        String nameDutch;
        String nameFrench;
        Sandwich sandwich = null;


        String[] fields = s.split(";");
        if (fields.length != 4) {
            throw new SandwichParseException("Wrong number of fields : " + fields.length + " instead of 4");
        }
        try {
            int id = Integer.parseInt(fields[0]);
            st = str.findSandwichType(id);
        } catch (Exception e) {
            throw new SandwichParseException("Wrong sandwich type : " + fields[0]);
        }

        try {
            price = Double.parseDouble(fields[3]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        nameDutch = fields[1];
        nameFrench = fields[2];

        sandwich = new Sandwich(nameDutch, nameFrench, st, price);

        return sandwich;
    }

}
