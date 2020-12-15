package communityuni.com.model;

import java.util.ArrayList;

public class Car {
    protected String id;
    protected double length;
    private double breadth;
    private int speed;
    protected double position;
    private Road currentRoad;

    public Car(int id, Road currentRoad) {
        this.id = String.format("car_%d",id);
        this.length = 1;
        this.breadth = length/2;
        this.speed = 0;
        this.position = this.length;
        currentRoad.getCarsOnRoad().add(this);
        this.currentRoad = currentRoad;
    }

    public Car() {
        this.id = "car_0";
        this.length = 1;
        this.breadth = length/2;
        this.speed = 0;
        this.position = this.length;
    }

    public void move() {
        ArrayList<TrafficLight> currentLights = currentRoad.getLightsOnRoad();
        // if front of car is at the end of road
        if (position == currentRoad.getEndLocation()[0]) {
            if (!currentLights.isEmpty() && currentLights.get(0).getState().equals("red")
                    ||currentRoad.getConnectedRoads().isEmpty()) {
                setSpeed(0);
            } else {
                currentRoad.getCarsOnRoad().remove(this);
                setCurrentRoad(currentRoad.getConnectedRoads().get(0));
                setSpeed(currentRoad.getSpeedLimit());
                currentRoad.getCarsOnRoad().add(this);
            }
        } else {
            setSpeed(currentRoad.getSpeedLimit());
        }

        // car moving...
        setPosition(position + speed);
    }

    public String bio() {
        return id +
                ", position: " + "["+position+", 0"+"]" +
                ", speed: " + speed + " m/s" +
                ", currentRoad: " + currentRoad.getId();
    }

    public String getId() {
        return id;
    }
    public void setId(int id) {
        this.id = String.format("car_%d",id);
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public double getBreadth() {
        return breadth;
    }
    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public double getPosition() {
        return position;
    }
    public void setPosition(double position) {
        this.position = position;
    }
    public Road getCurrentRoad() {
        return currentRoad;
    }
    public void setCurrentRoad(Road currentRoad) {
        this.currentRoad = currentRoad;
    }
}
