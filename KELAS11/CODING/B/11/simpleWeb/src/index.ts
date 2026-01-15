console.log("Hello, Node TS!")

const getAreaTriangle = (height : number, base : number) : number => {
    const area = (base * height) / 2
    return area
}

const createBox = (size : number, color : string) : HTMLDivElement => {
    const boxEl = document.createElement("div")
    boxEl.style.backgroundColor = color;
    boxEl.style.height = `${size}px`
    boxEl.style.width = `${size}px`
    return boxEl
}

const username : String = "Budi"
const age : number = 60

const isStudent : boolean = false

console.log(getAreaTriangle(10, 20))


const redBox : HTMLDivElement = createBox(100, "red")
const yellowBox : HTMLDivElement = createBox(200, "yellow")

document.body.append(redBox)
document.body.append(yellowBox)
