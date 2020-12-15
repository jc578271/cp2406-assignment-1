package communityuni.com.model;

public class Bus extends Car {

    public Bus(int id, Road currentRoad) {
        super(id, currentRoad);
        this.id = String.format("bus_%d", id);
        this.length = 3 * super.length;
        this.position = this.length;
    }

    @Override
    public String bio() {
        return id +
                ", position: " + "["+position+", 0"+"]" +
                ", speed: " + super.getSpeed() + " m/s" +
                ", currentRoad: " + super.getCurrentRoad().getId();
    }
}
