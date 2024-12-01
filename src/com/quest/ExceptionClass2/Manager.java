package com.quest.ExceptionClass2;

class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int age, double salary, int teamSize) throws InvalidInputException {
        super(name, age, salary);
        validateTeamSize(teamSize);
        this.teamSize = teamSize;
    }

    // method for team size validation
    private void validateTeamSize(int teamSize) {
        if (teamSize < 1) {
            throw new IllegalArgumentException("Team size must be greater than zero.");
        }
    }

    public int getTeamSize() {
        return teamSize;
    }
    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
    @Override
    public String toString() {
        return "Manager [Team Size: " + teamSize + "]";
    }
}
