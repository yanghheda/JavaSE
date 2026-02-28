import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 反射Demo5：获取类的完整信息（构造、方法、属性、修饰符）
 */
public class ReflectClassInfoDemo {
    public static void main(String[] args) {
        Class<Student> clazz = Student.class;

        // 1. 获取类的基础信息
        System.out.println("=== 类基础信息 ===");
        System.out.println("类名：" + clazz.getName()); // 全类名
        System.out.println("简单类名：" + clazz.getSimpleName());
        System.out.println("父类：" + clazz.getSuperclass().getName());

        // 2. 获取所有构造方法
        System.out.println("\n=== 所有构造方法 ===");
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            // 获取修饰符（如public、private）
            String modifier = Modifier.toString(constructor.getModifiers());
            System.out.print(modifier + " " + constructor.getName() + "(");
            // 获取参数类型
            Class<?>[] paramTypes = constructor.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                System.out.print(paramTypes[i].getSimpleName());
                if (i < paramTypes.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        }

        // 3. 获取所有方法
        System.out.println("\n=== 所有方法 ===");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            String modifier = Modifier.toString(method.getModifiers());
            String returnType = method.getReturnType().getSimpleName();
            System.out.print(modifier + " " + returnType + " " + method.getName() + "(");
            Class<?>[] paramTypes = method.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                System.out.print(paramTypes[i].getSimpleName());
                if (i < paramTypes.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        }

        // 4. 获取所有属性
        System.out.println("\n=== 所有属性 ===");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String modifier = Modifier.toString(field.getModifiers());
            String type = field.getType().getSimpleName();
            System.out.println(modifier + " " + type + " " + field.getName());
        }
    }
}