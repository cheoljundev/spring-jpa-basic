package hellojpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "name")
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
//        @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEAM_ID") // N쪽이 주인
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

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

    // == 연관관계 편의 메서드 ==//
    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
