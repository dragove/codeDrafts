package site.dragove;

class Parent<T extends Parent<T>> {
    private int i;
    private String s;
    @SuppressWarnings("unchecked")
    public T setI(int i) {
        this.i = i;
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    public T setS(String s) {
        this.s = s;
        return (T) this;
    }
    public int getI() {
        return i;
    }
}

class Child extends Parent<Child> {
    private int ci;
    public Child setCi(int ci) {
        this.ci = ci;
        return this;
    }
}

public class SelfType {

    public static void main(String[] args) {
        Child c = new Child();
        c = c.setI(12).setCi(15);
        System.out.println(c.getI());
    }
    
}
