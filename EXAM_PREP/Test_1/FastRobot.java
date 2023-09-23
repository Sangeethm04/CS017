public class FastRobot extends Robot {
    public FastRobot(String name, int position) {
        super(name, position);
    }


    public void move(int max) {
        this.setPosition(2 + this.getPosition());
        if (this.getPosition() > max) {
            throw new OutOfRangeException(this.getName() + "\t\t" + this.getPosition() + "\t\t" + "Bro its max is bigger-fast");
        }
    }

    public Object clone() {
        return new FastRobot(new String(this.getName()), this.getPosition());
    }

    @Override
    public String toString() {
        String before = "Fast\t\t" + super.toString();
        
        return before;
    }


}