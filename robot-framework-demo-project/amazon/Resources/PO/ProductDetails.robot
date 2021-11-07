*** Settings ***
Documentation    This is for product amazon specific web tasks
Library    SeleniumLibrary

*** Variables ***
${PRODUCT_DETAILS_BUY_NOW}    xpath=//*[@id="buy-now-button"]

*** Keywords ***
Wait for buy button to load
    wait until page contains    Buy Now

Checkout the product
    click button    ${PRODUCT_DETAILS_BUY_NOW}