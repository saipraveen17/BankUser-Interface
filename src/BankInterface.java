public interface BankInterface {

    public int getBalance();

    public String addMoney(int amount);

    public String withdrawMoney(int amount);

    public double calculateInterest(int amount, int duration);


}
