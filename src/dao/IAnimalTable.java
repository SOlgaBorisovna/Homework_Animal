package dao;

import animals.Animal;

import java.util.List;

public interface IAnimalTable {

    List<Animal> findAll();
    List<Animal> findByType(String searchType);
    void addAnimal(Animal newAnimal);
}
