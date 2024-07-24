Aliyah Gouch, Parker Goins, and Moises Valles 
SWE 6673 Term Project 
July 23, 2024
Introduction:
In the realm of software testing, the efficiency and effectiveness of test case execution are paramount. Test Case Prioritization (TCP) techniques aim to sequence test cases such that those with the highest likelihood of detecting faults are executed first. TCP significantly improves the fault detection rate by reducing the cost of regression testing and ensures a more robust software development lifecycle. For this project, we implemented two prominent TCP strategies: the Total Prioritization Strategy and the Additional Prioritization Strategy. 

To demonstrate these techniques, we selected three real-world Java programs from GitHub: a hvac engine, a tic-tac-toe game, and a pizza shop management system. 

The "Chess for Java" program simulates a complete chess-playing environment for two players, including checkmate detection and a chess clock. Developed in the Spring of 2014, the objective was to create and test a bug-free standalone game in Java, complete with a GUI and game logic components. This game was built using core Java, Java Swing GUI libraries, and the jUnit test suite. Testing this program involves ensuring the correctness of various chess rules, move legality, and user interactions.

Additionally, the “Pizza Shop'' program represents a more complex, real-world application with functionalities for order management, inventory tracking, customer interactions, and financial transactions. Testing this system involves validating various aspects such as order processing, inventory updates, customer data management, and report generation.

Lastly, the “Tic-Tac-Toe” program offers a simple yet comprehensive example for testing. This program includes functionalities for player input, game state validation, win/draw detection, and a user interface. Testing covers scenarios such as detecting valid and invalid moves, game outcome determination, and ensuring proper reset of the game board. 
Pizza Shop:
The implementation of the Pizza Shop testing begins with the creation of 30 test cases that cover multiple methods in the program. Methods include testing the creation of pizza objects, adding or removing items, adjusting menu items, and various getters/setters. After the creation of these test cases, the execution order is obtained using Total Prioritization and Additional Prioritization Strategies. Finally evaluating and measuring the effectiveness of the two strategies using Average Percentage of Fault Detected (APFD).
Tic-Tac-Toe:
In the context of implementing test prioritization strategies for the Tic-Tac-Toe application, we begin by developing a comprehensive set of 30 test cases. These test cases are designed to rigorously test various aspects of the program, including the creation of Tic-Tac-Toe objects, player moves, checking game status (win, draw, or ongoing), and various getters and setters. 

Once the test cases are created, we determine the execution order using two distinct strategies: Total Prioritization and Additional Prioritization. Total Prioritization involves sorting the tests based on the total number of code elements covered, prioritizing tests that cover the most elements. Additional Prioritization, on the other hand, focuses on maximizing the additional coverage at each step by selecting tests that cover the most yet-to-be-covered elements.

Finally, we evaluate and measure the effectiveness of these prioritization strategies using the Average Percentage of Faults Detected (APFD). APFD is a metric used to evaluate how quickly a test suite detects faults; a higher APFD indicates that faults are detected earlier in the testing process, which is desirable. By calculating the APFD for both strategies, we can compare their effectiveness and determine which strategy is more efficient in detecting faults early in the test execution. This comprehensive approach ensures a robust evaluation of the Tic-Tac-Toe application, improving the reliability and effectiveness of the test suite.

Hvac Engine: 
Hvac engine is a publicly available repository with hundreds of unit tests. These tests were analyzed using Total Prioritization, as well as Additional Prioritization to determine the execution order. Tests were modified to create intentional failures in the unit tests. The effect of creating a parameterized test wrong can cause many tests down stream to fail in this example just changing the assertion for assertThat(actualDryAirThermalConductivity).isEqualTo(expectedDryAirThermalConductivity-1, withPrecision(accuracy)); caused a chain reaction of downstream failure unit tests. This shows the power of parameterized testing. On the flip side, parameterized testing can show us failures in logic as well, for example by changing the equation for thermal conductivity to include a 9 instead of a 7 will result in nearly the same test cases failing.
Result Analysis:
Results for the 30 Tic-Tac-Toe test as pictured below:

After using Total Prioritization Strategy on Tic-Tac-Toe test, the results and execution order are pictured below:

APFD = 0.9455 or 94.55%.
After using Additional Prioritization on Tic-Tac Toe test, the results and execution order are pictured below: 
APFD = 0.7545or 75.45%
Results for the 30 Pizza Shop tests are pictured below: 
 
After using Total Prioritization Strategy on Pizza Shop test, the results and execution order are pictured below:

APFD = 1 - (2+4+6/30*3) + (1/2*30) = .88 = 88%
After using Additional Prioritization on Pizza Shop test, the results and execution order are pictured below:

APFD = 1 – (0/30*0) + (1/2*30) = 1.00 = 100%
Havoc Engine:
Results: Total Prioritization APFD = APFD = 1 - (8056 / (427 * 42)) + (1 / (2 * 427)) = 55.2%

APFD Additional Prioritization = 1−((8022)/427)*42 + (1/(2x427)) = 55.39

Parameterized test with bug introduced.

3 bugs have been introduced to produce errors. 1 Change can cause 16 errors. 
