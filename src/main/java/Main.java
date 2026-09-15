
import java.util.Scanner;

class Car {
    private final String name;
    private final int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}

class Race {
    private static final int RACE_DURATION_HOURS = 24;

    public Car findLeader(Car[] cars) {
        Car leader = null;
        int maxDistance = -1;

        for (Car car : cars) {
            int distance = car.getSpeed() * RACE_DURATION_HOURS;
            if (distance > maxDistance) {
                maxDistance = distance;
                leader = car;
            }
        }
        return leader;
    }
}

public class Main {
    private static final int MIN_SPEED = 1;
    private static final int MAX_SPEED = 250;
    private static final int CARS_COUNT = 3;

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < CARS_COUNT; i++) {
            System.out.println("Автомобиль №" + (i + 1));

            String name = readValidName(scanner);
            int speed = readValidSpeed(scanner);

            cars[i] = new Car(name, speed);
        }

        Race race = new Race();
        Car winner = race.findLeader(cars);

        System.out.println("Самая быстрая машина: " + winner.getName());

        scanner.close();
    }

    private static String readValidName(Scanner scanner) {
        while (true) {
            System.out.print("Введите название автомобиля: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Ошибка: название не может быть пустым. Попробуйте снова.");
            } else {
                return name;
            }
        }
    }

    private static int readValidSpeed(Scanner scanner) {
        while (true) {
            System.out.print("Введите скорость автомобиля (целое число от " + MIN_SPEED + " до " + MAX_SPEED + "): ");

            if (scanner.hasNextInt()) {
                int speed = scanner.nextInt();
                scanner.nextLine();

                if (speed >= MIN_SPEED && speed <= MAX_SPEED) {
                    return speed;
                } else {
                    System.out.println("Ошибка: скорость должна быть от " + MIN_SPEED + " до " + MAX_SPEED + ". Попробуйте снова.");
                }
            } else {
                System.out.println("Ошибка: нужно ввести целое число. Дробные значения не допускаются. Попробуйте снова.");
                scanner.nextLine();
            }
        }
    }
}
