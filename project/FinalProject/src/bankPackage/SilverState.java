package bankPackage;

public class SilverState implements AccountState{
    
    private final int fee = 20;
    
    @Override
    public void checkState(AccountInformation account){
        if(account.getAccountBalance() < 10000){
            account.setAccountState(this);
        }
        else if(account.getAccountBalance() >= 10000 && account.getAccountBalance() < 20000){
            account.setAccountState(new GoldState());
        }
        else if(account.getAccountBalance() >= 20000){
            account.setAccountState(new PlatinumState());
        }
    }
    
    @Override
    public String toString(){
        return "Silver";
    }
    
    @Override
    public int getFee() {
        return fee;
    }
    
}
