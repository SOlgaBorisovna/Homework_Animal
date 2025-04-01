package animals.birds;

import animals.Animal;
import data.AnimalTypeData;
import data.ColorData;

public class Duck extends Animal implements IFlying {

    public Duck(String name, int age, int weight, ColorData color, int id) {

        super(name, age, weight, color, AnimalTypeData.DUCK, id);
    }

    @Override
    public void fly() {
        System.out.println("Я лечу");
    }

    @Override
    public void say() {
        System.out.println("Кря");
    }
}
