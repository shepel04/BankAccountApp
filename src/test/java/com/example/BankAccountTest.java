package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {

    @Test
    public void testInitialBalance() {
        BankAccount account = new BankAccount(100);
        assertEquals(100, account.getBalance(), 0);
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount(100);
        account.withdraw(50);
        assertEquals(50, account.getBalance(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawMoreThanBalance() {
        BankAccount account = new BankAccount(100);
        account.withdraw(150); // Цей тест має кинути IllegalArgumentException
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNegativeAmount() {
        BankAccount account = new BankAccount(100);
        account.withdraw(-10); // Цей тест має кинути IllegalArgumentException
    }

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        assertEquals(150, account.getBalance(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegativeAmount() {
        BankAccount account = new BankAccount(100);
        account.deposit(-50); // Цей тест має кинути IllegalArgumentException
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeInitialBalance() {
        new BankAccount(-100); // Цей тест має кинути IllegalArgumentException
    }
}
