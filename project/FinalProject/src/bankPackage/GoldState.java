package bankPackage;

public class GoldState implements AccountState{
    private final int fee = 10;
    
    public void checkState(AccountInformation account){
        if(account.getAccountBalance() < 10000){
            account.setAccountState(new SilverState());
        }
        else if(account.getAccountBalance() >= 10000 && account.getAccountBalance() < 20000){
            account.setAccountState(this);
        }
        else if(account.getAccountBalance() >= 20000){
            account.setAccountState(new PlatinumState());
        }
    }

    @Override
    public String toString(){
        return "Gold";
    }
    
    @Override
    public int getFee() {
        return fee;
    }
}
