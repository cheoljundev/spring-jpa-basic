package hellojpa;

import jakarta.persistence.*;

    @Entity
    public class Member {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name")
        private String username;

        public Member() {
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setUsername(String username) {
            this.username = username;
        }

    }
