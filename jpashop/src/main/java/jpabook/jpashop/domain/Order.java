package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id") // 외래키
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivety_id")
    private Delivery delivery;

    private LocalDateTime orderDate;    // java 8에서는 LocalDateTime을 사용하면 hibernate가 자동으로 처리해줌

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문 상태 [Order, Cancel]
}
