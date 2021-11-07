*** Variables ***
@{NAME} =  rohit  singh
*** Test Cases ***
Pass arguments
    Print my arguments  rohit  singh
    Print my list arguments  ${NAME}

*** Keywords ***
Print my arguments
    [Arguments]  ${first_name}  ${last_name}
    Log  ${first_name} ${last_name}

Print my list arguments
    [Arguments]  ${NAME}
    Log  ${NAME}[0] ${NAME}[1]

