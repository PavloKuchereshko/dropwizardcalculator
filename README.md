# dropwizardcalculator

How to run:
1. After clone do "mvn package".
2. Then "java -jar target/dropwizardtest-1.0-SNAPSHOT.jar server dropwizardtest.yml".

How to use. Example:
1. http://localhost:8085/calculator/add?val=2&val=5 returns 7
2. http://localhost:8085/calculator/multiply?val=2&val=5 returns 10
