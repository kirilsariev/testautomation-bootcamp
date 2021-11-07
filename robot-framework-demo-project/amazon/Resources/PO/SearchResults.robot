*** Settings ***
Library    SeleniumLibrary
Resource    ../Variables.robot

*** Variables ***
${SEARCH_RESULTS_SECOND_PRODUCT}    xpath=//*[@data-index=2]//*[@data-image-index=2]

*** Keywords ***
Verify search completed
    wait until page contains    results for "${SEARCH_TERM}"

Click second product from list
    click element   ${SEARCH_RESULTS_SECOND_PRODUCT}