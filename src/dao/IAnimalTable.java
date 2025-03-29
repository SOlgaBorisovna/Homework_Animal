package dao;

import animals.Animal;

import java.util.List;

public interface IAnimalTable {
    List<Animal> findAll();
    Animal findById(Long searchId);
}
