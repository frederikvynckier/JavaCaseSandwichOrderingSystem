package be.abis.sos.model;

import be.abis.sos.enumeration.BreadType;
import be.abis.sos.enumeration.VegetableType;

public class SandwichOrder {
    private Sandwich sandwich;
    private VegetableType withVegetables;
    private BreadType breadType;
    private int quantity;

    public SandwichOrder(Sandwich sandwich,
                         VegetableType withVegetables,
                         BreadType breadType,
                         int quantity) {
        this.sandwich = sandwich;
        this.withVegetables = withVegetables;
        this.breadType = breadType;
        this.quantity = quantity;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }
    public VegetableType getWithVegetables() {
        return withVegetables;
    }
    public void setWithVegetables(VegetableType withVegetables) {
        this.withVegetables = withVegetables;
    }
    public BreadType getBreadType() {
        return breadType;
    }
    public void setBreadType(BreadType breadType) {
            this.breadType = breadType;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}


