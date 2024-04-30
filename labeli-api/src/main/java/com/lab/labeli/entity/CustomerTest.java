package com.lab.labeli.entity;

import com.lab.labeli.convertors.StatusConvertor;
import com.lab.labeli.form.CustomerTestForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "customers_tests")
public class CustomerTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcustomers_tests", nullable = false, unique = true)
    private Integer idCustomersTests;

    @Column(name = "idcustomers", nullable = false)
    private Integer idCustomers;

    @Column(name = "idtests", nullable = false)
    private Integer idTest;

    @Column(name = "test_status", nullable = false)
    @Convert(converter = StatusConvertor.class)
    private Status status;

    public CustomerTest(final CustomerTestForm formCustomerTest) {
        this.idCustomers = formCustomerTest.getIdCustomer();
        this.idTest = formCustomerTest.getIdTest();
        this.status=formCustomerTest.getStatus();
    }

    public void updateCustomerTest(final CustomerTestForm formCustomerTest) {
        this.idCustomers = formCustomerTest.getIdCustomer();
        this.idTest = formCustomerTest.getIdTest();
        this.status=formCustomerTest.getStatus();
    }


}
