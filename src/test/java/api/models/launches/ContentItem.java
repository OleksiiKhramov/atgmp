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
public class ContentItem {

    @SerializedName("owner") private String owner;

    @SerializedName("metadata") private Object metadata;

    @SerializedName("analysing") private List<Object> analysing;

    @SerializedName("uuid") private String uuid;

    @SerializedName("rerun") private boolean rerun;

    @SerializedName("mode") private String mode;

    @SerializedName("number") private int number;

    @SerializedName("hasRetries") private boolean hasRetries;

    @SerializedName("name") private String name;

    @SerializedName("approximateDuration") private double approximateDuration;

    @SerializedName("share") private boolean share;

    @SerializedName("startTime") private long startTime;

    @SerializedName("attributes") private List<AttributesItem> attributes;

    @SerializedName("id") private int id;

    @SerializedName("endTime") private long endTime;

    @SerializedName("lastModified") private long lastModified;

    @SerializedName("status") private String status;

    @SerializedName("statistics") private Object statistics;

    @SerializedName("description") private String description;
}