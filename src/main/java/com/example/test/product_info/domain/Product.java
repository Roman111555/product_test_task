package com.example.test.product_info.domain;

import com.example.test.product_info.validation.Price;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Price
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank(message = "Product name can not be empty!")
    @Column(name = "product_name")
    private String productName;

    private String description;

    private Double price;

    @Column(name = "create_date")
    private String createDate;

    @Column(name = "update_date")
    private String updateDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lang_id")
    private Language language;

    @ManyToOne(optional = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "currency_id")
    private Currency currency;

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}
