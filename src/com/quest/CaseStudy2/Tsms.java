package com.quest.CaseStudy2;
import java.io.*;
import java.util.*;

public class Tsms implements TSMSInterface {
    private List<Subscriber> subscribers = new ArrayList<>();//To store a list of subscribers.
    private Map<Integer, List<CallRecord>> callHistory = new HashMap<>();//key-subId , value - CallRecord objs

    @Override
    public void addSubscriber(Subscriber subscriber) {
        for (Subscriber s : subscribers) {
            if (s.getId() == subscriber.getId()) { //check subID exist or not
                throw new IllegalArgumentException("Subscriber with ID " + subscriber.getId() + " already exists.");
            }
        }
        subscribers.add(subscriber);
    }

    @Override
    public void updateSubscriberBalance(int id, double balance) {
        Subscriber subscriber = findSubscriberById(id);//calling to find subscriber exists
        if (subscriber == null) {
            throw new IllegalArgumentException("Subscriber with ID " + id + " not found.");
        }
        subscriber.setBalance(balance);
    }
    //method to print details of all subscriber
    @Override
    public void listSubscribers() {
        if (subscribers.isEmpty()) {//check subscriber exist in arraylist
            System.out.println("No subscribers found.");
            return;
        }
        for (Subscriber subscriber : subscribers) {
            System.out.println(subscriber);
        }
    }
   //method to record call for specific subscriber
    @Override
    public void logCall(int subscriberId, CallRecord call) {
        if (!call.getType().equalsIgnoreCase("Local") &&
                !call.getType().equalsIgnoreCase("STD") &&
                !call.getType().equalsIgnoreCase("ISD")) {
            throw new IllegalArgumentException("Invalid call type: " + call.getType());
        }

        if (!callHistory.containsKey(subscriberId)) { //if subs has no call history in Map
            callHistory.put(subscriberId, new ArrayList<>()); //then initialize new list for them
        }
        callHistory.get(subscriberId).add(call);// old details+adding new call record
    }

    @Override
    public void viewCallHistory(int subscriberId) {
        List<CallRecord> records = callHistory.get(subscriberId);
        if (records == null || records.isEmpty()) {
            System.out.println("No call history found for Subscriber ID " + subscriberId);
            return;
        }
        for (CallRecord record : records) {
            System.out.println(record);
        }
    }
//method to generate bill
    @Override
    public void generateBill(int subscriberId) {
        Subscriber subscriber = findSubscriberById(subscriberId); //check if sub exist & is a postpaid user
        if (subscriber == null || !subscriber.getPlanType().equalsIgnoreCase("Postpaid")) {
            System.out.println("Subscriber is either not found or is not a postpaid user.");
            return;
        }

        List<CallRecord> records = callHistory.get(subscriberId);//add callhistory to callrecord list
        if (records == null || records.isEmpty()) { //check list empty
            System.out.println("No call history found for Subscriber ID " + subscriberId);
            return;
        }

        double total = 0;
        for (CallRecord record : records) { // iterate through callrecord to generate bill
            switch (record.getType().toLowerCase()) {
                case "local":
                    total += record.getDuration() * 1;//local  1/min
                    break;
                case "std":
                    total += record.getDuration() * 2;//std 2/min
                    break;
                case "isd":
                    total += record.getDuration() * 5;//isd 5/min
                    break;
            }
        }
        System.out.println("Total Bill for Subscriber ID " + subscriberId + ": ₹" + total);
    }
//method to save datas to file
    @Override
    public void saveData(String filename) {
        File file = new File(filename);//Create a File object with the given filename
        System.out.println("File Path: " + file.getAbsolutePath());

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));// initialize oos to writing data to file
            oos.writeObject(subscribers); // serialize & write list of sub to file
            oos.writeObject(callHistory); //serialize & write callhistory map to file
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    System.out.println("Error closing output stream: " + e.getMessage());
                }
            }
        }
    }

//method to load datas to file
    @Override
    public void loadData(String filename) {
        File file = new File(filename);
        System.out.println("File Path: " + file.getAbsolutePath());

        if (!file.exists()) {
            System.out.println("No previous data found. Starting fresh.");
            return;
        }

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file)); //Initialize ois to read data from the file
            subscribers = (List<Subscriber>) ois.readObject(); // Load sub list by Deserialize the subscribers list
            callHistory = (Map<Integer, List<CallRecord>>) ois.readObject();//Load call his map by Deserialize call his map
            System.out.println("Data loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    System.out.println("Error closing input stream: " + e.getMessage());
                }
            }
        }
    }


    private Subscriber findSubscriberById(int id) {
        for (Subscriber s : subscribers) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}
