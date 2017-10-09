# 'make' needs to be installed.
#
# Type make to run it.

# This is the path to your src directory.
# Example: java/src
SRC_DIR=C:\Users\Sarah\Documents\Courses\CS_1632\CS1632_Exercise3\.

# This is the path to your JUnit jars and such.
JUNIT_DIR=./

# This is the path to your test directory.
# Example: java/test
TEST_DIR=./

# Make sure absolute paths are used.
# Generally, it doesn't work if ~/ is used and neither does a *.
CLASS_PATH_COMPILE=.;$(JUNIT_DIR)junit-4.12.jar;$(JUNIT_DIR)hamcrest-core-1.3.jar;$(JUNIT_DIR)mockito-core-1.10.19.jar;$(JUNIT_DIR)objenesis-2.4.jar;$(SRC_DIR)

# The classpath to run.
# Make sure the source directory and test directory are on the path.
CLASS_PATH_RUN=$(JUNIT_DIR)hamcrest-core-1.3.jar;$(CLASS_PATH_COMPILE);$(SRC_DIR);$(TEST_DIR)

# This is the path for the junit test runner.
#
# Would need to add the runner to COMPILE_TARGETS
# if you're wanting to use your own.
RUNNER=org.junit.runner.JUnitCore

# ADD NEW FILES to compile here.
COMPILE_TARGETS=$ *.java

# Testing targets.
# Their directory will be on the Class Path.
TEST_TARGETS=TestRunner


run: build
	java -cp "$(CLASS_PATH_RUN) $(RUNNER)" $(TEST_TARGETS) || true

build:
	javac -cp "$(CLASS_PATH_COMPILE)" $(COMPILE_TARGETS)
