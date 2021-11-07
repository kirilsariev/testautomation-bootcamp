*** Settings ***
Resource  ../Resources/Variables.robot

*** Variables ***
#Varible naming convention
#The below variables are suite level variable
${SCALAR_VARIABLE}  this is a scalar variable
${scalar_variable}  this is a scalar variable in lower case
@{LIST_VARIABLE} =  value one  value two  value three
${HOME_PAGE_URL} =  www.google.com

*** Test Cases ***
Printing scalar variables
  [Tags]    variable
  Set Test Variable  ${test_case_level_variable}   value of the test case level variable
  Set Global Variable  ${GLOBAL_VARIABLE}   value of the global variable
  BuiltIn.Log  ${SCALAR_VARIABLE}
  BuiltIn.Log  ${scalar_variable}
  Log  ${test_case_level_variable}
  Log  ${HOME_PAGE_URL}

Printing global variable in another test case
  [Tags]    variable
   Log  ${GLOBAL_VARIABLE}


Printing a value from a list variable
  [Tags]    variable
# This syntax is deprecated
# Log  @{LIST_VARIABLE}[0]

  Log  ${LIST_VARIABLE}[1]

