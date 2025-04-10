package dao;

import data.AnimalTypeData;
import data.ColorData;
import db.MySqlConnectionDb;
import animals.Animal;
import factory.AnimalFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalTable extends AbsTable implements IAnimalTable{
    public AnimalTable() {
        super("animals");
        columns.put("color", "varchar(15)");
        columns.put("name", "varchar(15)");
        columns.put("weight", "int");
        columns.put("id", "bigint PRIMARY KEY AUTO_INCREMENT");
        columns.put("type", "varchar(15)");
        columns.put("age", "int");
        create();
        MySqlConnectionDb manager = MySqlConnectionDb.getInstance();
    }

    @Override
    public List<Animal> findAll() {
        List<Animal> animals = new ArrayList<>();
        try {
            try (ResultSet rs = MySqlConnectionDb.getInstance().requestExecuteWithReturned("SELECT * FROM " + tableName)) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int weight = rs.getInt("weight");
                    String color = rs.getString("color");
                    String type = rs.getString("type");
                    int age = rs.getInt("age");

                    AnimalFactory animalFactory = new AnimalFactory(name, age, weight,  ColorData.valueOf(color.toUpperCase()), id);
                    Animal animal = animalFactory.create(AnimalTypeData.valueOf(type.toUpperCase()));
                    animals.add(animal);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return animals;
    }

    @Override
    public List<Animal> findByType(AnimalTypeData searchType) {
        List<Animal> animals = new ArrayList<>();
        try {
            try (ResultSet rs = MySqlConnectionDb.getInstance().requestExecuteWithReturned(String.format("SELECT * FROM %s WHERE type = '%s' ", tableName, searchType.name()))) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int weight = rs.getInt("weight");
                    String color = rs.getString("color");
                    String type = rs.getString("type");
                    int age = rs.getInt("age");

                    AnimalFactory animalFactory = new AnimalFactory(name, age, weight,  ColorData.valueOf(color.toUpperCase()), id);
                    Animal animal = animalFactory.create(AnimalTypeData.valueOf(type.toUpperCase()));
                    animals.add(animal);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return animals;
    }

    @Override
    public Animal findById(String animalId) {
        Animal animal = null;
        try {
            try (ResultSet rs = MySqlConnectionDb.getInstance().requestExecuteWithReturned(String.format("SELECT * FROM %s WHERE id = '%s' ", tableName, animalId))) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int weight = rs.getInt("weight");
                    String color = rs.getString("color");
                    String type = rs.getString("type");
                    int age = rs.getInt("age");

                    AnimalFactory animalFactory = new AnimalFactory(name, age, weight,  ColorData.valueOf(color.toUpperCase()), id);
                    animal = animalFactory.create(AnimalTypeData.valueOf(type.toUpperCase()));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return animal;
    }



    @Override
    public void addAnimal(Animal newAnimal) {
        try {
            MySqlConnectionDb.getInstance().requestExecute(
                    String.format("INSERT INTO %s (color, name, weight, type, age) VALUES ('%s', '%s', %d, '%s', %d)", tableName, newAnimal.getColor().name(), newAnimal.getName(), newAnimal.getWeight(), newAnimal.getType().name(), newAnimal.getAge()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateById(String id, String newNameAnimal, String newAgeAnimal, String newWeightAnimal, ColorData newColor) {
        try {
            MySqlConnectionDb.getInstance().requestExecute(
                    String.format("UPDATE %s SET name = '%s', weight = '%s', color = '%s', age = '%s' WHERE id = %s", tableName, newNameAnimal, newWeightAnimal, newColor.name(), newAgeAnimal, id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
