const username : string = "Patrick"

console.log(`Hello, ${username}`)

const height : number = 100
const width : number = 100

const box : HTMLDivElement = document.createElement("div");
box.style.height = `${height}px`
box.style.width = `${width}px`
box.style.backgroundColor = "salmon"

document.body.append(box);