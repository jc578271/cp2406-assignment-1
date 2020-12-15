package communityuni.com.model;

import java.util.Random;

public class TrafficLight {
    private String id;
    private String state;
    private double position;
    private Road roadAttachedTo;

    public TrafficLight(int id, Road roadAttachedTo) {
        this.id = String.format("light_%d",id);
        this.position = roadAttachedTo.getEndLocation()[0];
        roadAttachedTo.getLightsOnRoad().add(this);
        this.roadAttachedTo = roadAttachedTo;
    }

    public TrafficLight() {
        this.id = "light_0";
    }

    public void operate() {
        Random rd = new Random();
        if (rd.nextDouble() >= 0.5) {
            setState("green");
        } else {
            setState("red");
        }
    }

    public String bio() {
        return  id +
                ", state: " +state.toUpperCase()+
                ", position: " + "["+position+", 0"+"]"+
                ", roadAttachedTo: " + roadAttachedTo.getId();
    }

    public String getId() {
        return id;
    }
    public void setId(int id) {
        this.id = String.format("light_%d",id);
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public double getPosition() {
        return position;
    }
    public void setPosition(double position) {
        this.position = position;
    }
    public Road getRoadAttachedTo() {
        return roadAttachedTo;
    }
    public void setRoadAttachedTo(Road roadAttachedTo) {
        this.roadAttachedTo = roadAttachedTo;
    }
}
