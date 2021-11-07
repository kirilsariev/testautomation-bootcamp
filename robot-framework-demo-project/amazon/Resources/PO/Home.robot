*** Settings ***
Documentation    This is for product amazon specific web tasks
Library    SeleniumLibrary
Resource    ../Variables.robot

*** Variables ***
${HOME_DEALS_TEXT}    Today's Deals

*** Keywords ***
Open website
    go to    ${HOME_PAGE_URL}
    #The below method checks every 0.2 seconds for the text to appear. This is why we say
    #robot framework handles wait by itself. Sort of uses fluent wait here.
    wait until page contains    ${HOME_DEALS_TEXT}