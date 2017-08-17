package com.davidrus.movetomars.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Module")
public class ModuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Integer moduleNumber;

    @NotNull
    private String price;

    public ModuleEntity() {
    }

    public ModuleEntity(Integer moduleNumber, String price) {
        this.moduleNumber = moduleNumber;
        this.price = price;
    }

    public Integer getModuleNumber() {
        return moduleNumber;
    }

    public void setModuleNumber(Integer moduleNumber) {
        this.moduleNumber = moduleNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
