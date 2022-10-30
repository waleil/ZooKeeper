package com.cui.stu.juc.highlevel.completableFuture.thread03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Auther: csx
 * @Date: 2022/8/30 21:45
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Student {
    private Integer id;
    private String studentName;
    private String major;
}
