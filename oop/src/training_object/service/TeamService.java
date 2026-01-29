package training_object.service;

import training_object.domain.Architect;
import training_object.domain.Designer;
import training_object.domain.Employee;
import training_object.domain.Programmer;

public class TeamService {
    private static int counter = 1; // 给memberID进行自动赋值的基数

    private final int MAX_MEMBER = 5;  // 表示开发团队最大成员数

    private Programmer[] team = new Programmer[MAX_MEMBER];  // 开发团队的数组

    private int total;

    // 返回当前团队的所有对象
    public Programmer[] getTeam() {
        Programmer[] temp = new Programmer[total];
        for (int i = 0; i < total; i++) {
            temp[i] = this.team[i];
        }
        return temp;
    }

    public void  addMember(Employee e) throws TeamException {
        if(total >= MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
        if(!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }

        Programmer p = (Programmer) e;
        Status status = p.getStatus();
        switch (status) {
            case BUSY:
                throw new TeamException("该员工已是某团队成员");
            case VOCATION:
                throw new TeamException("该员工正在休假，无法添加");
        }

        boolean isExist = isExist(p);
        if(isExist){
            throw new TeamException("该员工已在本开发团队中");
        }

        int progNum = 0, desNum = 0, arcNum = 0;
        for(int i = 0; i < total; i++){
            if(team[i] instanceof Architect) {
                arcNum++;
            }else if(team[i] instanceof Designer){
                desNum++;
            }else {
                progNum++;
            }
        }

        if(p instanceof Architect){
            if(arcNum >= 1) {
                throw new TeamException("团队中至多只有一名架构师");
            }
        } else if(p instanceof Designer){
            if(desNum >= 2) {
                throw new TeamException("团队中至多只有两名设计师");
            }
        } else {
            if(progNum >= 3) {
                throw new TeamException("团队中至多只有三名程序员");
            }
        }

        team[total++] = p;
        p.setMemberId(counter++);
        p.setStatus(Status.BUSY);


    }
    // 判断p是否存在于当前的开发团队中
    private boolean isExist(Programmer p) {
        for (int i = 0; i < total; i++) {
            if(team[i].getId() == p.getId()){
                return true;
            }
        }
        return false;
    }

    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        for(;i < total; i++) {
            if(team[i].getMemberId() == memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if(i == total) {
            throw new TeamException("找不到指定memberId的员工，删除失效");
        }

        for(int j = i; j < total - 1; j++){
            team[j] = team[j+1];
        }

        team[--total] = null;
    }




}
