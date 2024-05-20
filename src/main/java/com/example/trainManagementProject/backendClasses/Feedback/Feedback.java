package com.example.trainManagementProject.backendClasses.Feedback;

public class Feedback
{
    private String name;
    String description;
    String feedbackNature;
    private Long contact;

    public Feedback(String name,String description, Long contact, String feedbackNature)
    {
        setContact(contact);
        setDescription(description);
        setName(name);
        setFeedbackNature(feedbackNature);
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

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public String getFeedbackNature() {
        return feedbackNature;
    }

    public void setFeedbackNature(String feedbackNature) {
        this.feedbackNature = feedbackNature;
    }
}
