package be.abis.sos.repository;

import be.abis.sos.enumeration.SandwichType;
import be.abis.sos.exception.SandwichTypeNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class SandwichTypeRepository {

    private List<SandwichType> sandwichTypes = new ArrayList<SandwichType>();

    public SandwichTypeRepository() {
        sandwichTypes.add(SandwichType.SANDWICH_TYPE_MEAT);
        sandwichTypes.add(SandwichType.SANDWICH_TYPE_CHEESE);
        sandwichTypes.add(SandwichType.SANDWICH_TYPE_FISH);
        sandwichTypes.add(SandwichType.SANDWICH_TYPE_CHEESE);
        sandwichTypes.add(SandwichType.SANDWICH_TYPE_MEAT);
    }

    public List<SandwichType> getSandwichTypes() {
        return sandwichTypes;
    }

    public SandwichType findSandwichType(int id) throws SandwichTypeNotFoundException {
        SandwichType foundSandwichType=null;
        for (SandwichType s:sandwichTypes){
            if (s.getId()==id){
                foundSandwichType=s;
            }
        }
        if (foundSandwichType==null) throw new SandwichTypeNotFoundException("SandwichType " + id + " can not be found.");
        return foundSandwichType;
    }
}
