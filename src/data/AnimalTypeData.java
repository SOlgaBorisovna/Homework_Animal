package data;

public enum AnimalTypeData {
    CAT("Кошка");
    DOG("Собака");
    DUCK("Утка");

    private String animalTypeName;

    AnimalTypeData(String animalTypeName){
        this.animalTypeName = animalTypeName;
    }

    public String getAnimalTypeName(){
        return animalTypeName;
    }
}
