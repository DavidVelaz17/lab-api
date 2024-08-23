package com.lab.labeli.entity;

import com.lab.labeli.form.ReferencesForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name="reference")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class References {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreferences",nullable = false,unique = true)
    private int referencesId;

    @Column(name = "content_id",nullable = false)
    private int contentId;

    @Column(name = "v_ref_text",nullable = true)
    private String vRefText;

    @Column(name = "v_max",nullable = true)
    private String vMax;

    @Column(name = "v_min",nullable = true)
    private String vMin;

    public References(final ReferencesForm form){
        this.contentId = form.getContentId();
        this.vRefText = form.getVRefText();
        this.vMax = form.getVMax();
        this.vMin = form.getVMin();
    }

}
