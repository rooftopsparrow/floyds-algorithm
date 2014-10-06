JAVAC=javac
FLAGS=-cp
sources=$(wildcard *.java)
classes=$(sources:.java=.class)
tests = $(wildcard *Test.java)
JUNIT=lib/junit.jar
HAMCREST=lib/hamcrest.jar

all: $(classes)

deps:
	mkdir -p lib
	curl http://albertlatacz.published.s3.amazonaws.com/javarepl/javarepl.jar > lib/javarepl.jar
	curl https://repo1.maven.org/maven2/junit/junit/4.11/junit-4.11.jar > lib/junit.jar
	curl https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar > lib/hamcrest.jar

clean:
	rm -f $(classes)

%.class : %.java
	$(JAVAC) $(FLAGS) '.:$(JUNIT)' $<

test: $(classes) 
	java -cp '.:./test:$(JUNIT):$(HAMCREST)' org.junit.runner.JUnitCore $(basename $(tests))

repl:
	java -jar lib/javarepl.jar

.PHONY: test clean repl
