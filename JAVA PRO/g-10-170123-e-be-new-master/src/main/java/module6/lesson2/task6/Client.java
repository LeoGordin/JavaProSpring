package module6.lesson2.task6;

public class Client extends Thread{
    private BankAccount account;
    private String name;


    public Client(BankAccount account, String name){
        this.account = account;
        this.name = name;
    }


    @Override
    public void run() {
        int wantedMoney = 1000;
        System.out.printf("Client %s comes to the ATM%n", name);
        int restMoney = account.getRestMoney();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }
        if(restMoney>=wantedMoney){
            System.out.printf("Client %s can withdraw the wanted money%n", name);
            account.withdrawMoney(wantedMoney);
        }else{
            System.out.printf("There is not enough money for the Client %s%n", name);
        }
    }
}
