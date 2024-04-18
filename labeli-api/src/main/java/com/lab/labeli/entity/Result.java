package com.lab.labeli.entity;

import com.lab.labeli.form.ResultForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "results")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idresults",nullable = false,unique = true)
    private int idResults;

    @Column(name = "idcustomers", nullable = false)
    private int idCustomers;

    @Column(name = "idtests", nullable = false)
    private int idTests;

    @Column(name = "result_timestamp", nullable = false)
    private LocalDate resultTimeStamp;

    @Column(name = "result_note", nullable = true)
    private String resultNote;

    public Result (final ResultForm form){
        this.idCustomers=form.getIdCustomers();
        this.idTests=form.getIdTests();
        this.resultTimeStamp=form.getResultTimeStamp();
        this.resultNote=form.getResultNote();
    }

    public void updateResult(final ResultForm form){
        this.resultNote=form.getResultNote();
    }

}
