<?php
// echo "Hello, world!\n";
// echo("Hello, PHP!\n");
// echo("<h1>Hello, HTML!</h1>");

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

$victor = new Person("Victor", "Jonathan");
// echo( $victor->getFullName());
// echo( Person::getPopulation());

// DATABASE CONNECTION
const DB_PATH = __DIR__ . "/data.db";
function db(){
    static $pdo = null;
    if ($pdo == null)
    {
        $pdo = new PDO("sqlite:" . DB_PATH);
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        $pdo->exec("
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                first TEXT,
                last TEXT,
                hobbies TEXT)
        ");
    }
    return $pdo;
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Web with PHP</title>
    <style>
        * {
            margin: 0px;
            padding: 0px;
            box-sizing: border-box;
        }

        body {
            font-family: Arial;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        table, tr, th, td {
            width: 100%;
            border: 1px solid black;
            border-collapse: collapse;
        }

        th, td {
            padding: 5px;
        }

        div.table-container, form {
            margin: 0 auto;
            padding : 20px;
            height : 300px;
            width: 400px;
            border: 1px solid black;
        }

        input, label {
            display: block;
        }

        input {
            width: 100%;
        }
    </style>
</head>
<body>
    <div class="table-container">
        <h1>List of users</h1>
        <table>
            <thead>
                <tr>
                <th>First</th>
                <th>Last</th>
                <th>Hobbies</th>
                </tr>
            </thead>
            
            <tbody>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </div>
    
    <form method="post">
        <h1>Input new user</h1>
        <div>
            <label for="first">First :</label>
            <input type="text" id="first" name="first">
        </div>
        <div>
            <label for="last">Last :</label>
            <input type="text" id="last" name="last">
        </div>
        <div>
            <label for="hobbies">Hobbies :</label>
            <input type="text" id="hobbies" name="hobbies">
        </div>
        <button>Submit</button>
    </form>
</body>
</html>