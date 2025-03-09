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

     public void say() {
         System.out.println("Я говорю");
     }

     public void go() {
         System.out.println("Я иду");
     }

     public void eat() {
         System.out.println("Я ем");
     }

     public void drink() {
         System.out.println("Я пью");
     }

     @Override
     public String toString() {
         return String.format("Привет! Меня зовут %s, мне %d %s, я вешу - %s, мой цвет - %s", name, age, , weight, color.getColorName());
     }

     private String getYearPadezh() {

         if(age >= 11 && age <= 14) {
             return "лет";
         }

         int ostatok = age % 10;

         if(ostatok == 1) {
             return "год";
         }

         if (ostatok >= 2 && ostatok <= 4) {
             return "года";
         }

         return "лет";
     }
 }

//     private String ageToString (){
//         int first = age;
//         int second = age % 100;
//         int f = age % 10;
//         if (second == 11)
//             return(age + " лет");
//         else if (f == 0 || f == 5 || f == 6 || f == 7 || f == 8 || f == 9)
//             return(age + " лет");
//         else if (f == 1)
//             return(age + " год");
//         else if (f == 2 || f == 3 || f == 4)
//             return(age +" года");
//
//         return "";
//     }


