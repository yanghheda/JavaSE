import java.lang.reflect.Field;

/**
 * 反射Demo3：获取和修改属性（包括私有属性）
 */
public class ReflectFieldDemo {
    public static void main(String[] args) throws Exception {
        // 1. 创建对象并获取Class
        Student student = new Student();
        Class<? extends Student> clazz = student.getClass();

        // 2. 获取public属性并修改
        Field nameField = clazz.getField("name"); // getField只能获取public属性
        nameField.set(student, "赵六"); // 设置属性值
        System.out.println("public属性name：" + nameField.get(student)); // 获取属性值

        // 3. 获取private属性并修改（核心：setAccessible(true)）
        Field ageField = clazz.getDeclaredField("age"); // getDeclaredField获取所有权限的属性
        ageField.setAccessible(true); // 取消访问检查
        ageField.set(student, 22); // 修改私有属性
        System.out.println("private属性age：" + ageField.get(student));

        // 4. 获取所有属性（遍历）
        System.out.println("\n=== 遍历所有属性 ===");
        Field[] allFields = clazz.getDeclaredFields();
        for (Field field : allFields) {
            field.setAccessible(true); // 统一取消访问检查
            System.out.println("属性名：" + field.getName()
                    + "，类型：" + field.getType().getName()
                    + "，值：" + field.get(student));
        }
    }
}