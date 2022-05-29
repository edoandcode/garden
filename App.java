package exercises.garden;

import java.util.Date;

public class App {
    public static void main(String[] args ){
        try {
            var garden = new Garden(5);
            var pomodoro = new Vegetable(
                    "Pomodoro",
                    new Date(2022 - 1900, 6, 17),
                    new Date(2022 - 1900, 8, 6)
            );
            var melanzana = new Vegetable(
                    "Melanzana",
                    new Date(2022 - 1900, 6, 17),
                    new Date(2022 - 1900, 8, 6)
            );
            var lattuga = new Vegetable(
                    "Lattuga",
                    new Date(2022 - 1900, 6, 17),
                    new Date(2022 - 1900, 8, 6)
            );
            var zucchina = new Vegetable(
                    "Zucchina",
                    new Date(2022 - 1900, 6, 17),
                    new Date(2022 - 1900, 8, 6)
            );
            var carciofo = new Vegetable(
                    "Carciofo",
                    new Date(2022 - 1900, 6, 17),
                    new Date(2022 - 1900, 8, 6)
            );
            garden.plant(pomodoro, 10);
            garden.plant(melanzana, 10);
            garden.plant(lattuga, 10);
            garden.plant(zucchina, 10);
            garden.plant(carciofo, 20);
            System.out.println(garden);
        }catch(Exception e){
            System.out.println("Garden cannot be created " + e);
        }
    }
}
