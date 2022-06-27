package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-27 18:52
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
}
