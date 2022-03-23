package JavaBean;

public class Chengshi {
    private int id;
    private String name;
    private int no;

    public Chengshi(int id, String name, int no) {
        this.id = id;
        this.name = name;
        this.no = no;
    }

    public Chengshi() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Chengshi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
}
