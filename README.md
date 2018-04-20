# Zopa Technical Test


## Project specs
Java8
Maven 3


## To run project type:
	mvn package
	mvn exec:java -Dexec.mainClass="io.zopa.loanmanager.App" -Dexec.args="arg0 arg1"


### Example:
	mvn exec:java -Dexec.mainClass="io.zopa.loanmanager.App" -Dexec.args="/myPath/myfile.csv 1000"


## Other way:
	You can generate jar file using maven then call java jar

### Example:
	mvn package
	java -jar zopa-loan-1.0-SNAPSHOT.jar /myPath/myfile.csv 1000
	
## To run test cases:
	mvn test