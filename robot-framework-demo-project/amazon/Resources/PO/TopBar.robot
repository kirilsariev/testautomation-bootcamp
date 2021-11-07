*** Settings ***
Library    SeleniumLibrary
Resource    ../Variables.robot

*** Variables ***
${TOPBAR_SEARCH_BOX}    //*[@id="twotabsearchtextbox"]

*** Keywords ***
Search for the product
    Enter search text
    Submit search

Enter search text
    input text    ${TOPBAR_SEARCH_BOX}    ${SEARCH_TERM}

Submit search
    click button    //*[@id="nav-search-submit-button"]

