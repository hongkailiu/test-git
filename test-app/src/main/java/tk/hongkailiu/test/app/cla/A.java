package tk.hongkailiu.test.app.cla;

public class A {

    private int i = 3;

    public A(int i) {
        super();
        this.i = i;
    }

    public A() {
        super();
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override public String toString() {
        return "" + i;
    }
}
