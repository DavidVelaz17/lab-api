package com.lab.labeli.entity;

import com.lab.labeli.form.OrderForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorders",nullable = false,unique = true)
    private int idOrders;

    @Column(name = "idcustomers", nullable = false)
    private int idCustomers;

    @Column(name = "idusers", nullable = false)
    private int idUsers;

    @Column(name = "order_timestamp", nullable = false)
    private LocalDate orderTimeStamp;

    @Column(name = "order_deposit", nullable = false)
    private double orderDeposit;

    @Column(name = "order_amount_paid", nullable = false)
    private double orderAmountPaid;

    @Column(name = "order_change", nullable = false)
    private double orderChange;

    @Column(name = "order_total", nullable = false)
    private double orderTotal;

    @Column(name = "order_notes", nullable = false)
    private String orderNotes;

    public Order(final OrderForm form){
        this.idCustomers=form.getIdCustomers();
        this.idUsers=form.getIdUsers();
        this.orderTimeStamp=form.getOrderTimeStamp();
        this.orderAmountPaid=form.getOrderAmountPaid();
        this.orderChange=form.getOrderChange();
        this.orderDeposit=form.getOrderDeposit();
        this.orderTotal= form.getOrderTotal();
        this.orderNotes=form.getOrderNotes();
    }

    public void updateOrder(final OrderForm form){
        Optional.ofNullable(form.getOrderDeposit()).ifPresent(deposit->this.orderDeposit=deposit);
        Optional.ofNullable(form.getOrderNotes()).ifPresent(notes->this.orderNotes=notes);
        Optional.ofNullable(form.getOrderDeposit()).ifPresent(deposit->this.orderDeposit=deposit);
        Optional.ofNullable(form.getOrderAmountPaid()).ifPresent(amount->this.orderAmountPaid=amount);
        Optional.ofNullable(form.getOrderChange()).ifPresent(change->this.orderChange=change);

    }

}
