package com.quest.BookstoreInventoryManagement;
// Custom Exception
class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

