package com.billing.billing_system.service.DateService;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "$id",
        "currentDateTime",
        "utcOffset",
        "isDayLightSavingsTime",
        "dayOfTheWeek",
        "timeZoneName",
        "currentFileTime",
        "ordinalDate",
        "serviceResponse"
})
@Generated("jsonschema2pojo")
public class RemoteDate {

    @JsonProperty("$id")
    public String $id;
    @JsonProperty("currentDateTime")
    public String currentDateTime;
    @JsonProperty("utcOffset")
    public String utcOffset;
    @JsonProperty("isDayLightSavingsTime")
    public Boolean isDayLightSavingsTime;
    @JsonProperty("dayOfTheWeek")
    public String dayOfTheWeek;
    @JsonProperty("timeZoneName")
    public String timeZoneName;
    @JsonProperty("currentFileTime")
    public Long currentFileTime;
    @JsonProperty("ordinalDate")
    public String ordinalDate;
    @JsonProperty("serviceResponse")
    public Object serviceResponse;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
