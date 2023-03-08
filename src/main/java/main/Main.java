package main;

import getter.Getter;

class Main {
    private static Getter bank = new Getter();

    public static void main(String[] args) {

        bank.run();
    }
}