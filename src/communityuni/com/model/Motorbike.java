package communityuni.com.model;

public class Motorbike extends Car {
    public Motorbike(int id, Road currentRoad) {
        super(id, currentRoad);
        this.id = String.format("motorbike_%d", id);
        this.length = 0.5 * super.length;
        this.position = this.length;
    }

    @Override
    public String bio() {
        return id +
                ", position=" + "["+position+", 0"+"]" +
                ", speed=" + super.getSpeed() + " m/s" +
                ", currentRoad=" + super.getCurrentRoad().getId() +
                '}';
    }
}
