*** Settings ***
Library    SeleniumLibrary

*** Variables ***
${SIGNIN_SIGNIN_TEXT}    Sign-In
${SIGNIN_CREATE_ACCOUNT_TEXT}    Create your Amazon account

*** Keywords ***
Verify sign page loaded
    page should contain    ${SIGNIN_SIGNIN_TEXT}
    page should contain    ${SIGNIN_CREATE_ACCOUNT_TEXT}