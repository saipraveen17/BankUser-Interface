import java.util.UUID;

public class ICICIUser implements BankInterface{

    private String name;
    private String accountNumber;
    private int balance;
    private String password;
    private double rateOfInterest;

    public ICICIUser(String name, int balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;
        this.accountNumber = String.valueOf(UUID.randomUUID());
        this.rateOfInterest = 5;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public int getBalance() {

        return this.balance;
    }

    @Override
    public String addMoney(int amount) {

        this.balance += amount;
        return "Amount successfully credited to your account";
    }

    @Override
    public String withdrawMoney(int amount) {

        this.balance -= amount;
        return "Amount successfully debited from your account";
    }

    @Override
    public double calculateInterest(int amount, int duration) {

        double interest = (double)(amount*duration*rateOfInterest)/100;
        return interest;
    }

    public String getname() {

        return this.name;
    }

    public boolean checkAndSetPassword(String oldPassword, String newPassword) {

        if(this.password.equals(oldPassword)) {
            setPassword(newPassword);
            return true;
        }
        else return false;
    }

    private void setPassword(String newPassword) {

        this.password = newPassword;
    }
}
