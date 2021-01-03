package com.zwx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author coderZWX
 * @date 2020-12-28 21:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    //库存id
    private Long id;
    //产品id
    private Long productId;
    //总库存
    private Integer total;
    //已用库存
    private Integer used;
    //剩余库存
    private Integer residue;

}
