package hellojpa;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Team {
//    팀 테이블이 id(int), name(varchar20)인 경우
    
    
    @Id
    @Column(name = "team_id")
    private Long teamId;
    private String name;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
