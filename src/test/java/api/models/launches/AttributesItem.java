package api.models.launches;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class AttributesItem {

    @SerializedName("value") private String value;

    @SerializedName("key") private String key;
}