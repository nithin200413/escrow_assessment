# Flipkart Automation Script 

This project automates the process of searching for Bluetooth speakers on **Flipkart**, applying filters, sorting the results, opening a selected product in a new tab, checking available offers, and attempting to add the product to the cart. If the product is successfully added to cart then take the screenshot of the cart page and if the product is out of stock, “Add to Cart” button is missing or “Add to Cart” button is disabled then print “Product unavailable — could not be added to cart.” and take the screenshot.

##  Features Automated

### Product Search  
- Open **[flipkart.com](https://www.flipkart.com/)**  and search for **"Bluetooth Speakers"** 

### Applying Filters   
- Brand: **boAt**  Rating: **4★ & Above**

### Sorting the products  
- Sorts products by **Price — Low to High**

### Window Handling  
- Clicks on the first product  
- Automatically switches control from the parent window to the newly opened product tab

### Offer Verification  
- Identifies **Available offers** section   
- Prints the count of available offers

### Add to Cart Logic  
- Checks if **Add to Cart** button is enabled  
- Attempts to add the product to the cart  
- Takes screenshots for:
  - Successful Add to Cart
  - Unable to add the product to the cart due to any reasons

## Technologies Used

| Technology | Purpose |
|-----------|---------|
| **Java** | Programming language used |
| **Selenium WebDriver** | Web automation framework |
| **ChromeDriver** | Browser automation driver |


##  How to Run the Script

### 1 Prerequisites
- Java JDK 8 or above  
- Selenium WebDriver JARs  
- ChromeDriver (added to system PATH)  
- Any Java IDE (Eclipse, IntelliJ, VS Code)

### 2️ Steps to Execute
1. Clone the repository:
   ```bash
   git clone https://github.com/nithin200413/escrow_assessment.git
   ```
2. Import the project into your IDE.  
3. Make sure Dependencies are added.  
4. Run the `Flipkart.java` file as a Java Application.  
5. Screenshots will automatically be generated in the **Screenshots** folder.

## Screenshots

Screenshots captured during automation will be saved in:

```
/Screenshots/cart_result.png
/Screenshots/result.png
```

## Key Selenium Concepts Used In the Automation Script

- Locators: XPath  
- Implicit & Explicit Waits  
- Window Handling  
- Conditional Checks  
- WebElement Visibility
- Taking Screenshots using `TakesScreenshot` interface
