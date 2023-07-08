Feature: Add to Cart 

@Regrassion 
Scenario: Add To cart from Product Listing Page 

	
	When  Go to Vape kits listing page 
	And   Add Two Products in Basket 
	And   Delete These Product 
	Then  Validate There is no any product in basket 
	
@Regrassion 
Scenario: Add To cart from Product Discription Page 

	
	When  Go to Vape kits listing page 
	And   Select a Product 
	And   Add product from Product Discription Page 
	Then  Validate Product Should be in The Basket 
 