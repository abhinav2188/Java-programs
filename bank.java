import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

enum type {
    Current, Savings
};

class Account {
    String customerName;
    int accNumber;
    double balance;
    type acctype;

    public void setAccount(String cname, int id, type acctype, double balance) {
        this.customerName = cname;
        this.accNumber = id;
        this.acctype = acctype;
        this.balance = balance;
    }

    public String toString() {
        String output = "Customer name = " + this.customerName + "\naccount Number = " + this.accNumber;
        output += "\nAccount type = " + this.acctype + "\nBalance = " + this.balance;
        return output;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdrawal(double amount) {
        if (this.balance < amount) {
            System.out.println("Insufficient balance ");
            return;
        }
        this.balance -= amount;
    }
}

class CurrentAccount extends Account {
    double minBalance;
    double serviceChargeRate;

    public void setCurrentAccount(String cname, int id, double balance) {
        super.setAccount(cname, id, type.Current, balance);
        this.minBalance = 500.0;
        this.serviceChargeRate = 10;
    }
    public void withdrawal(double amount) {
        super.withdrawal(amount);
        if (this.balance < this.minBalance) {
            System.out.println("Penalty applied due to low balance");
            super.balance -= super.balance * this.serviceChargeRate / 100;
        }
    }
}

class SavingsAccount extends Account {
    double interestRate;

    public void setSavingsAccount(String cname, int id, double balance) {
        super.setAccount(cname, id, type.Savings, balance);
        this.interestRate = 7;
    }

    public double calculateInterest() {
        return this.balance * this.interestRate / 100;
    }

    public void depositInterest() {
        this.balance += this.calculateInterest();
    }
}

class bank {
    public static void main(String args[]) throws IOException {

        SavingsAccount sacc = new SavingsAccount();
        CurrentAccount cacc = new CurrentAccount();
        int id = 100;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter account holder's name ");
        String cname = reader.readLine();
        System.out.print("Enter account type : 1 for Current, 2 for Savings ");
        int typ = Integer.parseInt(reader.readLine());
        System.out.print("Enter initial account balance ");
        double bal = Double.parseDouble(reader.readLine());

        if(typ==1){
            id++;
            cacc.setCurrentAccount(cname, id, bal);
        }else{
            id++;
            sacc.setSavingsAccount(cname, id, bal);
        }

        int opt;
        do{
            System.out.println("Select option ");
            System.out.println("1 : display balance");
            System.out.println("2 : deposit amount");
            System.out.println("3 : withdraw amount");
            if(typ==2){
                System.out.println("4 : calculate interest amount");
                System.out.println("5 : deposit interest amount");
            }
            System.out.println("6 : exit");
            opt = Integer.parseInt(reader.readLine());

            switch(opt){
                case 1 :{
                    if(typ==1)
                    System.out.println("Balance = "+cacc.getBalance());
                    else
                    System.out.println("Balance = "+sacc.getBalance());
                    break;
                }
                case 2:{
                    System.out.println("Enter amount to deposit : ");
                    double amount = Double.parseDouble(reader.readLine());
                    if(typ==1){
                        cacc.deposit(amount);
                        System.out.println("Updated Balance "+cacc.getBalance());
                    }else{
                        sacc.deposit(amount);
                        System.out.println("Updated Balance "+sacc.getBalance());
                    }
                    break;
                }
                case 3:{
                    System.out.println("Enter amount to withdraw : ");
                    double amount = Double.parseDouble(reader.readLine());
                    if(typ==1){
                        cacc.withdrawal(amount);
                        System.out.println("Updated Balance "+cacc.getBalance());
                    }else{
                        sacc.withdrawal(amount);
                        System.out.println("Updated Balance "+sacc.getBalance());
                    }
                    break;
                }
                case 4 :{
                    if(typ==2){
                        System.out.println("Interest Amount  "+sacc.calculateInterest());
                    }
                    break;
                }
                case 5 :{
                    if(typ ==2){
                        sacc.depositInterest();
                        System.out.println("Updated Balance "+sacc.getBalance());
                    }
                    break;
                }
                case 6:{
                    break;
                }
                default:
                System.out.println("Select correct option ");
            }
        }while(opt != 6);
    }
}