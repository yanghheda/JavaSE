package training_object.domain;

public class Designer extends Programmer {
    private double bouns;

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bouns) {
        super(id, name, age, salary, equipment);
        this.bouns = bouns;
    }

    public double getBouns() {
        return bouns;
    }

    public void setBouns(double bouns) {
        this.bouns = bouns;
    }

    @Override
    public String toString() {
        return getDetails() + "\t设计师\t" + getStatus() + "\t" + getBouns() + "\t\t\t" + getEquipment().getDescription();
    }

    public String getDetailsForTeam() {
        return getBasicDetailsForTeam() + "设计师\t" + getBouns();
    }
}
