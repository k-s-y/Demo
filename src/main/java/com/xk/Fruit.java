package com.xk;

import lombok.Builder;
import lombok.Data;

/**
 * @Author 柯书洋
 * @Date 2024/2/1 16:16
 * @Description
 */
@Data
@Builder
public class Fruit {
    private String name;
    private int price;
    private int wight;
}
