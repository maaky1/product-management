package com.github.maaky1.product_management.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProductEntity {

    private long idProduk;
    private String namaProduk;
    private double harga;
}
