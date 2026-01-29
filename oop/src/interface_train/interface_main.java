import interface_train.Dog;
import interface_train.Cat;
import interface_train.RunAble;
import interface_train.BarkAble;

void main() {
    // 多态：接口引用指向实现类对象
    RunAble dogRun = new Dog("大黄");
    dogRun.run();
    dogRun.runDesc();

    BarkAble dogBark = new Dog("大黄");
    dogBark.bark();
    System.out.println("------------------------");

    RunAble catRun = new Cat("小白");
    catRun.run();
    catRun.runDesc();

    BarkAble catBark = new Cat("小白");
    catBark.bark();
}
