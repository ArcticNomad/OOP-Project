package com.example.trainmanagementproject.backendClasses.Feedback;

public class Feedback
{
    private String name;
    String description;
    int feedbackNature;
    private int contact;

    public Feedback(String name,String description, int contact, int feedbackNature)
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

    public int getFeedbackNature() {
        return feedbackNature;
    }

    public void setFeedbackNature(int feedbackNature) {
        this.feedbackNature = feedbackNature;
    }
}
