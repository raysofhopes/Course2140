public class Student {
    int index;
    String name;

    public Student(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return this.name;
    }

    public void setIndex(int newIndex) {
        this.index= newIndex;
    }

    public int getIndex() {
        return this.index;
    }

    public void changeName(String s) {
        this.name = s;
    }
}
