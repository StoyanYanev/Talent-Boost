function Animal(name, diet) {
    this.name = name;
    this.diet = diet;
}
Animal.prototype.sleep = function sleep(hours) {
    console.log("Animal sleeping for %d hours", hours);
}
Animal.prototype.move = function move(movement) {
    console.log("Animal is moved %d", movement);
}
Animal.prototype.eat = function eat() {
    console.log("Animal is eating");
}

function Dog(name, diet, breed) {
    Animal.call(this, name, diet);
    this.breed = breed;
}
Dog.prototype.bark = function bark() {
    console.log("Woof");
}
Dog.prototype = Object.create(Animal.prototype);

function Cat(name, diet, sound) {
    Animal.call(this, name, diet);
    this.sound = sound;
}
Cat.prototype.makeSound = function makeSound() {
    console.log(this.sound);
}
Cat.prototype = Object.create(Animal.prototype);

let Lion = function (name, diet, sound) {
    Cat.call(this, name, diet, sound);
};
Lion.prototype = Object.create(Cat.prototype);