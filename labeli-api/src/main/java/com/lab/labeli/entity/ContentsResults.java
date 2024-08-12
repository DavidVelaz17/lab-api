package com.lab.labeli.entity;

import com.lab.labeli.form.ContentsResultsForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Entity
@Getter
@Table(name = "contents_results")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContentsResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_result_id", nullable = false, unique = true)
    private int contentResultId;

    @Column(name = "result_id", nullable = false)
    private int resultId;

    @Column(name = "content_id", nullable = false)
    private int contentId;

    @Column(name = "result_value", nullable = false)
    private String resultValue;

    public ContentsResults(final ContentsResultsForm form) {
       this.resultId = form.getResultId();
        this.contentId = form.getContentId();
        this.resultValue = form.getResultValue();
    }

    public void updateContentsResults(final ContentsResultsForm form) {
        Optional.ofNullable(form.getResultId()).ifPresent(id -> this.resultId = id);
        Optional.ofNullable(form.getContentId()).ifPresent(id -> this.contentId = id);
        Optional.ofNullable(form.getResultValue()).ifPresent(id -> this.resultValue = id);
    }
}
