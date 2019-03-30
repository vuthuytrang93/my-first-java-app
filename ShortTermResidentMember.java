/** 
This class constructs a resident member
@author Trang Vu
*/

public class ShortTermResidentMember extends ResidentMember {

	/**
	Depature date of short term resident
	*/
	String departureDate;
	
	/**
	Constructor of a resident member
	@param nameIn Full name of each resident member
	@param roomIn The member's room number
	@param phoneIn The member's phone number
	@param memberNumIN The member's membership number
	@param dateIn The depature date of short term resident
	*/

	public ShortTermResidentMember (String nameIn, int roomIn, String phoneIn, String dateIn) {
		super (nameIn,roomIn,phoneIn);
		departureDate = dateIn;
	}
	
	/**
	Sign out an item for short term resident member
	*/
	public boolean signOut(LendingItem itemIn){
		boolean success= false;
		if (itemIn.isBookClubRecommended()){
			success = false;
		}else{
			success = super.signOut(itemIn);
		}
		return success;
	}
	/**
	Set the short-term member's depature date 
	*/
	public String getDepartureDate(){
	return departureDate;
	}	
}
			
		
	
	
	

