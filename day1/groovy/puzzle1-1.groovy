/**
run with:
docker run --rm -v "$PWD":/home/groovy/scripts -w /home/groovy/scripts groovy:latest groovy puzzle1-1.groovy -d
*/

def inputFile = "./day1-input.txt";
def highestTotal = 0, currentTotal = 0;

new File(inputFile).eachLine { line ->
    // if line is blank, update totals
    if (!line) {
        if (currentTotal > highestTotal)  // we found a higher total!
            highestTotal = currentTotal;

        currentTotal = 0;  // reset current total to begin a new group
    }
    else
        currentTotal += line as Integer;  // add to current running total
};

println "Highest total: ${highestTotal}";
