package Test.B5_AdvancedObjectOrientedDesign.TH.LopAnimalVaLopInterfaceEdible;

import Test.B5_AdvancedObjectOrientedDesign.TH.LopAnimalVaLopInterfaceEdible.animal.Animal;
import Test.B5_AdvancedObjectOrientedDesign.TH.LopAnimalVaLopInterfaceEdible.animal.Chicken;
import Test.B5_AdvancedObjectOrientedDesign.TH.LopAnimalVaLopInterfaceEdible.animal.Tiger;
import Test.B5_AdvancedObjectOrientedDesign.TH.LopAnimalVaLopInterfaceEdible.edible.Edible;
import Test.B5_AdvancedObjectOrientedDesign.TH.LopAnimalVaLopInterfaceEdible.fruit.Apple;
import Test.B5_AdvancedObjectOrientedDesign.TH.LopAnimalVaLopInterfaceEdible.fruit.Fruit;
import Test.B5_AdvancedObjectOrientedDesign.TH.LopAnimalVaLopInterfaceEdible.fruit.Orange;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());;
            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
         }
            Fruit[] fruits = new Fruit[2];
            fruits[0] = new Orange();
            fruits[1] = new Apple();
            for (Fruit fruit : fruits) {
                System.out.println(fruit.howToEat());
            }
        }
    }

}
