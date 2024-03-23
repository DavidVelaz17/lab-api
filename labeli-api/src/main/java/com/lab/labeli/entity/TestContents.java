package com.lab.labeli.entity;

import com.lab.labeli.form.TestContentsForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tests_contents")
public class TestContents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_content_id", nullable = false, unique = true)
    private int idTestContents;

    @Column(name = "test_id", nullable = false)
    private int testsId;

    @Column(name = "content_id", nullable = false)
    private int contentId;

    public TestContents(final TestContentsForm form){
        this.testsId=form.getTestId();
        this.contentId=form.getContentId();
    }

    public void updateTestContentsFunction(final TestContentsForm form){
        this.testsId=form.getTestId();
        this.contentId=form.getContentId();
    }
}
