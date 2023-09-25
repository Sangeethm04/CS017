package Example_1;
public class TurboRobot extends Robot {
    public TurboRobot(String name, int position) {
        super(name, position);
    }

    public void move(int max) {
        this.setPosition(2*this.getPosition());
        if(this.getPosition() > max) {
            throw new OutOfRangeException("Bro its max is bigger-turbo");
        }
    }

    public Object clone() {
        return new TurboRobot(new String(this.getName()), this.getPosition());
    }

    @Override
    public String toString() {
        String before = "Turbo\t\t" + super.toString();
        
        return before;
    }
}
