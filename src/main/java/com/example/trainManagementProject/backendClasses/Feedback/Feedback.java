package com.example.trainManagementProject.backendClasses.Feedback;

public class Feedback
{
    private String name;
    String description;
    String feedbackNature;
    private int contact;

    public Feedback(String name,String description, int contact, String feedbackNature)
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

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getFeedbackNature() {
        return feedbackNature;
    }

    public void setFeedbackNature(String feedbackNature) {
        this.feedbackNature = feedbackNature;
    }
}
