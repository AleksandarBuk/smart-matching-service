package com.smartmatch.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Buyer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String industry;
    private String requiredProduct;
}