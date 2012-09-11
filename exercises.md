Exercises
=========

Setup (15 min)
--------------

0. Set up the "smarter-testing-with-spock" project
   a. Clone git@github.com:spockframework/smarter-testing-with-spock.git. Or, if you don't have Git installed, download and extract the zipball from https://github.com/spockframework/smarter-testing-with-spock (look out for the 'ZIP' button).
   b. Open a console and cd into the project directory. Execute `./gradlew build` (Windows: `gradlew build`). If the build passes, you are all set. If it fails, speak up. :-)
   c. (optional) Generate an IDEA project with `./gradlew idea` (Windows: `gradlew idea`). Open the project in IDEA.
   d. (optional) Generate an Eclipse project with `./gradlew eclipse` (Windows: `gradlew eclipse`). Import the project into Eclipse ("Import -> Existing Projects Into Workspace"). Note: For this to work, you need to have Groovy-Eclipse installed, including its Groovy 2.0 compiler support. For installation instructions, visit http://groovy.codehaus.org/Eclipse+Plugin.

State Based Testing (15 min)
----------------------------

1. Write a spec for the `java.util.Stack` class
   a. Name the spec `StackSpec.groovy`
   b. Experiment with different ways of setting up the Stack class (field initializer, `setup()` method, implicit/explicit `setup:` block)
   c. Use self-explaining method names
   d. Consider a few different initial states (empty stack, stack with single element, stack with multiple elements). If you like, use a separate spec per initial state. Note that you can have multiple specs in the same file.
   e. Describe a few error conditions. Use the `thrown` method to describe expected exceptions.
   f. Use the `old` method to describe how an operation changes the contents of the stack.
   g. Change one of the spec methods to use given-when-then style. Annotate the blocks with descriptions (e.g. `when: "an element is added"`).
   h. Experiment with a @Shared stack.

Data Driven Testing (15 min)
----------------------------

2. Enhance StackSpec by using data-driven testing for some of its methods
  a. Try to cover additional interesting cases that you didn't cover in 1.
  b. Use data pipes to provide the data.
  c. Refactor the data pipes to a data table. Use || to set apart inputs and outputs.
  d. Put @Unroll on a method/class to see which iteration(s) fail.
  e. Add an @Unroll naming pattern to see which inputs made the test fail.
  f. Write a test that generates data instead of hardcoding it in a data table.

Interaction Based Testing (15 min)
----------------------------------

3. CodeMaker Workshop

  a. Fill in the methods in `exercise/CodeMakerSpec.groovy` and describe the interactions between a `CodeMaker` (the class under specification) and a `Workshop` (the collaborator). The latter classes are declared in `exercise/CodeMaker.groovy`. 
  b. Introduce a few bugs into how `CodeMaker` interacts with `Workshop`. Execute the spec and study the failure messages.

Extensions (15 min)
-------------------

4. Experiment with some of Spock's built-in extensions
  a. Use @Ignore to ignore a single method/class.
  b. Use @IgnoreRest to ignore all but the annotated methods.
  c. Try @Ignore and @IgnoreRest together with spec inheritance (e.g. ignore a method in a base class).
  d. Write a test that sleeps for a while and give it a (shorter) `@Timeout`. Observe how the test gets stopped after the timeout has elapsed. Modify the test so that it swallows the first few `java.lang.InterruptedException`s and keeps sleeping. Observe how it eventually gets stopped. Verify that methods with a `@Timeout` annotation run in the same thread as methods without such an annotation.
  e. Write a class whose `close()` method throws an exception. Create two instance in the spec and annotate them with `@AutoCleanup`. Verify that `close()` gets called for both of them. Rename `close()` to `dispose()` and adapt `@AutoCleanup` accordingly.
  f. Write a spec whose methods simulate testing the individual parts of a workflow (e.g. "user logs in", "user adds item to shopping cart", etc.). It's good enough if the methods print out what their part is. Annotate the spec with @Stepwise. Observe that the methods gets exercised in the declared order. Try to run just a single method (don't choose the first one).

Other Stuff (15 min)
--------------------

5. Experiment with Spock's configuration options
  a. Create `.spock/SpockConfig.groovy` in your user home directory
  b. Configure Spock *not* to filter stack traces
  c. Create a few annotations and tag some spec methods/classes with them. Try to include/exclude the tagged methods/classes.
  d. Write a spec containing methods that always pass, always fail, and sometimes fail. Some of the methods should take some time to complete. Enable `optimizeRunOrder` and observe how Spock varies the run order of methods over time.

6. Experiment with the spock-example project
  a. Clone git@github.com:spockframework/spock-example.git or download and extract its zipball from https://github.com/spockframework/spock-example (look out for the "ZIP" button)
  b. Take a look at the Gradle, Maven, and Ant builds and experiment with them

7. Get familiar with Spock documentation
  a. Browse the old (http://wiki.spockframework.org) and new (http://docs.spockframework.org/en/latest/) Spock documentation