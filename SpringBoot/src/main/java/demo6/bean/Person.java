package demo6.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ConfigurationProperties(prefix = "person")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Person {
    private String userName;
    private Integer age;
    private Boolean online;
    private Date birth;
    private String[] interests;
    private List<String> pet;
    private Set<String> parent;
    private Map<String, Integer> score;
}
