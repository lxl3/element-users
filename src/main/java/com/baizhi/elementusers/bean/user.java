package com.baizhi.elementusers.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class user {
    private String id;
    private String name;
    private String address;
    private String sex;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birt;
}
