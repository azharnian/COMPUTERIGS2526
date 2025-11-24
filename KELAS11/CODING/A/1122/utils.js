// Modular things
const findAreaCircle = (radius) => {
    return Math.PI * radius * radius;
}

const displayMenu = () => {
    console.log("Welcome to my app");
    console.log("1. Show customer");
    console.log("Q. Quit");
}

module.exports = {
    findAreaCircle,
    displayMenu
}