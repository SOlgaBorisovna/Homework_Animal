package animals.pets;

import animals.Animal;
import data.AnimalTypeData;
import data.ColorData;

public class Dog extends Animal {

    public Dog(String name, int age, int weight, ColorData color, int id) {

        super(name, age, weight, color, AnimalTypeData.DOG, id);
    }

    @Override
    public void say() {
        System.out.println("Гав");
    }

}
