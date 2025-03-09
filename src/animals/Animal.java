 package animals;

 import data.ColorData;

 public abstract class Animal {

     private String name;
     private int age;
     private int weight;
     private ColorData color;

     public Animal(String name, int age, int weight, ColorData color) {
         this.name = name;
         this.age = age;
         this.weight = weight;
         this.color = color;
     }

     public String getName() {
         return name;
     }

     public int getAge() {
         return age;
     }

     public int getWeight() {
         return weight;
     }

     public ColorData getColor() {
         return color;
     }

 }
