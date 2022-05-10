package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

//    @NotEmpty
    private String name;

    @Embedded   // 내장 타입임을 표시
    private Address address;

    @OneToMany(mappedBy = "member")  // 일 대 다, 연관관계 주인 표시
    private List<Order> orders = new ArrayList<>();
}
