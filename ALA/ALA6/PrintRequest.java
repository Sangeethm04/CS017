/**
 * public class PrintRequest that implements Comparable
 */
public class PrintRequest implements Comparable < PrintRequest > {
    public enum groups {
        ROOT,
        ADMIN,
        USER,
        BATCH
    };
    private int id;
    private String group;
    private long size;
    /**
     * printrequest constructor method
     * @param id
     * @param gr
     * @param size
     */
    public PrintRequest(int id, String gr, long size) {
        this.id = id;
        group = gr;
        this.size = size;
    }
    /**
     * id getter method
     * @return int of id
     */
    public int getID() {
        return id;
    }
    /**
     * getter method for group
     * @return String of group
     */
    public String getGroup() {
        return group;
    }

    /**
     * getter method for size
     * @return long of the size
     */
    public long getSize() {
        return size;
    }

    /**
     * setter method for ID
     * @param id
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * setter method for group
     * @param gr group
     */
    public void setGroup(String gr) {
        group = gr;
    }

    /**
     * setter method for size
     * @param s size
     */
    public void setSize(long s) {
        size = s;
    }

    /**
     * toString method
     * @return String to attributes
     */
    public String toString() {
        double convertedSize = size;
        String unit = "bytes";
        if (convertedSize > 1000000000) {
            convertedSize /= 1000000000;
            unit = "GB";
        } else if (convertedSize > 1000000) {
            convertedSize /= 1000000;
            unit = "MB";
        } else if (convertedSize > 1000) {
            convertedSize /= 1000;
            unit = "KB";
        }
        String[] types = {
            "root",
            "admin",
            "user",
            "batch"
        };
        return String.format("%5d\t%-5s\t%5.1f%s", id, group, convertedSize, unit);
    }

    /**
     * public compareTo method
     * @return int of compare
     * @param pr printRequest
     */
    public int compareTo(PrintRequest pr) {
        return this.getPriority() - pr.getPriority();
    }

    /**
     * getter method for priority
     * @return int priority
     */
    private int getPriority() {
        String[] priorities = {
            "root",
            "admin",
            "user",
            "batch"
        };
        for (int i = 0; i < priorities.length; i++) {
            if (priorities[i].equals(group)) {
                return i;
            }
        }
        return -1;
    }
}