<?php

$item = "World!";
// echo("Hello, " . $item . "!");

class Person {
    public $firstName;
    public $lastName;


    public static $population = 0;

    public const SPECIES = "Homo sapiens";
    public const MAX_AGE = 120;

    // Constructor
    public function __construct($first, $last) {
        $this->firstName = $first;
        $this->lastName = $last;

        self::$population++;

        // echo "A new Person object has been created: " . $this->firstName . " " . $this->lastName . "\n";
    }

    public function getFullName() {
        return $this->firstName . " " . $this->lastName;
    }

    public static function getPopulation() {
        return self::$population;
    }

    public static function createAnonymous() {
        return new Person("Anonymous", "User");
    }

    public function introduce() {
        return "Hi, I'm " . $this->getFullName() . " and I am a " . self::SPECIES;
    }
}


$joshua = new Person("Mr " . "Joshua", "Deco");
// echo($joshua->getFullName());

$p2 = new Person("Jane", "Smith");

// echo($p2->getFullName() . "\n");

// echo("Population: " . Person::getPopulation() . "</br>");

// echo("All humans are: " . Person::SPECIES . "</br>");
// echo("Max age possible: " . Person::MAX_AGE . "</br>");

// CONFIG DB
const DB_PATH = __DIR__ . "/data.db";

function db() : PDO {
    static $pdo = null;
    if ($pdo == null)
    {
        $pdo = new PDO("sqlite:" . DB_PATH);
        // $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        $pdo->exec("
            CREATE TABLE IF NOT EXISTS bmis (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                weight REAL,
                height REAL
        ) ");
    }
    return $pdo;
}

// Handle POST

if ($_SERVER["REQUEST_METHOD"] == "POST")
{
    $name = $_POST["name"];
    $weight = $_POST["weight"];
    $height = $_POST["height"];

    $person = db()->prepare("
                INSERT INTO bmis (name, weight, height)
                VALUES (?, ?, ?)
            ");
    $person->execute([$name, $weight, $height]);
    header("Location: " . $_SERVER["PHP_SELF"]);
    exit;
}

// Handle GET (READ DATA)

$people = db()->query("
            SELECT * FROM bmis;
        ");

?>

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

        form, div#result {
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
            width: 100%;
            margin: 0px auto;
            background-color: black;
            color: white;
        }
    </style>
</head>
<body>
    <?php
    ?>

    <h1>Check Your Well Being BMI</h1>
    <form id="bmiForm" method="POST">
        <div>
            <input type="text" name="name" id="name" placeholder="Fullname">
        </div>
        <div>
            <input type="number" name="weight" id="weight" placeholder="Weight in kg">
        </div>
        <div>
            <input type="number" name="height" id="height" placeholder="Height in cm">
        </div>
        <div>
            <button>Get Result</button>
        </div>
        
    </form>

    <div id="result">
        <h1 id="resultElement">NO RESULT</h1>
        <button id="recheckBtn">Re-check BMI</button>
    </div>

    <script>
        function getBMI(w, h)
        {
            const bmi = w / (h/100)**2;
            if (myBmi < 18.5)
            {
                return "UNDERWEIGHT";
            } 
            if (myBmi > 25)
            {
                return "OVERWEIGHT";
            }
            if (myBmi >= 18.5 && myBmi <= 25)
            {
                return "WITHIN RANGE";
            }   
        }

        const bmiForm = document.getElementById("bmiForm");
        const divResult = document.getElementById("result");
        const recheckBtn = document.getElementById("recheckBtn");

        const name = document.getElementById("name");
        const height = document.getElementById("height");
        const weight = document.getElementById("weight");

        const resultElement = document.getElementById("resultElement");

        let myBmi = 0;

        bmiForm.addEventListener("submit",async function (e){
            e.preventDefault();

            myBmi = getBMI(weight.value, height.value);
            resultElement.innerHTML = myBmi;

            try {
                const res = await fetch("save_bmi.php", {
                method: "POST",
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded",
                },
                body: new URLSearchParams({
                    name: name,
                    weight: weight,
                    height: height,
                }),
                });

                const text = await res.text(); // bisa juga res.json() kalau PHP kirim JSON
                console.log("Server response:", text);
            } catch (error) {
                console.error("Gagal kirim data:", error);
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