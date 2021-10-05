@echo %~1

set /p status=<%~1/Avesdo/Resources/status.txt

@echo ##vso[task.setvariable variable=Automation_QA_Execution_Status;isOutput=true]%status%

@echo done