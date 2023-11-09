
public class Horse {

    public String id;
    public boolean whetherExist;
    private String name;
    private int maxSpeed;
    private int acceleration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public Horse(String id, boolean whetherExist, String name, int maxSpeed, int acceleration) {
        super();
        this.id = id;
        this.whetherExist = whetherExist;
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
    }

}
