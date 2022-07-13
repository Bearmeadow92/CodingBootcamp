class Ninja{
    constructor(name, health, speed = 3, strength = 3){
    this.name = name;
    this.health = health;
    this.speed = speed;
    this.strength = strength;
    }

    sayName() {
        console.log(this.name);
    }

    showStats = ()=>console.log(this.name, this.strength, this.speed, this.health);
    

    drinkSake = ()=> this.health += 10;
        
    
}

class Sensei extends Ninja{
    constructor(name, wisdom = 10, health = 200, speed = 10, strength = 10){
    super(name, health, speed, strength);
    this.wisdom = wisdom;
    }

    speakWisdom(){
        console.log("A wise message");
        this.drinkSake();
    }

}


const sensei1 = new Sensei("Master Roshi");
    sensei1.showStats();
    sensei1.speakWisdom();
    sensei1.showStats();