package com.musala.course.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductListerPage extends BasePage {
    private static final String PRODUCT_PRICE_BY_NAME_XPATH = "//div[@class='inventory_item_name' and text()='%s']//ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']";
    private static final String PRODUCT_BY_NAME_XPATH = "//div[@class='inventory_item_name' and text()='%s']";

    @FindBy(className = "product_label")
    private WebElement productLabel;

    @FindBy(className = "product_sort_container")
    private WebElement productFilterDropdown;

    public ProductListerPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductLabelDisplayed() {
        return productLabel.isDisplayed();
    }

    public void filterProduct(String filterOptionText) {
        Select productList = new Select(productFilterDropdown);
        productList.selectByVisibleText(filterOptionText);
    }

    public boolean isProductPriceCorrect(String productName, String expectedPrice) {
        String formattedProductXpath = String.format(PRODUCT_PRICE_BY_NAME_XPATH, productName);
        WebElement productPrice = driver.findElement(By.xpath(formattedProductXpath));
        String productPriceByName = productPrice.getText();
        log.info("price for product {} is {}", productName, productPriceByName);
        return productPriceByName.equals(expectedPrice);
    }

    public void waitUntilProductLabelIsVisible(int implicitWait) {
        executeOperationWithExplicitWait(20, ExpectedConditions.visibilityOf(productLabel), implicitWait);
    }

    public void clickOnProductByName(String productName) {
        String formattedProductXpath = String.format(PRODUCT_BY_NAME_XPATH, productName);
        driver.findElement(By.xpath(formattedProductXpath)).click();
    }
}
