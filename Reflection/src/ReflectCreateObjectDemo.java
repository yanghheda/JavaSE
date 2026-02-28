import java.lang.reflect.Constructor;

/**
 * 反射Demo2：通过构造方法创建对象（包括私有构造）
 */
public class ReflectCreateObjectDemo {
    public static void main(String[] args) throws Exception {
        // 1. 获取Class对象
        Class<Student> clazz = Student.class;

        // 2. 调用无参构造创建对象（最常用）
        Student s1 = clazz.newInstance(); // JDK9后标记为过时，推荐用getConstructor().newInstance()
        s1.name = "张三";
        s1.study();

        // 3. 调用public有参构造（如果有的话）
        // Constructor<Student> constructor = clazz.getConstructor(String.class, int.class);
        // Student s2 = constructor.newInstance("李四", 20);

        // 4. 调用私有有参构造（核心：setAccessible(true)打破访问权限）
        Constructor<Student> privateConstructor = clazz.getDeclaredConstructor(String.class, int.class);
        privateConstructor.setAccessible(true); // 取消访问检查（关键）
        Student s3 = privateConstructor.newInstance("王五", 18);
        System.out.println("私有构造创建的对象name：" + s3.name);
    }
}