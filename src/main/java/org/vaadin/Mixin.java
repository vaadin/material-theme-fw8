package org.vaadin;

/**
 * Created by jonte on 16/03/2017.
 */
public class Mixin {

    private String name;
    private String parameters;
    private String description;

    public Mixin(String name,
                 String parameters,
                 String description) {
        this.name = name;
        this.parameters = parameters;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
