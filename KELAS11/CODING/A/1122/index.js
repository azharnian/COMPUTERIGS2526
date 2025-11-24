const readLineSync = require("readline-sync");
const {findAreaCircle, displayMenu} = require("./utils.js");


let userAns = "";
while (true){

    displayMenu();
    userAns = readLineSync.question("Choose option : ");

    if (userAns === "Q" || userAns === "q"){
        console.log("Good bye...");
        break;
    }

}