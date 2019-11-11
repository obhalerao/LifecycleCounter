package trap1.bhaleraoomkar.lifecyclecounter;

public class Counter {

    private String name;
    private int count;
    private int totalCount;

    public Counter(String name){
        this.name = name;
        count = 0;
        totalCount = 0;
    }

    public int getCount() {
        return count;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public String getName() {
        return name;
    }

    public void incrCount() {
        this.count++;
    }

    public void incrTotalCount(){
        this.totalCount++;
    }

    public void setCount(int count){ this.count = count; }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setName(String name) {
        this.name = name;
    }
}

