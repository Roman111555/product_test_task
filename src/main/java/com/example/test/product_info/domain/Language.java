package com.example.test.product_info.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "language_name")
    private String lang_name;

    @Column(name = "language_mark")
    private String lang_mark;



}
