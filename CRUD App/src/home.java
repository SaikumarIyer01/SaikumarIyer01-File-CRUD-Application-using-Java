import java.util.*;
import java.io.File;
import java.io.IOException;

public class home {
	public static void main(String[] args) throws IOException
	{
		System.out.println("Welcome to LockedMe.com. Youre viewing a prototype version designed by Saikumar Iyer.");
    File myDir = new File("MyDocs");
    Scanner s = new Scanner(System.in);
    int option=0;
    
    
    //main menu
    do { System.out.println("||--------------------------------------------Main Menu--------------------------------------------||");

    System.out.println("1.Sort");
    System.out.println("2.Operations");
    System.out.println("3.Exit");
    System.out.print("Enter your selection: ");
    if (s.hasNextInt())
    {
        option = s.nextInt();

    }
    else
    {
        String stri = s.next();

    }

    switch(option) {
    case 1:
    	//sort
    

        File[] filesArray = myDir.listFiles();
        if(filesArray.length==0) {
        	System.out.println("Directory is empty, To add new files go to Operations->Add");
        }
        Arrays.sort(filesArray);
        
        //print the sorted values
        for (File file : filesArray) {
            if (file.isFile()) {
            	System.out.println("File : " + file.getName());
            } 
        }
        
        break;
    case 2:
    	int ch=0;
    	//operations menu

        do{
            System.out.println("----------------------Operations menu----------------------");

           System.out.println("1.Add");
           System.out.println("2.Delete");
           System.out.println("3.Search");
           System.out.println("4.Back to Main Menu");
           System.out.print("Enter your selection: ");
           if (s.hasNextInt())
           {
               ch = s.nextInt();

           }
           else
           {
               String stri = s.next();

           }
           
           
        
        switch(ch) {
        //Creation
        case 1:
       	 System.out.println(">>--------Add File--------<<");
       	 Scanner input = new Scanner(System.in);
            System.out.print("Enter the desired name of your file: ");
            String fileName = input.nextLine();
            fileName = fileName + ".txt";
            
    		
    		if ( myDir.mkdir() ) {
    			System.out.println("A new directory is created");
    		}else {
    			System.out.println("An existing directory is being accessed");
    		}
    		File myFile = new File (myDir,fileName);
    		myFile.createNewFile();
    		System.out.println("Name: " + myFile.getName());
   		System.out.println("Path: "+ myFile.getPath());
         break;
         
         
        case 2:
        	//deletion
       	 boolean del=false;
       	 System.out.println(">>--------Delete File--------<<");
            System.out.println("Enter filename to Delete :");
       	 Scanner in = new Scanner(System.in);

       	 String todel = in.nextLine();
       	 
    
       	 File[] filesArray1 = myDir.listFiles();
       	 for (File file : filesArray1) {
       		 if (file.isFile()) {
       			 if(file.getName().equals(todel))
       			 {
       				 if ( file.delete()) 
       				 {
       						System.out.println(file.getName() + " Deleted");
       						del=true;
       					}
       				 else
       				 {
       						System.out.println("Failed");
       					}
       				 }
       			 }
       		 
       		 }
       	 if(del==false) {
       		 System.out.println("File Not Found");}

       	 break;
        case 3:
        	//search
    	System.out.println(">>--------Search File--------<<");
       	 boolean flag=false;
       	 System.out.println("Enter filename to search :");
       	 Scanner in2 = new Scanner(System.in);

       	 String toFind = in2.nextLine();
       	 
    
       	 File[] filesArray11 = myDir.listFiles();
       	 for (File file : filesArray11) {
       		 if (file.isFile()) {
       			 if(file.getName().equals(toFind))
       			 {
       				 
       						System.out.println(file.getName() + " located");
       						flag=true;
       						break;
       					} 
       			 }
       		 }
       	 if(flag==true) {
       		 break;
       	 }
       	 else {
       	 System.out.println("File not found. Recheck the spelling and try again");
       	 break;
       	 }
        case 4:
        	System.out.println("**Back to Main Menu**");
        	break;
        	

         default:
        	 System.out.println("Input not recognized, try again");
        	 break;
        	 }
        }
        while(ch!=4); 
        break;
        
    case 3:
    	//exit
    	System.out.println("**Application shutting down**");
    	break;
    	
    default:
   	 System.out.println("Input not recognized, try again");
   	 break;
   	 }
    }while(option!=3);
   }
}
