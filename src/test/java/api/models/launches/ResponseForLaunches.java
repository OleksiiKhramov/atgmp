package api.models.launches;

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
public class ResponseForLaunches {

    @SerializedName("page") private Object page;

    @SerializedName("content") private List<ContentItem> content;
}