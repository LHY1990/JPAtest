package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        // 얘는 META-INF의 persistence-unit 이름을 가져오면된다
        EntityManagerFactory emf =Persistence.createEntityManagerFactory("hello");
        //여기 까지 한다면 모두 연결이 된것이다. 얘는 딱 한번만 부르면된다.

        EntityManager em= emf.createEntityManager();

        EntityTransaction tx =em.getTransaction();
        tx.begin();

        Member member = new Member();
        member.setId(2L);
        member.setName("helloB");


        em.persist(member);


        tx.commit();
        //모든 작업은 트랜젝션 안에서 작업해야한다.




        em.close();

        emf.close();



    }
}
