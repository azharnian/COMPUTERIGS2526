<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BMI</title>
    <style>
        body {
            font-family : "Arial";
        }

        form {
            max-width : 400px;
            margin : 0px auto;
        }

        h1 {
            text-align : center;
        }

        div {
            border : 1px solid black;
            padding : 10px;
            margin : 5px;
            display : flex;
            flex-direction : column;
            justify-content : center;
            align-items :center;
        }

        div input {
            width: 100%;
        }

        div#result {
            border : none;
            display: none;
        }

        button {
            display: block;
            margin: 0px auto;
        }
    </style>
</head>
<body>
    <?php
    ?>

    <h1>Check Your Well Being BMI</h1>
    <form action="" id="bmiForm">
        <div>
            <input type="text" id="name" placeholder="Fullname">
        </div>
        <div>
            <input type="number" id="weight" placeholder="Weight in kg">
        </div>
        <div>
            <input type="number" id="height" placeholder="Height in cm">
        </div>
        <button>Check My BMI</button>
    </form>

    <div id="result">
        <h1 id="resultElement">NO RESULT</h1>
        <button id="recheckBtn">Re-check BMI</button>
    </div>

    <script>
        const bmiForm = document.getElementById("bmiForm");
        const divResult = document.getElementById("result");
        const recheckBtn = document.getElementById("recheckBtn");

        const name = document.getElementById("name");
        const height = document.getElementById("height");
        const weight = document.getElementById("weight");

        const resultElement = document.getElementById("resultElement");

        let myBmi = 0;

        bmiForm.addEventListener("submit", function(e){
            e.preventDefault();

            // calculate bmi
            myBmi = weight.value / ((height.value/100)*(height.value/100));

            if (myBmi < 18.5)
            {
                // alert("UNDERWEIGHT");
                resultElement.innerHTML = "UNDERWEIGHT";
            } 
            if (myBmi > 25)
            {
                // alert("OVERWEIGHT");
                resultElement.innerHTML = "OVERWEIGHT";
            }
            if (myBmi >= 18.5 && myBmi <= 25)
            {
                // alert("WITHIN RANGE");
                resultElement.innerHTML = "WITHIN RANGE";
            }

            this.style.display = "none";
            this.reset();

            divResult.style.display = "block";
        });

        recheckBtn.addEventListener("click", function(){
            divResult.style.display = "none";

            bmiForm.style.display = "block";
        })
    </script>
</body>
</html>