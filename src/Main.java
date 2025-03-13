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

    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<Animal>();

        Scanner scanCommand = new Scanner(System.in);

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
                    userCommand = scanCommand.nextLine().trim();
                    userCommandUpperCase = userCommand.toUpperCase();
                    command = CommandsData.valueOf(userCommandUpperCase);
                } catch (IllegalArgumentException e) {
                    System.out.printf("Команда %s не поддерживается программой!\n", userCommand);
                }
            } while (command == null);

            switch (command) {
            case ADD:
                addAnimal(animals);
                break;
            case LIST:
                listAnimals(animals);
                break;
            case EXIT:
                System.exit(0);
                break;
            }
        }
    }

    public static void addAnimal(ArrayList<Animal> animals) {

        Scanner scanAnimal = new Scanner(System.in);

        List<String> typesAnimal = new ArrayList<>();
        for (AnimalTypeData animal : AnimalTypeData.values()) {
            typesAnimal.add(animal.name());
        }

        AnimalTypeData typeAnimal = null;
        String userAnimal = null;
        do {
            System.out.printf(String.format("Введите животное: %s \n", String.join("/", typesAnimal)));
            try {
                userAnimal = scanAnimal.nextLine().trim();
                typeAnimal = AnimalTypeData.valueOf(userAnimal);
            } catch (IllegalArgumentException e) {
                System.out.printf("Тип животного %s не поддерживается программой!\n", userAnimal);
            }
        } while (typeAnimal == null);

        System.out.println("Введите имя:");
        String nameAnimal = scanAnimal.nextLine();

        NumberTools validatorAge = new NumberTools();
        String ageAnimal = null;
        do {
            System.out.println("Введите возраст:");
            ageAnimal = scanAnimal.nextLine();
            if (!validatorAge.isNumber(ageAnimal))
                System.out.println("Недопустимое значение для возраста!\n");
        } while(!validatorAge.isNumber(ageAnimal));

        NumberTools validatorWeight = new NumberTools();
        String weightAnimal = null;
        do {
            System.out.println("Введите вес:");
            weightAnimal = scanAnimal.nextLine();
            if (!validatorWeight.isNumber(weightAnimal))
                System.out.println("Недопустимое значение для веса!\n");
        } while(!validatorWeight.isNumber(weightAnimal));

        Scanner scanColor = new Scanner(System.in);

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
                userColor = scanColor.nextLine().trim();
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

    public static void listAnimals(ArrayList < Animal > animals) {
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i));
        }
    }

}