package interface_train;

public class Cat implements RunAble, BarkAble {
    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "四条腿轻盈奔跑");
    }

    @Override
    public void bark() {
        System.out.println(name + "喵喵喵叫");
    }
}
