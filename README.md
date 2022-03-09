# MKPareto
A simple program for finding Pareto optimal builds for Mario Kart 8 Deluxe.
## Compiling
Git clone this repository and open it as a new Java project in the IDE of your choosing (I use Eclipse). Compile it into an executable .jar file (the main method can be found in the RunPareto.java file) and run it. You could also do this manually without an IDE or download a precompiled jar [here](https://drive.google.com/file/d/1SCz2knnjUGASUfVsKN77rCUg0NtW01nc/view?usp=sharing). *Note: The .jar was compiled with Java 9.*
## Instructions
1. Select two stats that you want to focus on for your Mario Kart build. If you only want to focus on one stat, just ignore the second combo box.
2. Click the generate button to populate the next box with a list of Pareto optimal stat pairs. The first number in a pair is the first stat you selected and the second number is the second stat.
3. Decide on what balance you want between each of these stats and select that pair from the list.
4. Now you will see the next box get populated with a list of all the builds that satisfy the selected stat requirements. Every stat for each of these builds is listed followed by the sum of all the stats. Find a build that suits your needs and use it in your next Mario Kart 8 Deluxe race!
## Known Issues
- The size of the text area where the builds are displayed can be hard to read. Resizing the window will fix this. Let me know if you find a way to fix this, or create a pull request.
