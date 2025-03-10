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