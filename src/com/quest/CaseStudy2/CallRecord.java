package com.quest.CaseStudy2;
import java.io.Serializable;
// Class for a single call record
public class CallRecord implements Serializable {
    private String type;// Type of call: Local, STD, or ISD
    private int duration;// Duration of the call in minutes

    public CallRecord(String type, int duration) {
        this.type = type;
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    @Override //display call record details
    public String toString() {
        return "CallRecord [Type=" + type + ", Duration=" + duration + " mins]";
    }
}


