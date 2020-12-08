package com.kagura.entity;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2020/7/2
 * @since 1.0.0
 */
public class Person {

    private String name;
    private Integer type;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"type\":")
                .append(type);
        sb.append(",\"age\":")
                .append(age);
        sb.append('}');
        return sb.toString();
    }
}
