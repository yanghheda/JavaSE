/**
 * 反射Demo1：获取Class对象的3种方式
 */
public class ReflectGetClassDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        // 方式1：通过类名.class（编译期确定，最常用）
        Class<Student> clazz1 = Student.class;
        System.out.println("方式1：" + clazz1.getName());

        // 方式2：通过对象.getClass()（运行期获取，适合已有对象的场景）
        Student student = new Student();
        Class<? extends Student> clazz2 = student.getClass();
        System.out.println("方式2：" + clazz2.getName());

        // 方式3：通过Class.forName("全类名")（动态加载类，最灵活，框架常用）
        Class<?> clazz3 = Class.forName("Student"); // 注意替换为实际全类名（如com.test.Student）
        System.out.println("方式3：" + clazz3.getName());

        // 验证3种方式获取的是同一个Class对象（JVM中每个类只有一个Class实例）
        System.out.println("clazz1 == clazz2：" + (clazz1 == clazz2));
        System.out.println("clazz1 == clazz3：" + (clazz1 == clazz3));
    }
}