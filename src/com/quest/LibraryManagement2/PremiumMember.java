package com.quest.LibraryManagement2;

class PremiumMember extends Member {
    private final int extraPrivileges = 5;

    public PremiumMember(String name, String memberId) {
        super(name, memberId, "Premium");
    }

    @Override
    public void borrowBook(Book book) {
        if (borrowedBooks < 10 + extraPrivileges) { //extrs book for premium member = 5
            super.borrowBook(book);
        } else {
            System.out.println("Premium Member borrowing limit reached.");
        }
    }
}

