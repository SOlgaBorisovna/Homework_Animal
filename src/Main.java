/*
import animals.Animal;
import data.CommandsData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        List<String> namesCommand = new ArrayList<>();
        for(CommandsData commandsData: CommandsData.values()) {
            namesCommand.add(commandsData.name());
        }

        while(true) {

            System.out.printf(String.format("Введите команду: %S", String.join("/", namesCommand) ));

            String userCommand = scanner.next().trim();
            String userCommandUpperCase = userCommand.toUpperCase();

            boolean isCommandExist = false;
            for(CommandsData commandsData: CommandsData.values()) {
                if(userCommandUpperCase.equals(commandsData.name())) {
                    isCommandExist = true;
                    break;
                }
            }

            if(!isCommandExist) {
                System.out.printf("Команда %S не поддерживается\n", userCommand);
                continue;
            }

            switch (CommandsData.valueOf(userCommandUpperCase)) {
                case ADD: {
                    break;
                }
                case LIST: {
                    for(Animal animal: animals) {
                        System.out.println(animal.toString());
                        break;
                    }
                }
                case EXIT: {
                    System.exit(0);
                }
            }
        }

    }

}
 */





import animals.Animal;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
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
//        animals.add(new Cat("Murka", 3, 10, "Grey"));
//        animals.add(new Cat("Vaska", 1, 12, "Orange"));
//        animals.add(new Cat("Sharik", 7, 11, "Black"));
//        animals.add(new Cat("Tuzik", 2, 17, "Brown"));
//        animals.add(new Cat("Ga", 7, 2, "White"));
//        animals.add(new Cat("Gugu", 3, 4, "Grey"));

        //CommandsData command;
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
                    System.out.printf("Команда %s не поддерживается!\n", userCommand);
                }
            }while (command == null);

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
        //String animal;
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
                System.out.printf("Тип животного %s не поддерживается!\n", userAnimal);
                //typeAnimal = null;
            }
        } while (typeAnimal == null);

        System.out.println("Введите имя:");
        String nameCat = scanAnimal.nextLine();

        NumberTools validator = new NumberTools();
        String ageCat = null;
        do {
            System.out.println("Введите возраст:");
            ageCat = scanAnimal.nextLine();
            if (!validator.isNumber(ageCat))
                System.out.printf("Вы не ввели число!\n");
        } while(!validator.isNumber(ageCat));

        System.out.println("Введите вес:");
        int weightCat = scanAnimal.nextInt();
        String weightCatString = scanAnimal.nextLine();

        System.out.println("Введите цвет:");
        String colorCat = scanAnimal.nextLine();

        AnimalFactory animalFactory = new AnimalFactory(nameCat, Integer.parseInt(ageCat), weightCat, ColorData.RED);
        Animal animal = animalFactory.create(typeAnimal);
        animals.add(animal);
        animal.say();
    }

    public static void listAnimals (ArrayList < Animal > animals) {
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i));
        }
    }

}