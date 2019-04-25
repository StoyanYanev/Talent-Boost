function isPalindrome(sentence) {
    sentence = sentence.toLowerCase();
    sentence = sentence.replace(/[, ]+/g, '');
    let len = sentence.length;
    for (let i = 0; i < len / 2; i++) {
        if (sentence[i] !== sentence[len - 1 - i]) {
            return false;
        }
    }
    return true;
};

isPalindrome("ABC   dc,,,,ba"); //–> true
//isPalindrome("abcdcba"); //–> true
//isPalindrome("ABCdcba"); //–> true
//isPalindrome("Abbsd"); //–> false