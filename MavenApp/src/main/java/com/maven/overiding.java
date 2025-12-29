//package com.maven;
class Bank {
    double getInterestRate() {
        return 0.0;
    }
}

class SBI extends Bank {
    double getInterestRate() {
        return 6.5;
    }
}

class HDFC extends Bank {
    double getInterestRate() {
        return 7.0;
    }
}

public class overiding {
    public static void main(String[] args) {
        Bank b1 = new SBI();
        Bank b2 = new HDFC();

        System.out.println("SBI:" + b1.getInterestRate());
        System.out.println("HDFC: " + b2.getInterestRate());
    }
}
