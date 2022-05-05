package hellojpa;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
//    팀 테이블이 id(int), name(varchar20)인 경우
    
    
    @Id
    @Column(name = "team_id")
    private Long teamId;
    private String name;

    //여기까지 구현해야 양방향이다.
    @OneToMany(mappedBy = "team")
    private List<Member> members= new ArrayList<>();
    //new로 객체를 넣어서 초기화까지가 관례이다.
    //mappedBy의 "team"은 Member 클래스의 team 필드를 말한다. 
    //주어 ->  목적 @OneToMany

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
