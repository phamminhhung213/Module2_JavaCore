package B5_AdvancedObjectOrientedDesign.TH.LopAnimalVaLopInterfaceEdible.animal;

import B5_AdvancedObjectOrientedDesign.TH.LopAnimalVaLopInterfaceEdible.edible.Edible;

public class Chicken extends Animal implements Edible {


    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
