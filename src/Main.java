//Реализуйте класс CoffeeMachine (Кофемашина)
//
//У нашей кофемашины есть:
//        -название
//-количество воды (целое число миллилитров)
//-количество кофе (целое число грамм)
//-количество молока (целое число миллилитров)
//реализуйте сеттеры и геттеры, причем:
//добавить кофе ( setCoffe(int cofe) ). Максимум машина вмещает 500 г кофе.
//добавить воды ( setWater(int water) ). Максимум машина вмещает 1 л воды.
//добавить молока (setMilk(int milk)). Максимум машина вмещает 500 мл молока.
//
//реализуйте метод приготовить кофе: если в машине достаточно ресурсов, она ‘готовит кофе” используя 30г кофе 100 мл воды, 50 мл молока.  ‘готовит кофе” - означает вывести  на экран что то типа: измельчаю 30г кофе, добавляю 100 мл. воды ….
//
//реализуйте метод String toString() который формирует строку вида: в машине 100г. кофе, 200 мл. воды, 100 мл. молока


import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine("Delonghi", 30, 100, 200);
        CoffeeMachine coffeeMachine1 = new CoffeeMachine();
        char choice;
        boolean isNormalEnter;

        System.out.println("Хотите кофе(y/n)?");
        do {
            try {
                choice = (char) System.in.read();
                isNormalEnter = true;

                int extraChar;
                while ((extraChar = System.in.read()) != '\n' && extraChar != -1) {
                    isNormalEnter = false;
                }

                if (!isNormalEnter) {
                    System.out.println("Ошибка ввода! Введите только один символ (y/n)");
                } else if (choice == 'y' || choice == 'Y') {


                    coffeDo(coffeeMachine);


                } else if (choice == 'n' || choice == 'N') {
                    System.out.println("Всего доброго!");
                    break;
                } else {
                    System.out.println("Введите корректный символ y/n");
                }
            } catch (IOException e) {
                System.out.println("Ошибка ввода. Попробуйте снова.");
            }
        } while (true);

    }

    private static void coffeDo(CoffeeMachine coffeeMachine) {
        try {
            prepairCofe(coffeeMachine);
            System.out.println("Все еще хотите кофе(y/n)?");
        } catch (Exception e) {
            System.out.println("Ошибка ввода!");
        }
    }

    public static void prepairCofe(CoffeeMachine coffeeMachine) {
        Scanner sc = new Scanner(System.in);

        do {
            if (coffeeMachine.getCoffeeGramms() >= 30) {
                if (coffeeMachine.getMilkInMiliLitrs() >= 50) {
                    if (coffeeMachine.getWaterInMiliLitrs() >= 100) {
                        coffeeMachine.prepairCoffe();
                        break;
                    } else {
                        maloMeterial(coffeeMachine, sc,"воды");
                    }
                } else {
                   maloMeterial(coffeeMachine, sc,"молока");
                }
            } else {
                maloMeterial(coffeeMachine, sc,"кофе");
            }
        } while (true);
    }

    private static void  maloMeterial(CoffeeMachine coffeeMachine,Scanner sc,String name){


            System.out.printf("Не хватает %s!", name);
            System.out.println();
            System.out.println(coffeeMachine);
            System.out.printf("Введите количество %s, которое хотите добавить:", name);
            int amnt=sc.nextInt();

                if (name.equals("кофе")) {
                    coffeeMachine.setCoffeeGramms(amnt);
                }else if(name.equals("молока")){
                    coffeeMachine.setMilkInMiliLitrs(amnt);
                }else {
                    coffeeMachine.setWaterInMiliLitrs(amnt);
                }

    }


}
