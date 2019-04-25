class Animal {
    constructor(name, diet) {
        this.name = name;
        this.diet = diet;
    }
    sleep(hours) {
        console.log("Animal sleeping for %d hours", hours);
    }
    move(movement) {
        console.log("Animal is moved %d", movement);
    }
    eat() {
        console.log("Animal is eating");
    }
}

class Dog extends Animal {
    constructor(name, diet, breed) {
        super(name, diet);
        this.breed = breed;
    }
    bark() {
        console.log("Woof");
    }
}

class Cat extends Animal {
    constructor(name, diet, sound) {
        super(name, diet);
        this.sound = sound;
    }
    makeSound() {
        console.log(this.sound);
    }
}

class Lion extends Cat {
    constructor(name, diet, sound) {
        super(name, diet, sound);
    }
    makeSound() {
        super.makeSound();
    }
}