package com.kagura.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/11/30 13:57
 * @since 1.0.0
 */
@Data
public class UserInfo {

    private String name;

    private Integer age;

    private List<String> interests;

    private Map<String, String> tags;


}
