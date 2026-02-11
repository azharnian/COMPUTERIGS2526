const input = require("readline-sync");
const {showMenu} =require("./menus.js");
const {getUSDtoIDR, getJPYtoIDR} = require("./converters.js");

let userInput, money;
while (true){
    showMenu();
    userInput = input.question("Option : ");
    if (userInput.toLowerCase() == "q") break;
    else if (userInput == "1"){
        money = Number(input.question("Enter USD = "));
        console.log(`${money} USD = ${getUSDtoIDR(money)} IDR`);
    }
    else if (userInput == "2"){
        money = Number(input.question("Enter JPY = "));
        console.log(`${money} JPY = ${getJPYtoIDR(money)} IDR`);
    }
}