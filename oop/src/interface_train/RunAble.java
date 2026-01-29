package interface_train;

public interface RunAble {
    void run();

    default void runDesc() {
        System.out.println("动物具备奔跑能力");
    }
}
