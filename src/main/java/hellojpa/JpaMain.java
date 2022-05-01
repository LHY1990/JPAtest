package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        // 얘는 META-INF의 persistence-unit 이름을 가져오면된다
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //여기 까지 한다면 모두 연결이 된것이다. 얘는 딱 한번만 부르면된다.

        EntityManager em = emf.createEntityManager();

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
//            memberToUpdate.setName("newName");
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

        try {
            System.out.println("삭제를 확인합니다.");
            Member memberToDelete = em.find(Member.class, 1L);
            em.remove(memberToDelete);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }


        //팩토리 종료
        emf.close();
    }
}
