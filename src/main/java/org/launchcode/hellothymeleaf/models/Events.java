package org.launchcode.hellothymeleaf.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

//model class
public class Events {
    @NotBlank
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters. Please try again")
    private String name;

    @Size(max = 500, message = "Description is too long. Please keep under 500 characters")
    private String description;

    @NotBlank
    @Email(message = "Invalid email. Please try again.")
    private String contactEmail;

    private int id;
    private static int nextId = 1;

    private EventType type;
    public Events(String name, String description, String contactEmail, EventType type) {
        this();
        this.name = name;
        this.description = description;
        this.id = nextId;
        this.contactEmail = contactEmail;
        this.type = type;
        nextId++;
    }
    public Events(){
        this.id = nextId;
        nextId++;
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

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getId() {
        return id;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return name;
    }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Events events = (Events) o;
        return id == events.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
