import java.text.NumberFormat;

/** 
	Test driver class to test the ResidentMember, ShortTermResidentMember 
	and LendingItem classes.
*/
public class LendingLibraryTestDriver {
  public static void main(String[] args) {
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    
    //*********************************************************************************
    
    System.out.println("\n*** Test case #1: Create a Tenant object & test accessors");
    ResidentMember maria = new ResidentMember("Maria Melani", 152,"555-1234");
    System.out.println("Name:     " + maria.getName()
                   + "\nAppt #:   " + maria.getRoomNumber()
                   + "\nPhone:    " + maria.getPhoneNumber()
                   + "\nMember #: " + maria.getMembershipNumber());
    
    LendingItem[] mariasItemList = maria.getSignedOutItems();
    if (mariasItemList.length == 0) {
      System.out.println("Correct result: Maria has zero lending items.");
    }
    else {
      System.out.println(">> ERROR: Maria has more than zero lending items.");
    }
    
    //*********************************************************************************
    
    System.out.println
    	("\n*** Test case #2: Create a ShortTermResidentMember object & test accessors");
    ShortTermResidentMember tommy = new ShortTermResidentMember("Tommy Black",
                                                  				302,
                                                  				"555-4321",
                                                  				"Dec. 15, 2018");
    System.out.println("Name:     " + tommy.getName()
                   + "\nAppt #:   " + tommy.getRoomNumber()
                   + "\nPhone:    " + tommy.getPhoneNumber()
                   + "\nMember #: " + tommy.getMembershipNumber()
                   + "\nDeparts: " + tommy.getDepartureDate());
    
    LendingItem[] tommysItemList = tommy.getSignedOutItems();
    if (tommysItemList.length == 0) {
      System.out.println("Correct result: Tommy has zero lending items.");
    }
    else {
      System.out.println(">> ERROR: Tommy has more than zero lending items.");
    }


    //*********************************************************************************
    
    System.out.println("\n*** Test case #3: Automatically generate a member number");
    ResidentMember testMember = new ResidentMember("Test", 1, "455-1111");
    if (testMember.getMembershipNumber() == 10002) {
      System.out.println("Correct result: 10002 is the correct member number.");
    }
    else {
      System.out.println(">> ERROR: Invalid member number: " + 
                         testMember.getMembershipNumber());
    }
    
    //*********************************************************************************
    
    System.out.println
    	("\n*** Test case #4: Create a LendingItem object & test accessors");
    
    // Create several LendingItem objects and test the first one
    final int MAXITEMS = 8;
    LendingItem[] testItemList = new LendingItem[MAXITEMS + 1];
    String[] testItemDescription = {"Lean In - Sheryl Sandberg - BOOK",
    	"Maclean's - 01/11/2018 - MAGAZINE",
        "Headstrong: 52 Women Who Changed Science and the World - Rachel Swaby - BOOK",
        "The Time Machine - H.G. Wells - BOOK",
        "The Confidence Code - Katty Kay & Claire Shipman - BOOK",
        "The Immortal Life of Henrietta Lacks - Rebecca Skloot - BOOK",
        "Grit - Angela Duckworth - BOOK",
        "Yoga Journal - October 2018 - MAGAZINE",
        "Wild - Cheryl Strayed - BOOK"};
    for (int i=0; i<=MAXITEMS; i++) {
      testItemList[i] = new LendingItem(testItemDescription[i],
                                        10.00 + (i * 0.25),     // Made-up prices
                                        (i%2) == 0);   // Every 2nd item is recommended
    } // end for loop
    
    System.out.println("Description: " + testItemList[0].getDescription()
                + "\nOrig. Price: " + formatter.format(testItemList[0].getPrice())
                + "\nBook Club Recommended:  " + testItemList[0].isBookClubRecommended());
    
    //*********************************************************************************

    System.out.println("\n*** Test case #5: Change phone number for both Resident types");
    String testPhone1 = "555-5566";
    String testPhone2 = "555-1212";
    maria.setPhoneNumber(testPhone1);
    tommy.setPhoneNumber(testPhone2);

    if (maria.getPhoneNumber().equals(testPhone1)) {
      System.out.println("Correct result: Maria's phone number successfully changed.");
    }
    else {
      System.out.println(">> ERROR: Maria's phone number is incorrect: "
                         + maria.getPhoneNumber());
    }

    if (tommy.getPhoneNumber().equals(testPhone2)) {
      System.out.println("Correct result: Tommy's phone number successfully changed.");
    }
    else {
      System.out.println(">> ERROR: Tommy's phone number is incorrect: "
                         + tommy.getPhoneNumber());
    }
    
    //*********************************************************************************
    
    System.out.println("\n*** Test case #6: Sign out one LendingItem");
    
    if(maria.signOut(testItemList[0])) {
      System.out.println("Correct result: Maria signed out an item successfully.");
      mariasItemList = maria.getSignedOutItems();
      if (mariasItemList.length == 1) {
        System.out.println("Correct result: Maria has one lending item.");
      }
      else {
        System.out.println(">> ERROR: Maria has other than one lending item.");
      }
    }
    else {
      System.out.println(">> ERROR: Maria was unable to sign out an item.");
    }

    //*********************************************************************************
   
    System.out.println("\n*** Test case #7: Sign out multiple LendingItems");
    
    boolean successfulSignOut = true;
    for(int i=1; i<=2; i++) {
      successfulSignOut = successfulSignOut && maria.signOut(testItemList[i]);
    }
    if (successfulSignOut) {
      System.out.println("Correct result: Maria signed out two more items successfully.");
      mariasItemList = maria.getSignedOutItems();
      if (mariasItemList.length == 3) {
        System.out.println("Correct result: Maria has three lending items.");
      }
      else {
        System.out.println(">> ERROR: Maria has other than three lending items.");
      }
    }
    else {
      System.out.println(">> ERROR: Maria was unable to sign out two more items.");
    }
    
    //*********************************************************************************
    
    System.out.println("\n*** Test case #8: Intentionally exceed the sign out limit");
    
    for(int i=3; i<MAXITEMS; i++) {
      maria.signOut(testItemList[i]);
    }
    if (!maria.signOut(testItemList[MAXITEMS])) {
      System.out.println("Correct result: Maria was prevented from signing out more than "
                         + MAXITEMS + " lending items.");
    }
    else {
      System.out.println(">> ERROR: Maria was able to sign out more than "
                         + MAXITEMS + " lending items.");
    }

    //*********************************************************************************
    
    System.out.println
    ("\n*** Test case #9: A short-term resident tries to sign out a recommended item");
    
    LendingItem tommysItem = null;
    
    for(int i=0; i<2; i++) {
      if(tommy.signOut(testItemList[i])) {
        tommysItem = testItemList[i];        // Remember this for Test case #10
        if (testItemList[i].isBookClubRecommended()) {
          System.out.println
          (">> ERROR: Tommy was able to sign out a book club recommended item.");
        }
        else {
          System.out.println
          ("Correct result: Tommy was able to sign out a non recommended item.");
        }
      }
      else {
        if (testItemList[i].isBookClubRecommended()) {
          System.out.println
          ("Correct result: Tommy was prevented from signing out a recommended item.");
        }
        else {
          System.out.println
          (">> ERROR: Tommy was prevented from signing out a non recommended item.");
        }
      }
    }//end for

    //*********************************************************************************
    
    System.out.println
    ("\n*** Test case #10: Returning the only item that was signed out");
    
    int tommyListLength = tommy.getSignedOutItems().length;

    if(tommy.returnItem(tommysItem)) {
      System.out.println("Correct result: Tommy's item was successfully returned.");
    }
    else {
      System.out.println(">> ERROR: Tommy's item was not successfully returned.");
    }

    if(tommy.getSignedOutItems().length == tommyListLength - 1) {
      System.out.println("Correct result: Tommy's list length changed appropriately.");
    }
    else {
      System.out.println(">> ERROR: Tommy's list length did not change appropriately.");
    }


    //*********************************************************************************
    
    System.out.println("\n*** Test case #11: Returning an item that was not signed out");
    
    if(tommy.returnItem(testItemList[3])) {
      System.out.println(">> ERROR: Returned an item that was not signed out.");
    }
    else {
      System.out.println
      ("Correct result: Unsuccessful attempt to return an item that was not signed out.");
    }
	
    //*********************************************************************************
    
    System.out.println
    	("\n*** Test case #12: Returning the first item that was signed out");
    
    int mariaListLength = maria.getSignedOutItems().length;

    if(maria.returnItem(testItemList[0])) {
      System.out.println("Correct result: Maria's first item was successfully returned.");
    }
    else {
      System.out.println(">> ERROR: Maria's first item was not successfully returned.");
    }

    if(maria.getSignedOutItems().length == mariaListLength - 1) {
      System.out.println("Correct result: Maria's list length changed appropriately.");
    }
    else {
      System.out.println(">> ERROR: Maria's list length did not change appropriately.");
    }

    System.out.println
    	("\nConfirm return: Lean In should be absent from the following list:");
    mariasItemList = maria.getSignedOutItems();
    for (int i=0; i < mariasItemList.length; i++) {
      System.out.println(mariasItemList[i].getDescription());
    }


    //*********************************************************************************
    
    System.out.println("\n*** Test case #13: Returning a mid-list item");
    
    mariaListLength = maria.getSignedOutItems().length;

    if(maria.returnItem(testItemList[3])) {
      System.out.println("Correct result: The Time Machine was successfully returned.");
    }
    else {
      System.out.println(">> ERROR: The Time Machine was not successfully returned.");
    }

    if(maria.getSignedOutItems().length == mariaListLength - 1) {
      System.out.println("Correct result: Maria's list length changed appropriately.");
    }
    else {
      System.out.println(">> ERROR: Maria's list length did not change appropriately.");
    }

    System.out.println
    	("\nConfirm return: The Time Machine should be absent from the following list:");
    mariasItemList = maria.getSignedOutItems();
    for (int i=0; i < mariasItemList.length; i++) {
      System.out.println(mariasItemList[i].getDescription());
    }

    //*********************************************************************************
    
    System.out.println("\n************* End of Test Cases ***************\n");
    
  } // end main method


} // end LendingTestDriver class