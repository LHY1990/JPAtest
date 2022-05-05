package hellojpa;

import javax.persistence.*;


//@Table(name="USER") 이 경우 USER 라는 테이블과 연결된다.기본적으로 클래스 이름을 쓴다.
@Entity
public class Member {

    @Id
    private Long id; //javax.persistence가 중요
    //@Column(name="username") 이 경우 name필드는 username 컬럼과 연동
    private String name;

    @JoinColumn(name = "team_id")
    @ManyToOne
    private Team team;
    //여기에 int나 Long형 자료형이 아닌  Team형태의 레퍼런스를 만든다.
    //여기 까지만 구현한 경우 단방향 맵핑이 된다.
    //주어 -> 목적 순으로 이해하면 @ManyToOne을 이해할듯

    public Long getId() {
        return id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
