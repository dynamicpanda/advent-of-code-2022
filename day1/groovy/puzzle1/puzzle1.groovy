
def inputFile = "./puzzle-1-input.txt";
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
