package inner_class;

import interface_train.RunAble;

public class InnerClassDemo {
    // 外部类私有属性
    private String carName = "特斯拉Model 3";
    // 外部类静态属性
    private static String brand = "特斯拉";

    // 1. 成员内部类：定义在外部类成员位置，依赖外部类实例，可访问外部类所有成员（私有+静态）
    class Engine {
        private String engineType = "纯电动发动机";

        public void showEngine() {
            // 直接访问外部类私有非静态属性
            System.out.println("所属汽车：" + carName);
            // 直接访问外部类私有静态属性
            System.out.println("所属品牌：" + brand);
            System.out.println("发动机类型：" + engineType);
        }
    }

    // 2. 静态内部类：定义在外部类成员位置，加static，不依赖外部类实例，仅能访问外部类静态成员
    static class Wheel {
        private static String wheelType = "防爆轮胎";

        public void showWheel() {
            // 只能访问外部类静态属性，不能访问非静态：System.out.println(carName); 编译报错
            System.out.println("所属品牌：" + brand);
            System.out.println("轮胎类型：" + wheelType);
        }

        // 静态内部类可包含静态方法
        public static void staticShow() {
            System.out.println("静态内部类静态方法：品牌" + brand + "，轮胎" + wheelType);
        }
    }

    // 3. 局部内部类：定义在外部类方法内，仅在方法内有效，可访问外部类成员+方法内局部变量（需final，JDK8+自动隐式final）
    public void showCarPart() {
        String color = "黑色";
        class Light {
            private final String lightType = "LED大灯";

            public void showLight() {
                System.out.println("汽车颜色：" + color);
                System.out.println("汽车品牌：" + brand);
                System.out.println("大灯类型：" + lightType);
            }
        }
        // 方法内创建局部内部类实例并调用方法
        Light light = new Light();
        light.showLight();
    }

    static void main(String[] args) {
        // ====== 测试成员内部类 ======
        // 步骤：先创建外部类实例，再通过外部类实例创建内部类实例
        InnerClassDemo car = new InnerClassDemo();
        InnerClassDemo.Engine engine = car.new Engine();
        engine.showEngine();
        System.out.println("------------------------");

        // ====== 测试静态内部类 ======
        // 步骤：直接通过外部类名创建，无需外部类实例
        InnerClassDemo.Wheel wheel = new InnerClassDemo.Wheel();
        wheel.showWheel();
        // 直接调用静态内部类的静态方法
        InnerClassDemo.Wheel.staticShow();
        System.out.println("------------------------");

        // ====== 测试局部内部类 ======
        car.showCarPart();
        System.out.println("------------------------");

        // ====== 4. 匿名内部类：无类名，临时实现接口/继承抽象类，适合一次性使用 ======
        // 场景：临时实现RunAble接口（复用上面接口Demo的RunAble），无需单独定义实现类
        RunAble carRun = new RunAble() {
            // 重写接口抽象方法
            @Override
            public void run() {
                System.out.println(car.carName + "百公里加速3.3秒，极速奔跑！");
            }
        };
        carRun.run();
        carRun.runDesc();
    }
}
