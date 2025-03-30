package animals.pets;

import animals.Animal;
import data.AnimalTypeData;
import data.ColorData;

public class Cat extends Animal {

    public Cat(String name, int age, int weight, ColorData color) {

        super(name, age, weight, color, AnimalTypeData.CAT);
    }

    @Override
    public void say() {
        System.out.println("Мяу");
    }
}
