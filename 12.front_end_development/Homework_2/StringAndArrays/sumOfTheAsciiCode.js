function removeSpecilaSigns(sentence){
    sentence = sentence.replace(/[, ]+/g, '.');
    return sentence;
};

function findSumOfTheWords(arrayOfWords){
    var currentSum = 0;
    var allSum = [];
    arrayOfWords.forEach(element => {
        if (element !== "") {
            for (let i = 0; i < element.length; i++) {
                currentSum = currentSum + element.charCodeAt(i);
            }
            allSum.push(currentSum);
            currentSum = 0;
        }
    });
    allSum.sort((a, b) => a - b);
    return allSum;
};

//var sentence = "12,ds,,,B" //–> 66,99,215
var sentence = "Aa.aA  .b"; //–> 98,162,162 
sentence = removeSpecilaSigns(sentence);
var arr = sentence.split('.');
arr = findSumOfTheWords(arr);