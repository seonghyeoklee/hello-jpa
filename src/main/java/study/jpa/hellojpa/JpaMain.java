package study.jpa.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            Member member = new Member();
//            member.setId(1L);
//            member.setUsername("HelloA");
//
//            em.persist(member);

//            Member findMember = em.find(Member.class, 1L);
//            System.out.println(findMember.getUsername());

//            em.remove(findMember);

//            Member findMember = em.find(Member.class, 1L);
//            findMember.setUsername("HelloJPA");

//            List<Member> members = em.createQuery("select m from Member m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();

            Team team = new Team();
            team.setName("Team1");
            /* 연관관계의 주인만 변경가능 */
//            team.getMembers().add(member);
            em.persist(team);

            Member member = new Member();
            member.setUsername("memberA");
            member.setTeam(team);
            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
