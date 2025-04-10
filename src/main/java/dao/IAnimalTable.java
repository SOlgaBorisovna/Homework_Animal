package dao;

import animals.Animal;
import data.AnimalTypeData;
import data.ColorData;

import java.util.List;

public interface IAnimalTable {

    List<Animal> findAll();
    List<Animal> findByType(AnimalTypeData searchType);
    Animal findById (String id);
    void addAnimal(Animal newAnimal);
    void updateById(String id, String newName, String newAge, String newWeight, ColorData newColor);
}
