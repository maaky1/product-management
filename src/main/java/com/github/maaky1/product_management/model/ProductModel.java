package com.github.maaky1.product_management.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProductModel {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long idProduk;
    private String namaProduk;
    private double harga;
}
