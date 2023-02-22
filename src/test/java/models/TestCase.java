package models;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@NoArgsConstructor
public class TestCase {
    @EqualsAndHashCode.Exclude
    private int id;
    @NonNull
    private String title;
    @NonNull
    @SerializedName(value = "section_id")
    private int sectionId;
    @NonNull
    @SerializedName(value = "template_id")
    private int templateId;
    @NonNull
    @SerializedName(value = "type_id")
    private int typeId;
    @NonNull
    @SerializedName(value = "priority_id")
    private int priorityId;
    @SerializedName(value = "refs")
    private String refs;
    @SerializedName(value = "custom_preconds")
    private String preconditions;
    @SerializedName(value = "custom_steps")
    private String steps;
    @SerializedName(value = "custom_expected")
    private String expectedResult;


}
