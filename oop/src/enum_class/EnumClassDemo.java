package enum_class;


enum OrderStatus {
    // 枚举实例：必须放在第一行，格式「实例名(构造参数)」，多个用逗号分隔，最后分号
    PENDING_PAY(1, "待支付"),
    PAID(2, "已支付"),
    SHIPPED(3, "已发货"),
    COMPLETED(4, "已完成"),
    CANCELLED(5, "已取消");

    // 枚举类私有属性（和普通类一样，可定义属性/方法）
    private final int code;
    private final String desc;

    // 构造方法：必须是private（默认也是private，可省略），仅在枚举内部创建实例时调用
    OrderStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus getByCode(int code) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("无效的订单状态码：" + code);
    }
}

public class EnumClassDemo {
    static void main(String[] args) {
        // 1. 直接使用枚举实例（唯一，不可变）
        OrderStatus status1 = OrderStatus.PENDING_PAY;
        System.out.println("枚举实例名：" + status1);
        System.out.println("状态码：" + status1.getCode());
        System.out.println("状态描述：" + status1.getDesc());
        System.out.println("------------------------");

        // 2. values()：遍历所有枚举实例
        System.out.println("所有订单状态：");
        for (OrderStatus status : OrderStatus.values()) {
            System.out.println(status.getCode() + " -> " + status.getDesc());
        }
        System.out.println("------------------------");

        // 3. 自定义方法：根据状态码找枚举
        OrderStatus status2 = OrderStatus.getByCode(3);
        System.out.println("状态码3对应的状态：" + status2.getDesc());
        System.out.println("------------------------");

        // 4. switch中使用枚举（比用数字/字符串更安全，不会出现无效值）
        OrderStatus orderStatus = OrderStatus.PAID;
        switch (orderStatus) {
            case PENDING_PAY:
                System.out.println("订单待支付，请尽快付款");
                break;
            case PAID:
                System.out.println("订单已支付，商家正在备货");
                break;
            case SHIPPED:
                System.out.println("订单已发货，请留意物流");
                break;
            case COMPLETED:
                System.out.println("订单已完成，欢迎再次购买");
                break;
            case CANCELLED:
                System.out.println("订单已取消");
                break;
            // 无需default，因为枚举取值固定，不会出现其他情况
        }
    }
}
