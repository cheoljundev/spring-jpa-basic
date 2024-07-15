package hellojpa;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // 조인 전략 사용
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 기본적으로 single table 전략 사용
@DiscriminatorColumn
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // 각각 하위 테이블로 내림, 사용 금지
public abstract class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

