package com.lab.labeli.entity;

import com.lab.labeli.form.CustomerTestForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "customers_test")
public class CustomerTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcustomers_tests", nullable = false, unique = true)
    private Integer idCustomersTests;

    @Column(name = "idcustomers", nullable = false)
    private Integer idCustumers;

    @Column(name = "idtests", nullable = false)
    private Integer idTest;

    public CustomerTest(final CustomerTestForm formCustomerTest) {
        this.idCustumers = formCustomerTest.getIdCustomer();
        this.idTest = formCustomerTest.getIdTest();
    }

    public void updateCustomerTest(final CustomerTestForm formCustomerTest) {
        this.idCustumers = formCustomerTest.getIdCustomer();
        this.idTest = formCustomerTest.getIdTest();
    }


}
