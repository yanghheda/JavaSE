import polymorphic.Income;
import polymorphic.RoyaltyIncome;
import polymorphic.SalaryIncome;

void main(String[] args) {

    //多态练习 给一个有工资收入和稿费收入的小伙伴算税:
    Income[] incomes = new Income[] { new Income(3000), new SalaryIncome(7500), new RoyaltyIncome(12000) };
    double total = 0;
    //
    for (Income income : incomes) {
        total = total + income.getTax();
    }
    System.out.println(total);

}