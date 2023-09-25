package Example_1;
public class SonicRobot extends Robot {
    public SonicRobot(String name, int position) {
        super(name, position);
    }

    public void move(int max) {
        this.setPosition(10 * this.getPosition());
        if (this.getPosition() > max) {
            throw new OutOfRangeException("Reached out of range.");
        }
    }

    public Object clone() {
        return new SonicRobot(new String(this.getName()), this.getPosition());
    }

    @Override
    public String toString() {
        String before = "Sonic\t\t" + super.toString();
        
        return before;
    }
}