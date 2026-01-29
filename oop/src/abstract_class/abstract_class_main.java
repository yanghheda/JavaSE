import abstract_class.Circle;
import abstract_class.Rectangle;
import abstract_class.Shape;


void main() {
    // 抽象类联系
    // 抽象类引用指向子类对象（多态特性）
    Shape circle = new Circle("圆形", 5);
    Shape rectangle = new Rectangle("矩形", 4, 6);

    // 调用通用方法（抽象类定义的showInfo）
    circle.showInfo();    // 输出：图形名称：圆形，面积：78.53981633974483
    rectangle.showInfo(); // 输出：图形名称：矩形，面积：24.0
}
