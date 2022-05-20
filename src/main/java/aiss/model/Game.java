package aiss.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "console",
    "name",
    "review",
    "score"
})
@Generated("jsonschema2pojo")
public class Game {

    @JsonProperty("id")
    private String id;
    @JsonProperty("console")
    private List<String> console = null;
    @JsonProperty("name")
    private String name;
    @JsonProperty("review")
    private String review;
    @JsonProperty("score")
    private Integer score;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("console")
    public List<String> getConsole() {
        return console;
    }

    @JsonProperty("console")
    public void setConsole(List<String> console) {
        this.console = console;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("review")
    public String getReview() {
        return review;
    }

    @JsonProperty("review")
    public void setReview(String review) {
        this.review = review;
    }

    @JsonProperty("score")
    public Integer getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Integer score) {
        this.score = score;
    }

}
