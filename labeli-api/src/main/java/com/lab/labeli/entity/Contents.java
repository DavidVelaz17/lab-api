package com.lab.labeli.entity;

import com.lab.labeli.form.ContentsForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Getter
@Table(name = "contents")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Contents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id",nullable = false,unique = true)
    private int contentId;

    @Column(name = "content_name",nullable = false)
    private String contentName;

    @Column(name = "content_units",nullable = true)
    private String contentUnits;

    public Contents(final ContentsForm form){
        this.contentName=form.getName();
        this.contentUnits=form.getUnits();
    }

    public void updateContents(final ContentsForm form){
        this.contentName=form.getName();
        this.contentUnits= form.getUnits();
    }

}
