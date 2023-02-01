package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Builder
@Data
@ToString
@EqualsAndHashCode
public class User {
    public String userName;
    public String password;
}
