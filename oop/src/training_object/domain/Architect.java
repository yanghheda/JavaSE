package training_object.domain;

public class Architect extends Designer {
    private int stock; // 股票

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bouns, int sock) {
        super(id, name, age, salary, equipment, bouns);
        this.stock = sock;
    }

    public int getStock() {
        return stock;
    }

    public void setSock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails() + "\t架构师\t" + getStatus() + "\t" + getBouns() + "\t" + getStock() + "\t" + getEquipment().getDescription();
    }

    public String getDetailsForTeam() {
        return getBasicDetailsForTeam() + "设计师\t" + getBouns() + "\t" + getStock();
    }
}
