package models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Expose
    private String name;

    @EqualsAndHashCode.Exclude
    private int id;
    @Expose
    private String email;

    @EqualsAndHashCode.Exclude
    private String password;

    @Expose
    @JsonProperty("is_active")
    @SerializedName(value = "is_active")
    private boolean isActive;
    @Expose
    @JsonProperty("is_admin")
    @SerializedName(value = "is_admin")
    private boolean isAdmin;
    @Expose
    @JsonProperty("role_id")
    @SerializedName(value = "role_id")
    private int roleId;
    @Expose
    private String role;

    @EqualsAndHashCode.Exclude
    private String email_notifications;

}
