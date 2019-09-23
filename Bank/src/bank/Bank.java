package bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class  Bank
{
    public static void main(String args[]) 
    {
        String str;
        int choice;
        choice=0;

        BankWork BW_obj = new BankWork();
        
        do
        {
        	// creating Menu.
        	System.out.println("Choose Your Choices ...");
        	System.out.println("1) New Record Entry ");
        	System.out.println("2) Display Record Details ");
        	System.out.println("3) Deposit...");
        	System.out.println("4) Withdraw...");
        	System.out.println("5) Exit");
        	System.out.print("Enter your choice :  ");
        	System.out.flush();
            try
            {
            	// creating objects.
            	BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
                str=obj.readLine();
                choice=Integer.parseInt(str);

                switch(choice)
                {
                	case 1 :
                		// for new entry.
                		BW_obj.newEntry();
                        break;
                            
                	case 2 :
                		// for display.
                		BW_obj.display();
                        break;
                            
                	case 3 : 
                		// for deposit.
                		BW_obj.deposit();
                        break;
                           
                	case 4 : 
                		// for display.
                        BW_obj.withdraw();
                        break;
                            
                	case 5  :  
                		System.out.println("\n\n.....THANKS FOR VISITING.....");
                        break;
                        
                	default : System.out.println("\nInvalid Choice \n\n");
                }
            }
            catch(Exception e)
            {
            	System.out.println("Exception in Main....");
            }
        }
        while(choice!=5);
    }
}