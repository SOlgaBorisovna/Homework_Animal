import animals.Animal;
import data.AnimalTypeData;
import data.ColorData;
import data.CommandsData;
import factory.AnimalFactory;
import tools.NumberTools;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Animal> animals = new ArrayList<>();

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        List<String> namesCommand = new ArrayList<>();
        for (CommandsData command : CommandsData.values()) {
            namesCommand.add(command.name());
        }

        while (true) {

            CommandsData command = null;
            String userCommand = null;
            String userCommandUpperCase = null;

            do {
                System.out.printf(String.format("Введите команду: %S \n", String.join("/", namesCommand)));
                try {
                    userCommand = scan.nextLine().trim();
                    userCommandUpperCase = userCommand.toUpperCase();
                    command = CommandsData.valueOf(userCommandUpperCase);
                } catch (IllegalArgumentException e) {
                    System.out.printf("Команда %s не поддерживается программой!\n", userCommand);
                }
            } while (command == null);

            switch (command) {
            case ADD:
                addAnimal();
                break;
            case LIST:
                listAnimals();
                break;
            case EXIT:
                scan.close();
                System.exit(0);
                break;
            }
        }
    }

    public static void addAnimal() {

        List<String> typesAnimal = new ArrayList<>();
        for (AnimalTypeData animal : AnimalTypeData.values()) {
            typesAnimal.add(animal.name());
        }

        AnimalTypeData typeAnimal = null;
        String userAnimal = null;
        String userAnimalUpperCase = null;
        do {
            System.out.printf(String.format("Введите животное: %s \n", String.join("/", typesAnimal)));
            try {
                userAnimal = scan.nextLine().trim();
                userAnimalUpperCase = userAnimal.toUpperCase();
                typeAnimal = AnimalTypeData.valueOf(userAnimalUpperCase);
            } catch (IllegalArgumentException e) {
                System.out.printf("Тип животного %s не поддерживается программой!\n", userAnimal);
            }
        } while (typeAnimal == null);

        System.out.println("Введите имя:");
        String nameAnimal = scan.nextLine();

        NumberTools validatorAge = new NumberTools();
        String ageAnimal = null;
        do {
            System.out.println("Введите возраст:");
            ageAnimal = scan.nextLine();
            if (!validatorAge.isNumber(ageAnimal))
                System.out.println("Недопустимое значение для возраста!\n");
        } while(!validatorAge.isNumber(ageAnimal));

        NumberTools validatorWeight = new NumberTools();
        String weightAnimal = null;
        do {
            System.out.println("Введите вес:");
            weightAnimal = scan.nextLine();
            if (!validatorWeight.isNumber(weightAnimal))
                System.out.println("Недопустимое значение для веса!\n");
        } while(!validatorWeight.isNumber(weightAnimal));

        List<String> namesColor = new ArrayList<>();
        for (ColorData color : ColorData.values()) {
            namesColor.add(color.name());
        }

        ColorData color = null;
        String userColor = null;
        String userColorUpperCase = null;

        do {
            System.out.printf(String.format("Введите цвет: %S \n", String.join("/", namesColor)));
            try {
                userColor = scan.nextLine().trim();
                userColorUpperCase = userColor.toUpperCase();
                color = ColorData.valueOf(userColorUpperCase);
            } catch (IllegalArgumentException e) {
                System.out.printf("Цвет %s не поддерживается!\n", userColor);
            }
        } while (color == null);

        AnimalFactory animalFactory = new AnimalFactory(nameAnimal, Integer.parseInt(ageAnimal), Integer.parseInt(weightAnimal), color);
        Animal animal = animalFactory.create(typeAnimal);
        animals.add(animal);
        animal.say();
    }

    public static void listAnimals() {
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i));
        }
    }
}