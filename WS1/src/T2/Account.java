package T2;

import java.util.Date;


public class Account 
{
    protected int id = 0;
    protected double balance = 0;
    protected static double annualInterestRate = 0;
    protected Date dateCreated;
    
    public Account()
    {
        dateCreated = new Date();
    }
    public Account(int initId, double initBalance)
    {
        dateCreated = new Date();
        id = initId;
        balance = initBalance;
    }
    
    public int getId()
    {
        return id;
    }
    public void setId(int sId)
    {
        id = sId;
    }
    public double getBalance()
    {
        return balance;
    }
    public void setBalance(double sBalance)
    {
        balance = sBalance;
    }
    public static double getAnnualInterestRate()
    {
        return annualInterestRate;
    }
    public static void setAnnualInterestRate(double iRate)
    {
        annualInterestRate = iRate;
    }
    public Date getDateCreated()
    {
        return dateCreated;
    }
    
    public static double getMonthlyInterestRate()
    {
        return annualInterestRate/12;
    }
    public double getMonthlyInterest()
    {
        return balance*getMonthlyInterestRate();
    }
    public void withdraw(double amount)
    {
        balance -= amount;
    }
    public void deposit(double amount)
    {
        balance += amount;
    }
}
