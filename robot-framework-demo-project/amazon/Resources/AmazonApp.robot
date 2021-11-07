*** Settings ***
Documentation    This is for product amazon specific web tasks
Resource    ../Resources/PO/Cart.robot
Resource    ../Resources/PO/Home.robot
Resource    ../Resources/PO/ProductDetails.robot
Resource    ../Resources/PO/SearchResults.robot
Resource    ../Resources/PO/Signin.robot
Resource    ../Resources/PO/TopBar.robot


*** Keywords ***
Open website
    Home.Open website

Search for the product
    TopBar.Search for the product
    SearchResults.Verify search completed

Checkout the product
    SearchResults.Click second product from list
    ProductDetails.Wait for buy button to load
    ProductDetails.Checkout the product

Confirm that login is required
    Signin.Verify sign page loaded