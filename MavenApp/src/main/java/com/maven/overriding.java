package com.maven;

class Bank {
    double interest_rate() {
        return 0.0;
    }
}
class SBI extends Bank {
    double interest_rate() {
        return 1.2;
    }
}

class HDFC extends Bank {
    double interest_rate() {
        return 2.6;
    }
}

public class Overriding {
    public static void main(String[] args) {
        Bank b1 = new SBI();
        Bank b2 = new HDFC();

        System.out.println("SBI: " + b1.interest_rate());
        System.out.println("HDFC: " + b2.interest_rate());
    }
}
