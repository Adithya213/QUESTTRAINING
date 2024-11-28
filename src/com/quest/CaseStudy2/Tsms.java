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
        Subscriber subscriber = findSubscriberById(subscriberId);
        if (subscriber == null || !subscriber.getPlanType().equalsIgnoreCase("Postpaid")) {
            System.out.println("Subscriber is either not found or is not a postpaid user.");
            return;
        }

        List<CallRecord> records = callHistory.get(subscriberId);
        if (records == null || records.isEmpty()) {
            System.out.println("No call history found for Subscriber ID " + subscriberId);
            return;
        }

        double total = 0;
        for (CallRecord record : records) {
            switch (record.getType().toLowerCase()) {
                case "local":
                    total += record.getDuration() * 1;//local - 1/min
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

    @Override
    public void saveData(String filename) {
        try {
            File file = new File(filename);
            System.out.println("File Path: " + file.getAbsolutePath());
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                oos.writeObject(subscribers);// saving subscriber list
                oos.writeObject(callHistory);
                System.out.println("Data saved successfully!");
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @Override
    public void loadData(String filename) {
        try {
            File file = new File(filename);
            System.out.println("File Path: " + file.getAbsolutePath());
            if (!file.exists()) {
                System.out.println("No previous data found. Starting fresh.");
                return;
            }

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                subscribers = (List<Subscriber>) ois.readObject(); //loading subscriber list
                callHistory = (Map<Integer, List<CallRecord>>) ois.readObject();
                System.out.println("Data loaded successfully!");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
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
