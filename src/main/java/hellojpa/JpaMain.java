package hellojpa;

import org.hibernate.Criteria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.rmi.server.ExportException;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        // 얘는 META-INF의 persistence-unit 이름을 가져오면된다
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //여기 까지 한다면 모두 연결이 된것이다. 얘는 딱 한번만 부르면된다.단 한번만

        //엔티티 매니저는 쓰레드간에 공유하면 안된다. 쓰고 버린다.
        EntityManager em = emf.createEntityManager();

        //모든 데이터 변경은 트랜젝션 내부에서 실행한다.
        EntityTransaction tx = em.getTransaction();




        //삽입 구현
//        tx.begin();
//        try {
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("helloA");
//
//            em.persist(member);
//            tx.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            //모든 작업은 트랜젝션 안에서 작업해야한다.
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//        emf.close();
//        이렇게 구성하는것이 정석적인 모습이다.


        //업데이트 구현
//        tx.begin();
//        try {
//            Member memberToUpdate = em.find(Member.class, 1L);
//            memberToUpdate.setName("newName"); // 이 경우 jpa가 커밋시점에서 체크해서 persist()를 처리한다.
//            System.out.println("새로운 이름 진행중");
//            tx.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            tx.rollback();
//        } finally {
//            em.close();
//        }


        //조회구현
//        tx.begin();
//        try {
//            Member memberToFind = em.find(Member.class, 1L);
//            System.out.println("조회를 확인합니다.");
//            System.out.println(memberToFind.getId() + ", " + memberToFind.getName());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        } finally {
//            em.close();
//        }


        //삭제구현
//        tx.begin();
//        try {
//            System.out.println("삭제를 확인합니다.");
//            Member memberToDelete = em.find(Member.class, 1L);
//            em.remove(memberToDelete);
//            tx.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            tx.rollback();
//        } finally {
//            em.close();
//        }

        
        //쿼리문으로 리스트 가져오기
//        tx.begin();
//        try{
//            //이 경우 테이블에 쿼리개념이 아니라 객체에 쿼리를 한다는 개념에 가깝다
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1) //시작지점
//                    .setMaxResults(10) //종료지점
//                    .getResultList(); //리스트로 반환
//
//            for(Member member : result){
//                System.out.println(member.getName());
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//
//        }



        //Member와 Team 엮어서 삽입하기
//        tx.begin();
//        try {
//            Team newTeam = new Team();
//            newTeam.setTeamId(3L);
//            newTeam.setName("새로운팀3");
//            em.persist(newTeam);
//
//            Member member = new Member();
//            member.setName("일반회원3");
//            member.setId(3L);
//            member.setTeam(newTeam);
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

//            Member findMember = em.find(Member.class, 2l);
//            List<Member> members = findMember.getTeam().getMembers();
//
//            for(Member m : members){
//                System.out.println(m.getName());
//            }
//
//
//
//            tx.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            //모든 작업은 트랜젝션 안에서 작업해야한다.
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//        emf.close();


//////////////////////////Criteria/////////////////////////////////////
//        tx.begin();
//
//        try{
//            //이런게 있다는것만 알아두자. 운영하는데 어려움이 많아서 망한 스펙느낌
//            //결국 JPQL를 대리로 만들어준다. JPA 공식기능
//            //복잡하고 실용성이 없다
//            //대용으로 오픈소스인 QueryDSL을 권장한다
//
//            //criteria 사용준비
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Member> query = cb.createQuery(Member.class);
//
//            //루트클래스 (조회를 시작할 클래스)
//            Root<Member> m = query.from(Member.class);
//            CriteriaQuery<Member> cq = query.select(m);
//
//            //쿼리생성
//            query.select(m).where(cb.equal(m.get("username"), "kim"));
//            List<Member> resultList=em.createQuery(cq).getResultList();
//
//            //이렇게 sql을 대리로 작성해서 em.createQuery에 넘긴다.
//            //동적 쿼리를 적용할때 좋다.
//
//
//            tx.commit();
//
//        }catch (Exception e){
//            e.printStackTrace();
//            tx.rollback();
//        }finally {
//            em.close();
//        }
//        emf.close();

//////////////////////////Criteria/////////////////////////////////////////

//////////////////////////QueryDSL/////////////////////////////////////
//        https://tecoble.techcourse.co.kr/post/2021-08-08-basic-querydsl/
// jpql빌더 역할이며, 이 경우 JPA의 정식 스펙이 아니고 오픈소스를 연동하는것이다.
//        실무사용을 권장한다.
//        jpql과 거의 1:1 대응된다. 동적쿼리에도 강하다.
//        jpql만 잘하면 이건 금방한다.
//////////////////////////QueryDSL/////////////////////////////////////


//////////////////////////네이티브 sql/////////////////////////////////////
//        String sql = "selelct id,age, team_id, name from member where name='kim'";
//        List<Member> resultList = em.createNamedQuery(sql, Member.class).getResultList()
//이렇게 하면되게 쉬운듯
//        네이티브는 아무래도 안쓰는게 좋겠지 쉽지만
//        일반적으로 jpa는 flush나 commit, query시에 실제 쿼리가 날아가는데,
//          네이티브 sql의 경우에도 자동으로 쿼리가 날아간다.
//////////////////////////네이티브 sql/////////////////////////////////////


//      결론 : JPQL로 작성하고 QueryDSL을 사용하는것을 권장 + mybatis

        //팩토리 종료
//        emf.close();
    }
}
