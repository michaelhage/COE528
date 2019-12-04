package bankPackage;

public class PlatinumState implements AccountState{
   private final int fee = 0;
    
    @Override
    public void checkState(AccountInformation account){
        if(account.getAccountBalance() < 10000){
            account.setAccountState(new SilverState());
        }
        else if(account.getAccountBalance() >= 10000 && account.getAccountBalance() < 20000){
            account.setAccountState(new GoldState());
        }
        else if(account.getAccountBalance() >= 20000){
            account.setAccountState(this);
        }
    }

    @Override
    public String toString(){
        return "Platinum";
    }
    
    @Override
    public int getFee() {
        return fee;
    }
}
