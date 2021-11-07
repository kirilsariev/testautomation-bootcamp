*** Settings ***
Documentation    This is for common web tasks like opening and closing browsers
Library    SeleniumLibrary
Resource    ./Variables.robot

*** Keywords ***
Begin web test
    open browser    about:blank    ${BROWSER}
    maximize browser window

End web test
    close browser