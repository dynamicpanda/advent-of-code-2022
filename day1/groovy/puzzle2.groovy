/**
run with:
docker run --rm -v "$PWD":/home/groovy/scripts -w /home/groovy/scripts groovy:latest groovy puzzle2.groovy -d
*/

def inputFile = "./day1-input.txt";
def currentTotal = 0;
def highestTotals = [];
def NUM_HIGHEST = 3;

new File(inputFile).eachLine { line ->
    // if line is blank, update totals
    if (!line) {
        highestTotals.add(currentTotal);

        // when we get to our max size, start removing the lowest values
        // I know this is inefficient, but for this puzzle I like the simplicity
        if (highestTotals.size() > NUM_HIGHEST)
            highestTotals.remove(highestTotals.indexOf(highestTotals.min()));

        currentTotal = 0;  // reset current total to begin a new group
    }
    else
        currentTotal += line as Integer;  // add to current running total
};

println "Highest total: ${highestTotals.sum()}";
