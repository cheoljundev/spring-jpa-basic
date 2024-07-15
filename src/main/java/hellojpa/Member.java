package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

    @Entity
    public class Member {
        @Id
        private Long id;
        @Column(name = "name", insertable = true,
                updatable = true, nullable = true, unique = false, length = 10)
        private String username;
        private Integer age;
        @Enumerated(EnumType.STRING) // 필수로 STRING으로 써야 한다.
        private RoleType roleType;
        @Temporal(TemporalType.TIMESTAMP) // Temporal은 자바8 이상부터는 LocalDate, LocalDateTime등 등장으로 필요없어짐.
        private Date createdDate;
        @Temporal(TemporalType.TIMESTAMP)
        private Date lastModifiedDate;
        @Lob // clob
        private String description;

        @Transient // 매핑하지 않음
        private int temp;

        public Member() {
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public void setRoleType(RoleType roleType) {
            this.roleType = roleType;
        }

        public void setCreatedDate(Date createdDate) {
            this.createdDate = createdDate;
        }

        public void setLastModifiedDate(Date lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setTemp(int temp) {
            this.temp = temp;
        }
    }
