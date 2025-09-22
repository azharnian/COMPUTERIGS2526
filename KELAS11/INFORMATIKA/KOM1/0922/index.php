<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PHP and JS</title>
</head>
<body>
    <?php
        echo("<h1>Hello, PHP!</h1>");
    ?>

    <h1 id="h1Element">Hello, JS, I'm Black!</h1>

    <script>
        // document.write("<h1>Hello, JS!</h1>");

        const h1Element = document.getElementById("h1Element");

        h1Element.addEventListener("click", function(){
            this.style.color = "red";
            this.innerHTML = "Hello, Now, I'm Red!";
        });
        // php -S 127.0.0.1:8080

        const myHeight = prompt("Input your height (m): ");
        const myWeight = prompt("Input your weight (kg): ");

        let myBmi = myWeight / (myHeight * myHeight);

        myBmi = myBmi.toFixed(2);

        alert("My calculated BMI is ... "+ myBmi);

        if (myBmi < 18.5)
        {
            alert("UNDERWEIGHT");
        } 
        if (myBmi > 25)
        {
            alert("OVERWEIGHT");
        }
        if (myBmi >= 18.5 && myBmi <= 25)
        {
            alert("WITHIN RANGE");
        }
    </script>
</body>
</html>