package interface_train;

public class Dog implements RunAble, BarkAble {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "四条腿快速奔跑");
    }

    @Override
    public void runDesc() {
        System.out.println(name + "跑起来带风～");
    }

    @Override
    public void bark() {
        System.out.println(name + "汪汪汪叫");
    }
}
