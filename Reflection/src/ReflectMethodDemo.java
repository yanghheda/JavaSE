import java.lang.reflect.Method;

/**
 * 反射Demo4：调用方法（包括私有方法）
 */
public class ReflectMethodDemo {
    public static void main(String[] args) throws Exception {
        // 1. 创建对象并获取Class
        Student student = new Student();
        student.name = "孙七";
        Class<? extends Student> clazz = student.getClass();

        // 2. 调用public无参方法
        Method studyMethod = clazz.getMethod("study"); // getMethod获取public方法
        studyMethod.invoke(student); // 执行方法，参数：对象 + 方法参数（无参则不传）

        // 3. 调用private有参方法
        Method getInfoMethod = clazz.getDeclaredMethod("getInfo", String.class); // 需指定参数类型
        getInfoMethod.setAccessible(true); // 取消访问检查
        // invoke返回值：方法的返回结果
        String result = (String) getInfoMethod.invoke(student, "学生信息");
        System.out.println("私有方法返回结果：" + result);

        // 4. 调用setter方法（实战常用）
        System.out.println("\n=== 调用setter设置age ===");
        Method setAgeMethod = clazz.getMethod("setAge", int.class);
        setAgeMethod.invoke(student, 25);
        // 调用getter获取age
        Method getAgeMethod = clazz.getMethod("getAge");
        int age = (int) getAgeMethod.invoke(student);
        System.out.println("通过setter设置后的age：" + age);
    }
}