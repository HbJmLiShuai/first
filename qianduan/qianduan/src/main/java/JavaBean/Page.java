package JavaBean;

import java.util.List;

public class Page<T> {
    private int totalCount;
    private List<T> row;

    public Page(int totalCount, List<T> row) {
        this.totalCount = totalCount;
        this.row = row;
    }

    public Page() {
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRow() {
        return row;
    }

    public void setRow(List<T> row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "Page{" +
                "totalCount=" + totalCount +
                ", row=" + row +
                '}';
    }
}
