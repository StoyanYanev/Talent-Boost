let cat = {
	sound: "Meow",
	makeSound:function(){
		console.log(this.sound);
	}
};

let dog = {
	sound: "Woof",
	makeSound:function(){
		console.log(this.sound);
	}
};

dog.makeSound.call(cat);
let catMakeSound = cat.makeSound.bind(dog);
catMakeSound();