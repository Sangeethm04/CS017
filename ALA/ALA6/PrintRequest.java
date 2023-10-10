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

    public PrintRequest(int id, String gr, long size) {
        this.id = id;
        group = gr;
        this.size = size;
    }
    public int getID() {
        return id;
    }
    public String getGroup() {
        return group;
    }
    public long getSize() {
        return size;
    }

    public void setID(int id) {
        this.id = id;
    }
    public void setGroup(String gr) {
        group = gr;
    }
    public void setSize(long s) {
        size = s;
    }

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
        String[] types = {"root", "admin", "user", "batch"};
        return String.format("%5d\t%-5s\t%5.1f%s", id, group, convertedSize, unit);
    }

    public int compareTo(PrintRequest pr) {
        return this.getPriority() - pr.getPriority();
    }

    private int getPriority() {
        String[] priorities = {"root", "admin", "user", "batch"};
        for(int i=0; i<priorities.length; i++) {
            if(priorities[i].equals(group)) {
                return i;
            }
        }
        return -1;
    }
}