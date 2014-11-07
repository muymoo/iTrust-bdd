## Setup
1. Clone this repo
2. Follow setup instructions here: http://agile.csc.ncsu.edu/iTrust/wiki/doku.php?id=home_deployment_instructions.  
  * You only need to get and setup Tomcat 6.0
  * You'll need to make sure to run DBBuilder.launch and TestDataGenerator.launch - just right click and run in Eclipse (there is really no output for either of these in Eclipse so just check that the Console shows it runs and terminates).
3. Install Eclipse Cucumber plugin: http://cukes.info/cucumber-eclipse/
4. Create a new Eclipse project using iTrust-bdd as the existing location.
5. Right click the iTrust-bdd project and add External Jars to the classpath - add all Tomcat 6.0 jars.  Your iTrust-bdd project should now have no problems (except maybe complaining about Tomcat 7.0 vs 6.0 which doesn't seem to matter).
6. After server has started (and you have verified you can see http://localhost:8080/iTrust/), right click on a feature file -> Run As... -> Cucumber Feature
  * I actually have to go into Run As Configuration and manually choose Cucumber Feature for some reason.

Firefox should launch and the tests are executed.

```
  Scenario: View All of My Providers
    Given LHCP 9000000000, 9000000003, 9000000004 and Patient 2 are in the database
    And Office Visits 902-911 are in the database.
    And Patient 2 has specified that HCP 9000000003 and 9000000004 are DLHCP's for him
    And Patient 2 has authenticated successfully
    When Patient clicks "My Providers" link
    Then The first result is Jason Frankenstein, surgeon, 333 Dark Lane Raleigh NC 27603, 2008-05-01, Is DLHCP

1 Scenarios (1 passed)
6 Steps (6 passed)
0m6.385s
```
