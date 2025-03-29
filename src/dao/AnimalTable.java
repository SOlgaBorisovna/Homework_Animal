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
                    long id = rs.getLong("id");
                    String name = rs.getString("name");
                    int weight = rs.getInt("weight");
                    String color = rs.getString("color");
                    String type = rs.getString("type");
                    int age = rs.getInt("age");

                    AnimalFactory animalFactory = new AnimalFactory(name, age, weight,  ColorData.valueOf(color.toUpperCase()));
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
    public Animal findById(Long searchId) {
        // TODO: нужно черех фабрику!!!
        Animal animal = null;
        try {
            try (ResultSet rs = MySqlConnectionDb.getInstance().requestExecuteWithReturned("SELECT * FROM " + tableName + " WHERE id=" + searchId)) {
                while (rs.next()) {
                    long id = rs.getLong("id");
                    String name = rs.getString("name");
                    int weight = rs.getInt("weight");
                    String color = rs.getString("color");
                    String type = rs.getString("type");
                    int age = rs.getInt("age");

                    // TODO: нужно черех фабрику!!!
                    //animal = new Animal(color, name, weight, id, type, age);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return animal;
    }
}
