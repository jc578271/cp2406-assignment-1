package communityuni.com.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Road {
    private String id;
    private int speedLimit;
    private double length;
    private double[] startLocation;
    private double[] endLocation;
    private ArrayList<Road> connectedRoads = new ArrayList<>();
    private ArrayList<TrafficLight> lightsOnRoad = new ArrayList<>();
    private ArrayList<Car> carsOnRoad = new ArrayList<>();

    public Road(int id, int speedLimit, double length) {
        this.id = String.format("road_%d",id);
        this.speedLimit = speedLimit;
        this.length = length;
        this.startLocation = new double[]{0, 0};
        this.endLocation = new double[]{this.length + this.startLocation[0], 0};
    }

    public Road() {
        this.id = "road_0";
        this.speedLimit = 0;
        this.length = 0;
        this.startLocation = new double[]{0, 0};
        this.endLocation = new double[]{getLength()+getStartLocation()[0], 0};
    }

    public String bio() {
        return "Road{" +
                "id=" + id +
                ", speedLimit=" + speedLimit +
                ", length=" + length +
                ", startLocation=" + Arrays.toString(startLocation) +
                ", endLocation=" + Arrays.toString(endLocation) +
                ", connectedRoads=" + connectedRoads +
                ", lightsOnRoad=" + lightsOnRoad +
                ", carsOnRoad=" + carsOnRoad +
                '}';
    }

    public String getId() {
        return id;
    }
    public void setId(int id) {
        this.id = String.format("road_%d",id);
    }
    public int getSpeedLimit() {
        return speedLimit;
    }
    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
        System.out.println(this.length);
    }
    public double[] getStartLocation() {
        return startLocation;
    }
    public void setStartLocation(double[] startLocation) {
        this.startLocation = startLocation;
        this.endLocation = new double[]{getStartLocation()[0] + getLength(), 0};
    }
    public double[] getEndLocation() {
        return endLocation;
    }
    public ArrayList<Road> getConnectedRoads() {
        return connectedRoads;
    }
    public void setConnectedRoads(ArrayList<Road> connectedRoads) {
        this.connectedRoads = connectedRoads;
    }
    public ArrayList<TrafficLight> getLightsOnRoad() {
        return lightsOnRoad;
    }
    public void setLightsOnRoad(ArrayList<TrafficLight> lightsOnRoad) {
        this.lightsOnRoad = lightsOnRoad;
    }
    public ArrayList<Car> getCarsOnRoad() {
        return carsOnRoad;
    }
    public void setCarsOnRoad(ArrayList<Car> carsOnRoad) {
        this.carsOnRoad = carsOnRoad;
    }
}
