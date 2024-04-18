package com.lab.labeli.entity;

import com.lab.labeli.form.OrderTestForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "order_test")
public class OrderTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_test_id", nullable = false, unique = true)
    private int idOrderTest;

    @Column(name = "order_id", nullable = false)
    private int idOrder;

    @Column(name = "test_id", nullable = false)
    private int idTest;

    public OrderTest(final OrderTestForm form) {
        this.idOrder = form.getIdOrder();
        this.idTest = form.getIdTest();
    }

    public void updateOrderTestFunction(final OrderTestForm form) {
        this.idOrder = form.getIdOrder();
        this.idTest = form.getIdTest();
    }

}
