package com.lab.labeli.entity;

import com.lab.labeli.form.TestForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tests")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtests", nullable = false, unique = true)
    private int idTest;

    @Column(name = "test_name", nullable = false)
    private String testName;

    @Column(name = "test_price", nullable = false)
    private Double testPrice;

    @Column(name = "test_price_with_discount", nullable = false)
    private Double testPriceWithDiscount;

    public Test(final TestForm form) {
        this.testName = form.getTestName();
        this.testPrice = form.getTestPrice();
        this.testPriceWithDiscount = form.getTestPriceWithDiscount();
    }

    public void updateTestFunction(final TestForm form) {
        this.testName = form.getTestName();
        this.testPrice = form.getTestPrice();
        this.testPriceWithDiscount = form.getTestPriceWithDiscount();
    }
}
