package com.lab.labeli.entity;
import com.lab.labeli.convertors.StatusConvertor;
import com.lab.labeli.form.ContentsResultsForm;
import com.lab.labeli.form.CustomerForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Getter
@Table(name = "contents_results")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContentsResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_result_id",nullable = false,unique = true)
    private int contentResultId;

    @Column(name = "result_id",nullable = false,unique = true)
    private int resultId;

    @Column(name = "content_id",nullable = false,unique = true)
    private int contentId;

    @Column(name = "result_value",nullable = false,unique = true)
    private String resultValue;

    public ContentsResults(final ContentsResultsForm form){
        this.contentResultId=form.getContResultId();
        this.resultId=form.getResultId();
        this.contentId=form.getContentId();
        this.resultValue=form.getResultValue();
    }

    public void updateContentsResults(final ContentsResultsForm form){
        this.contentResultId=form.getContResultId();
        this.resultId=form.getResultId();
        this.contentId=form.getContentId();
        this.resultValue=form.getResultValue();
    }


}
