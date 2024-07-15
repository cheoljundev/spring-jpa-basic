package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            // member.changeTeam(team);
            em.persist(member);

            // 객체지향적 관점, 테스트 코드 작성시 생각해보면 순수 객체 관점에서 양쪽에 넣는 게 맞다.
            // 단, 로직이 복잡해지므로 주인 쪽의 연관관계 편의 메서드를 작성해주자.
            //team.getMembers().add(member)

            team.addMember(member);

//            em.flush();
//            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            Team findTeam = findMember.getTeam();

            List<Member> members = findTeam.getMembers();

            System.out.println("=====================");
            for (Member m : members) {
                System.out.println("m.getUsername() = " + m.getUsername());
            }
            System.out.println("=====================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
