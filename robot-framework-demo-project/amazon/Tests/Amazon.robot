*** Settings ***
Documentation  This is basic info
Resource    ../Resources/AmazonApp.robot
Resource    ../Resources/Common.robot
Test Setup    Common.Begin web test
Test Teardown    Common.End web test
#Also available are the options below
#Suite Setup
#Suite Teardown

*** Test Cases ***
User must be logged in for checkout
    [Tags]    home    search
    AmazonApp.Open website
    AmazonApp.Search for the product
    AmazonApp.Checkout the product
    AmazonApp.Confirm that login is required






