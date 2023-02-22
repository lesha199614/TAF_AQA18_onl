package models;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@NoArgsConstructor
public class Milestone {
    @EqualsAndHashCode.Exclude
    private int id;

    @NonNull
    private String name;
    @SerializedName(value = "references")
    private String refs;
    private String description;
    @SerializedName(value = "is_completed")
    private boolean completed;

}
