function findTheSumOfEachRow(matrix) {
    var sumOfEachRow = [];
    var currentSum = 0;
    matrix.forEach(element => {
        if (element !== "") {
            var row = element.split(',');
            currentSum = row.reduce((a, b) => parseInt(a) + parseInt(b), 0);
        }
        sumOfEachRow.push(currentSum);
        currentSum = 0;
    });
    sumOfEachRow.sort((a, b) => b - a);
    return sumOfEachRow.join("|");
}

//var matrix = "1,2,3;3,4,5,6;;1,2"; // –> "12|6|3|0"
var matrix = "1,1;2,2,1,2,4;12;"; // –> “12|11|2|0”
var arr = matrix.split(";");
var sum = findTheSumOfEachRow(arr);
console.log(sum);