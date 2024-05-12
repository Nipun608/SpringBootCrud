package com.spring.pos.entity;

import com.spring.pos.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Item {
    @Id
    @Column(name = "item_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name",length = 100,nullable = false)
    private String customerName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type",length = 100,nullable = false )
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balance_qty",length = 100,nullable = false )
    private double balanceQty;


    @Column(name = "supplier_price",length = 100,nullable = false )
    private double supplierPrice;

    @Column(name = "selling_price",length = 100,nullable = false )
    private double sellingPrice;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean active;

}
