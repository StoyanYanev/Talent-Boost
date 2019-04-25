function sum(a){
	return function sum2(b){
		return a + b;
	}
}

var x = sum(5);
var y = x(10);
console.log(y);