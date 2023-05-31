package api.models.launches.put;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class ResponsePutDescription {

    @SerializedName("description") private String description;

    @SerializedName("attributes") private List<AttributesItem> attributes;
}