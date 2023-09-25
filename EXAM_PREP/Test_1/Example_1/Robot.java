package Example_1;
public abstract class Robot implements Movable, Cloneable, Comparable < Robot > {
    private String name;
    private int position;

    protected Robot(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String toString() {
        return name + "\t\t" + position;
    }

    
    public int compareTo(Robot ro) {
        if (this.getPosition() < ro.getPosition()) {
            return -1;
        } else if (this.getPosition() > ro.getPosition()) {
            return 1;
        } else {
            return 0;
        }
    }

    public abstract void move(int max) throws OutOfRangeException;

    public abstract Object clone();


}