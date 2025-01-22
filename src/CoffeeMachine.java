class CoffeeMachine {
    private String name;
    private int coffeeGramms;
    private int milkInMiliLitrs;
    private int waterInMiliLitrs;

    public CoffeeMachine(String name, int coffeeGramms, int milkInMiliLitrs, int waterInMiliLitrs) {
        this.name = name;
        this.coffeeGramms = coffeeGramms;
        this.milkInMiliLitrs = milkInMiliLitrs;
        this.waterInMiliLitrs = waterInMiliLitrs;
    }

    public CoffeeMachine() {
        this("Noname", 0, 0, 0);
    }

    public void prepairCoffe() {
        try {
            System.out.println(this);
            System.out.println("Готовим кофе....");
            Thread.sleep(1000);
            System.out.println("...");
            Thread.sleep(1000);
            System.out.println("...измельчаю 30г кофе, добавляю 100 мл. воды, добавляю 50 мл молока...");
            Thread.sleep(1000);
            System.out.println("...");
            Thread.sleep(1000);
            System.out.println("...Ваш кофе готов!");
            coffeeGramms -= 30;
            milkInMiliLitrs -= 50;
            waterInMiliLitrs -= 100;
            System.out.println(this);
        } catch (InterruptedException e) {
            System.out.println("Вы прервали приготовление!!! Нет вам больше кофе!");
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMilkInMiliLitrs() {
        return milkInMiliLitrs;
    }

    public void setMilkInMiliLitrs(int milkInMiliLitrs) {
        if (milkInMiliLitrs + getMilkInMiliLitrs() > 500) {
            System.out.println("Столько молока в машину не влезет!");
            System.out.println("Влезет максимум еще: " + (500 - getMilkInMiliLitrs()));
        } else this.milkInMiliLitrs += milkInMiliLitrs;
    }

    public int getCoffeeGramms() {
        return coffeeGramms;
    }

    public void setCoffeeGramms(int coffeeGramms) {
        if (coffeeGramms + getCoffeeGramms() > 500) {
            System.out.println("Столько кофе в машину не влезет!");
            System.out.println("Влезет максимум еще: " + (500 - getCoffeeGramms()));
        } else this.coffeeGramms += coffeeGramms;
    }

    public int getWaterInMiliLitrs() {
        return waterInMiliLitrs;
    }

    public void setWaterInMiliLitrs(int waterInMiliLitrs) {
        if (waterInMiliLitrs + getWaterInMiliLitrs() > 1000) {
            System.out.println("Столько воды в машину не влезет!");
            System.out.println("Влезет максимум еще: " + (1000 - getWaterInMiliLitrs()));
        } else this.waterInMiliLitrs += waterInMiliLitrs;
    }

    @Override
    public String toString() {
        return "В машине " +
                "с названием: \"" + name + "\" на данный момент - " +
                coffeeGramms + " грамм кофе, " +
                +milkInMiliLitrs + " миллилитров молока, " +
                +waterInMiliLitrs + " милилитров воды";
    }
}
