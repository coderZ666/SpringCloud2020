package com.zwx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author coderZWX
 * @date 2020-11-20 17:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    
    private long id;
    private String serial;
    
}
