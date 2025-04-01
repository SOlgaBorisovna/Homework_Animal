package dao;

import animals.Animal;
import data.AnimalTypeData;

import java.util.List;

public interface IAnimalTable {

    List<Animal> findAll();
    List<Animal> findByType(AnimalTypeData searchType);
    void addAnimal(Animal newAnimal);
    void updateById(String id, String newName);
}
