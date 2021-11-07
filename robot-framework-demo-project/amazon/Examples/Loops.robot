*** Variables ***
@{LIST_VARIABLE} =  value one  value two  value three


*** Test Cases ***
Loop over a list of items
    [Tags]    loops
    FOR    ${value}    IN    @{LIST_VARIABLE}
        Log    ${value}
    END


Execute a for loop only two times
    [Tags]    loops
    ${index}=    Set Variable    1
    FOR    ${value}    IN    @{LIST_VARIABLE}
        Exit For Loop If    ${index} > 2
        Log    ${value}
        ${index}=    Evaluate    ${index} + 1
    END

Creating an artificial while loop
    [Tags]    loops
    FOR    ${index}    IN RANGE    9999999
        Log    ${LIST_VARIABLE}[${index}]
        ${index}=    Evaluate    ${index} + 1
        Exit For Loop If    ${index} > 2
    END
    Log    Exited the loop.

