function removeAllLetters(str) {
    str = str.replace(/[a-z]/gi, '');
    return str;
};
function findSum(arr) {
    var sum = 0;
    arr.forEach(element => {
        if (element !== "") {
            sum = sum + parseInt(element);
        }
    });
    return sum;
};

// var str = "asdasd1,asASDAsd" // –> 1
// var str = "asdasdamasdad,,,,asd,a,sd" // –> 0
var str = "1,2a,,,sd,3asd3"; // –> 36
str = removeAllLetters(str);
var arr = str.split(',');
var sum = findSum(arr);
console.log(sum);