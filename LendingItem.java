/**
This class constructs a book
@author Trang Vu
*/

public class LendingItem {
	/**
	The brief description of each item
	*/
	private final String DESCRIPTION;

	/**
	The original price of the item 
	*/
	private final double PRICE;

	/**
	whether or not it is a book that has been recommended by one of the book clubs on campus
	*/
	private final boolean RECOMMENDATION;

	/**
	Constructor of a lending intem.
	@param descriptionIn The brief description of each item.
	@param priceIn The original price of the item.
	@param recommendedIn Whether or not it is a book that has been recommended by one of the book clubs on campus
	*/
	public LendingItem (String descriptionIn, double priceIn, boolean recommendedIn) {

		DESCRIPTION = descriptionIn;
		PRICE = priceIn;
		RECOMMENDATION = recommendedIn;

	}
	/**
	@return The brief description of each item.
	*/
	// hahahaha
	public String getDescription(){return DESCRIPTION;}
	/**
	@return  The original price of the item.
	*/
	public double getPrice(){return PRICE;}
	/**
	@return Whether or not it is a book that has been recommended by one of the book clubs on campus.
	*/
	public boolean isBookClubRecommended(){return RECOMMENDATION;}


}
