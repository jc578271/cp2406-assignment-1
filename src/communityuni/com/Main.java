package communityuni.com;

import communityuni.com.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<TrafficLight> lights = new ArrayList<>();
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Road> roads = new ArrayList<>();
        // --Create road--
        for (int i = 0; i < 2; i++) {
            System.out.printf("Input info of road %d:%n", i);
            while (true) {
                try {
                    System.out.print(" * length: ");
                    double roadLength = new Scanner(System.in).nextDouble();
                    Road road = new Road(i, 1, roadLength);
                    roads.add(road);
                    System.out.println("...road added");

                    // set startLocation and connectedRoads
                    if (roads.size() > 1) {
                        road.setStartLocation(roads.get(i-1).getEndLocation());
                        roads.get(i-1).getConnectedRoads().add(road);
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("...invalid, input again...");
                }
            }
        }

        // --Create light--
        for (int i = 0; i < 1; i++) {
            System.out.printf("Input info of light %d:%n", i);
            while (true) {
                try {
                    System.out.print(" * index of attached road: ");
                    int index = new Scanner(System.in).nextInt();
                    if (index > roads.size() - 1 || index < 0) {
                        throw new Exception("Out of index");
                    }
                    TrafficLight light = new TrafficLight(i, roads.get(index));
                    lights.add(light);
                    System.out.printf("...traffic light added into road %d", index);
                    break;
                } catch (Exception ex) {
                    System.out.println("...invalid, input again...");
                }
            }
        }

        // --Create car--
        for (int i = 0; i < 1; i++) {
            System.out.printf("Input info of vehicle %d:%n", i);
            while (true) {
                try {
                    System.out.print(" * type (car/bus/motorbike): ");
                    String type = new Scanner(System.in).nextLine();
                    Car car = switch (type) {
                        case "car" -> new Car(0, roads.get(0));
                        case "bus" -> new Bus(0, roads.get(0));
                        case "motorbike" -> new Motorbike(0, roads.get(0));
                        default -> throw new Exception();
                    };
                    while (true) {
                        if (roads.get(0).getLength() < car.getLength()) {
                            System.out.println("...start road's length is shorter than this vehicle's length");
                            System.out.print("do you want to change length of start road (y/n)? ");
                            String choice = new Scanner(System.in).nextLine();
                            if (choice.equalsIgnoreCase("y")) {
                                while (true) {
                                    try {
                                        System.out.print("update first road's length: ");
                                        double length = new Scanner(System.in).nextDouble();
                                        roads.get(0).setLength(length);
                                        roads.get(0).setStartLocation(new double[] {0, 0});
                                        System.out.println("...first road's length changed");
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("...invalid, input again...");
                                    }
                                }
                            } else {
                                throw new Exception();
                            }
                        } else {
                            cars.add(car);
                            System.out.println("...car added automatically");
                            break;
                        }
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("...input other vehicle's type...");
                }
            }

        }
        System.out.println("---------------------------------");
        // --Show info--
        System.out.println("--Before moving--");
        for (Car car: cars) {
            System.out.println(car.bio());
        }
        System.out.println();

        // --Simulator...--
        System.out.println("--Start moving--");
        int finishedCars = 0;
        double time = 0;
        while (finishedCars < cars.size()) {
            // Lights operate
            for (TrafficLight light : lights) {
                light.operate();
            }

            // Cars moving...
            for (Car car: cars) {
                // Print light's state
                if (!car.getCurrentRoad().getLightsOnRoad().isEmpty()
                        && car.getPosition() == car.getCurrentRoad().getEndLocation()[0]) {
                    TrafficLight light = car.getCurrentRoad().getLightsOnRoad().get(0);
                    System.out.println(light.getId()+": "+light.getState().toUpperCase());
                }

                // Print car's info
                car.move();
                System.out.println(car.bio());
                // All cars have to be finished
                if (car.getCurrentRoad().getConnectedRoads().isEmpty()
                        && car.getPosition() == car.getCurrentRoad().getEndLocation()[0]) {
                    finishedCars++;
                }
            }
            time += 1;
            System.out.println(time+"s passed");
            System.out.println();

            // Delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {}
        }
        System.out.println("...End");
    }
}
