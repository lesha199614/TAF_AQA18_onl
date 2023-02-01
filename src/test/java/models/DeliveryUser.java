package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Builder
@Data
@ToString
@EqualsAndHashCode
public class DeliveryUser {
    public String userName;
    public String lastName;
    public String postalCode;


}
