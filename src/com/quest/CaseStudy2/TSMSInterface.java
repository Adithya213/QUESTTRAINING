package com.quest.CaseStudy2;

public interface TSMSInterface {
    void addSubscriber(Subscriber subscriber);
    void updateSubscriberBalance(int id, double balance);
    void listSubscribers();
    void logCall(int subscriberId, CallRecord call); // Record a call for a specific subscriber
    void viewCallHistory(int subscriberId);
    void generateBill(int subscriberId); // Generate a bill for a postpaid subscriber
    void saveData(String filename); // Save data to a file
    void loadData(String filename); // Load data from a file
}



