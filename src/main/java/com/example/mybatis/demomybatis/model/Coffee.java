package com.example.mybatis.demomybatis.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coffee {
    private Long id;
    private String name;
    private Date createTime;
    private Date updateTime;
}
