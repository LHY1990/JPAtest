package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table able(name="USER") 이 경우 USER 라는 테이블과 연결된다.
public class Member {

    @Id 
    private Long id; //javax.persistence가 중요
    //@Column(name="username") 이 경우 name필드는 username 컬럼과 연동
    private String name;

    public Long getId() {
        return id;
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
