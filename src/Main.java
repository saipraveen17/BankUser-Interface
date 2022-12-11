import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String,SBIUser> accountMapping = new HashMap<>();   //Map to store userId with account number mapping.

        //user1         Will create a new account with name as user1
        System.out.println("Please enter name and opening balance and password to create an account");

        String name = sc.nextLine();
        int openingBalance = sc.nextInt();
        sc.nextLine();
        String password = sc.nextLine();

        SBIUser user1 = new SBIUser(name,openingBalance,password);
        accountMapping.put(user1.getAccountNumber(), user1);

        System.out.println("Account successfully created"+"\n"+"Account Details"+"\n"+
                "Name: "+name+"\n"+"Account Number: "+user1.getAccountNumber()+"\n"+"Current Balance: "+user1.getBalance());

        //user2         Will create a new account with name as user2
        System.out.println("Please enter name and opening balance and password to create an account");

        String name2 = sc.nextLine();
        int openingBalance2 = sc.nextInt();
        sc.nextLine();
        String password2 = sc.nextLine();

        SBIUser user2 = new SBIUser(name2,openingBalance2,password2);
        accountMapping.put(user2.getAccountNumber(), user2);

        System.out.println("Account successfully created"+"\n"+"Account Details"+"\n"+
                "Name: "+name2+"\n"+"Account Number: "+user2.getAccountNumber()+"\n"+"Current Balance: "+user2.getBalance());


        //After creating account, will be able to see the banking services.
        while(true) {
            System.out.println("Enter 0 to exit or 1 to proceed to enter the account number");
            int entry = sc.nextInt();
            if(entry==0) break;

            sc.nextLine();
            System.out.println("Enter Account Number to see the banking services");
            String accountNumber = sc.nextLine();
            SBIUser user = accountMapping.get(accountNumber);


            while(true) {

                System.out.println("1. Account Details"+"\n"+"2. Check Balance"+"\n"+"3. Withdraw Balance"+"\n"+"4. Deposit Money"+
                        "\n"+"5. Interest Calculator"+"\n"+"6. Fund Transfer"+"\n"+"7. Change Password"+"\n"+"8. Exit");
                System.out.println("Press the Key to choose the service required");

                int key = sc.nextInt();

                if(key==1) {

                    System.out.println("Account Details"+"\n"+
                            "Name: "+user.getname()+"\n"+"Account Number: "+user.getAccountNumber()+"\n"+"Current Balance: "+user.getBalance());
                    System.out.println("Enter any key to go back");
                    sc.nextInt();
                    continue;
                }

                if(key==2) {

                    System.out.println("Current Balance: "+user.getBalance());
                    System.out.println("Enter any key to go back");
                    sc.nextInt();
                    continue;
                }

                if(key==3) {

                    System.out.println("Enter the amount");
                    int withdrawalAmount = sc.nextInt();
                    System.out.println(user.withdrawMoney(withdrawalAmount));
                    System.out.println("Please collect your cash");
                    System.out.println("Enter any key to go back");
                    sc.nextInt();
                    continue;
                }

                if(key==4) {

                    System.out.println("Enter the amount");
                    int depositAmount = sc.nextInt();
                    System.out.println(user.addMoney(depositAmount));
                    System.out.println("Thank you for visiting :)");
                    System.out.println("Enter any key to go back");
                    sc.nextInt();
                    continue;
                }
                if(key==5) {

                    System.out.println("Enter the amount and duration in years");
                    int amount = sc.nextInt();
                    int duration = sc.nextInt();
                    double interest = user.calculateInterest(amount,duration);
                    System.out.println("Interest you will recieve: "+interest);
                    System.out.println("Enter any key to go back");
                    sc.nextInt();
                    continue;
                }

                if(key==6) {

                    System.out.println("Enter the receiver account number");
                    sc.nextLine();
                    String receiverAccNum = sc.nextLine();

                    if(accountMapping.containsKey(receiverAccNum)) {

                        SBIUser receiver = accountMapping.get(receiverAccNum);
                        System.out.println("Please enter the amount to transfer");
                        int transferAmount = sc.nextInt();
                        user.withdrawMoney(transferAmount);
                        receiver.addMoney(transferAmount);
                        System.out.println("Money transfered successsfully");
                        System.out.println("Enter any key to go back");
                        sc.nextInt();
                        continue;
                    }
                    else {
                        System.out.println("Entered account number doesn't exist in our records"+"\n"+"Sorry for the inconvenience");
                        System.out.println("Enter any key to go back to services page");
                        sc.nextInt();
                        continue;
                    }
                }

                if(key==7) {

                    System.out.println("Enter the old & new password with space between them");
                    int availableChances = 3;
                    boolean check = false;
                    while(availableChances-->0) {
                        String oldPassword = sc.next();
                        String newPassword = sc.next();
                        if(user.checkAndSetPassword(oldPassword, newPassword)) {
                            check = true;
                            break;
                        }
                        else {
                            System.out.println("Please enter the correct password only "+availableChances+" attempts left");
                            continue;
                        }
                    }
                    if(check) {

                        System.out.println("Password successfully changed");
                        System.out.println("Enter any key to go back");
                        sc.nextInt();
                        continue;
                    }
                    else {
                        System.out.println("Sorry number of attempts exceeded limit :("+"\n"+"Try again later");
                        break;
                    }
                }

                if(key==8) {

                    System.out.println("Thank you for Visiting :)"+"\n"+"Have a nice day");
                    break;
                }

                else {

                    System.out.println("Press the relevant key displayed in the screen");
                    continue;
                }
            }
        }

        sc.close();

    }

}
