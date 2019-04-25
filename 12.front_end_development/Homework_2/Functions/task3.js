function even(){
	console.log("Even");
}
function odd(){
	console.log("Odd");
}

function evenOrOdd(even, odd){
	return function checkNum(number){
		if(number % 2 == 0){
			return even;
		}else {
			return odd;
		}
	}
}

let result = evenOrOdd(even, odd)(10);
result();