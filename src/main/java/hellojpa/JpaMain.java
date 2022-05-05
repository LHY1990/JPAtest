package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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


        tx.begin(); //여기까진 공통 아래는 주석제거 후 테스트

        //삽입 구현

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
        //emf.close();
        //이렇게 구성하는것이 정석적인 모습이다.


        //업데이트 구현

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

        try {
            Team newTeam = new Team();
            newTeam.setTeamId(3L);
            newTeam.setName("새로운팀3");
            em.persist(newTeam);

            Member member = new Member();
            member.setName("일반회원3");
            member.setId(3L);
            member.setTeam(newTeam);

            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //모든 작업은 트랜젝션 안에서 작업해야한다.
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();





        //팩토리 종료
//        emf.close();
    }
}
