package com.zwx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author coderZWX
 * @date 2020-12-28 21:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 总额度
     */
    private Integer total;

    /**
     * 已用额度
     */
    private Integer used;

    /**
     * 剩余额度
     */
    private Integer residue;
}
