package hellojpa;

import jakarta.persistence.*;

    @Entity
    public class Member {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "member_id")
        private Long id;

        @Column(name = "name")
        private String username;

//        @Column(name = "team_id")
//        private Long teamId;

        @ManyToOne
        @JoinColumn(name = "TEAM_ID")
        private Team team;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Team getTeam() {
            return team;
        }

        public void setTeam(Team team) {
            this.team = team;
        }
    }
