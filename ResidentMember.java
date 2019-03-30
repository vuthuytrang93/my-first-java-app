/** 
This class constructs a resident member
@author Trang Vu
*/

public class ResidentMember {
	/**
	Full name of each resident member
	*/
	private String name;

	/**
	The member's room number
	*/
	private int room;
	
	/**
	The member's phone number
	*/
	private String phone;
	
	/**
	The member's membership number
	*/
	private int j= 0;
	private static int memberNum= 9999;
	
	
	/**
	The list of borrowing items
	*/
	private LendingItem[] list = new LendingItem [8];
	private int numberOfItem = 0;

	/**
	Constructor of a resident member
	@param nameIn Full name of each resident member
	@param roomIn The member's room number
	@param phoneIn The member's phone number
	@param memberNumIN The member's membership number
	*/
	public ResidentMember (String nameIn, int roomIn, String phoneIn) {
		name = nameIn;
		room = roomIn;
		phone= phoneIn;
		memberNum++;
	}

	/**
	@return Full name of each resident member
	*/
	public String getName(){return name;}
	/**
	@return  The member's room number
	*/
	public int getRoomNumber(){return room;}
	/**
	@return  The member's phone number
	*/
	public String getPhoneNumber(){return phone;}
	/**
	@return  The memberbership number
	*/
	public int getMembershipNumber(){	
	return memberNum;}

	/**
	@return  The memberbership number
	*/
	public LendingItem[] getSignedOutItems(){
		LendingItem[] copiedList = new LendingItem [numberOfItem];
		for(int i=0; i<numberOfItem-1; i++){
			copiedList[i] = list[i];
		}
		return copiedList;	
	}
	
	/**
	Set the member's phone number
	*/
	public void setPhoneNumber(String newPhoneIn){
	phone = newPhoneIn;}
	
	/**
	Sign out an item
	*/
	public boolean signOut(LendingItem itemIn){
		boolean success=false;
		if (numberOfItem>=8){
			success= false;
		}
		if (numberOfItem<8){
			list[numberOfItem]= itemIn;
			success = true;
			numberOfItem++; 
		}
		return success;
	}

	/**
	Return an item
	*/
	public boolean returnItem(LendingItem itemIn){
		boolean success=false;
		for ( int i=0; i<numberOfItem; i++){
			if(list[i]==itemIn){
			list[i] = list[numberOfItem-1];	
			numberOfItem--;
			success=true;
			break;
			}else{
			success=false;
			}// yeeeee
		}
		return success;
	}
}
			
		
	
	
	

