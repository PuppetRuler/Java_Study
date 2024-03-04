package com.spring.iocxml.di;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:Book
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/25 13:01
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String bname;
    private String author;
    private String other;
}
