package register;

public class bankinfo 
{
      private int AccountID;
      private String AccountName;
      private String Address;
      private int PhoneNumber;
      private int Balance;
      private int Withdraw ;
      public int getAccountID()
      {
    	  return AccountID;
      }
      public void setAccountID(int AccountID)
      {
    	  this.AccountID=AccountID;
      }
      public String AccountName()
      {
    	  return AccountName;
      }
      public void setAccountName(String AccountName)
      {
    	  this.AccountName=AccountName;
      }
      public String Address()
      {
    	  return Address;
      }
      public void setAddress(String Address)
      {
    	  this.Address=Address;
      }
      public int PhoneNumber()
      {
    	  return PhoneNumber;
      }
      public void setPhoneNumber(int PhoneNumber)
      {
    	  this.PhoneNumber=PhoneNumber;
      }
      public int getBalance()
      {
    	  return Balance;
      }    
      public void setBalance(int Balance)
      {
    	  this.Balance =Balance ;
      }
      
      public int getWithdraw ()
      {
    	  return Withdraw ;
      }    
      public void setWithdraw(int Withdraw )
      {
    	  this.Withdraw=Withdraw ;
      }
     
      
}
