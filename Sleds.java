public class Sleds<E1, E2> {
    private E1 name;
    private E2 job;

    public E1 getName() {
        return name;
    }

     public E2 getJob() {
        return job;
    }

    public Sleds(E1 name, E2 job) {
        this.name = name;
        this.job = job;
    }

    public void Sound() {
        System.out.println("weeee!" + name.toString() + job.toString());
    }

    public String toString() {
        return this.getName() + " " + this.getJob();
    }
}
