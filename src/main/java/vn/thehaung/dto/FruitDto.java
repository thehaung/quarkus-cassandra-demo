package vn.thehaung.dto;

/**
 * @author : Hau Nguyen
 * @from : 8/6/22
 **/

public class FruitDto {
    private String name;

    private String description;

    public FruitDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
