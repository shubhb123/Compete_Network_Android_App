package com.example.navbar;

public class eventdataholder {

    String eventname, eventdate, eventtime, contact, deadline, description, reglink, rewards, venue, image;

    public eventdataholder(String eventname, String eventdate,
                           String eventtime, String contact, String deadline, String description,
                           String reglink, String rewards, String venue, String image) {
        this.eventname = eventname;
        this.eventdate = eventdate;
        this.eventtime = eventtime;
        this.contact = contact;
        this.deadline = deadline;
        this.description = description;
        this.reglink = reglink;
        this.rewards = rewards;
        this.venue = venue;
        this.image = image;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getEventdate() {
        return eventdate;
    }

    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }

    public String getEventtime() {
        return eventtime;
    }

    public void setEventtime(String eventtime) {
        this.eventtime = eventtime;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReglink() {
        return reglink;
    }

    public void setReglink(String reglink) {
        this.reglink = reglink;
    }

    public String getRewards() {
        return rewards;
    }

    public void setRewards(String rewards) {
        this.rewards = rewards;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
