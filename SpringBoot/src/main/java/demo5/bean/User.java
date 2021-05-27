package demo5.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@ConfigurationProperties(prefix = "user")
public class User {

    private String name;
    private Integer age;

}
