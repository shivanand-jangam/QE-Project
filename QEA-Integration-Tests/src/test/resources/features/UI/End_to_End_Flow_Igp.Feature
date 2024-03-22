Feature: verify end to end flow of Functionality

Scenarios: verify end to end flow of functions

Given I am on Homepage of IGP
When click  on user profile tap
Then Verify redirected to loginpage
When Enter emailid and password
And Click on login button 
Then Verify loggedin Successfully
When Search flower " flower" in search text field
Then Verify navigated to flower section
And  Select one product "Opulent Orchids Bouquet" 
Then Verify navigated to product page
When Enter invalid pincode
Then Verify received  error message as "We currently do not deliver this product at this location."
When Enter valid pincode 
Then Verify delivery is available "Available" 
When Select Date in calender
When Select the delivary Type
When Select Time Slot in dropdown
When Click on add to cart button
Then Verify overlay should appear which contain addons and button have label "CONTINUE WITHOUT ADDON"
When Click on X Button
And Click on Proceed to cart Button
Then Click should Navigate to shopping cart page
Then  Verify the content
When I click on proceed to checkout Button
Then I should navigate to checkout page
When I fills all delivery details and click on save button
 |firstnameLastName| addressline   | mobilenumber| alternatenumber| emailid             |
 |Vijay Yaligar    | Mukhargi Nagar| 7757900210  | 9096636040     | vijayy8981@gmail.com| 

Then I should Navigate to Header order summery section and verify that section
When I click on proceed to payment Button
Then I should Navigate to payment tab
Then payment tab should contain user delivery details on this page with total product Amount
When I select payment option as Paytm and click on make Payment Button






 











 


