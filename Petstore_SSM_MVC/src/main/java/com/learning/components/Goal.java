package com.learning.components;


import java.util.List;

public class Goal {
    private String name;
    private int countOfLegs;

    private List<String> aliases;

    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "name='" + name + '\'' +
                ", countOfLegs=" + countOfLegs +
                ", aliases=" + aliases +
                '}';
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountOfLegs() {
        return countOfLegs;
    }

    public void setCountOfLegs(int countOfLegs) {
        this.countOfLegs = countOfLegs;
    }
}

// Goal g = new Goal();
// g.setCountOfLegs(3);
// g.setName("多利");

