package hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Address address = new Address("city", "street", "12345");
            Member member = new Member();
            member.setUsername("member");
            member.setHomeAddress(address);
            em.persist(member);

            Address newAddress = new Address("newCity", address.getStreet(), address.getZipcode());
            member.setHomeAddress(newAddress); // 불변객체화 시켰기 때문에 이런 식으로 바꿔야 한다.


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

}
