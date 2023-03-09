package main;

import switchtobankingfunctions.Gather;

class Main {
    private static Gather bank = new Gather();

    public static void main(String[] args) {
        bank.run();
    }
}