package abstract_class;

public abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract double calculateArea();

    public void showInfo() {
        System.out.println("图形名称：" + name + "，面积：" + calculateArea());
    }
}
