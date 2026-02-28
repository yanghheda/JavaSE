/**
 * 反射测试的目标类（包含不同权限的属性、方法、构造方法）
 */
public class Student {
    // 不同访问权限的属性
    public String name;
    private int age;
    protected String gender;
    String address; // 默认权限

    // 无参构造
    public Student() {
        System.out.println("无参构造方法被调用");
    }

    // 有参构造
    private Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("私有有参构造被调用：name=" + name + ", age=" + age);
    }

    // 不同访问权限的方法
    public void study() {
        System.out.println(name + "正在学习");
    }

    private String getInfo(String prefix) {
        return prefix + "：姓名=" + name + "，年龄=" + age;
    }

    // getter/setter
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}