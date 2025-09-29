<?php
$item = "World!";

class Person {
    public $firstName;
    public $lastName;

    public static $population = 0;
    public const SPECIES = "Homo sapiens";
    public const MAX_AGE = 120;

    public function __construct($first, $last) {
        $this->firstName = $first;
        $this->lastName = $last;
        self::$population++;
    }
    public function getFullName() { return $this->firstName . " " . $this->lastName; }
    public static function getPopulation() { return self::$population; }
    public static function createAnonymous() { return new Person("Anonymous", "User"); }
    public function introduce() { return "Hi, I'm " . $this->getFullName() . " and I am a " . self::SPECIES; }
}

$joshua = new Person("Mr " . "Joshua", "Deco");
$p2 = new Person("Jane", "Smith");

// CONFIG DB
const DB_PATH = __DIR__ . "/data.db";

function db() : PDO {
    static $pdo = null;
    if ($pdo === null) {
        $pdo = new PDO("sqlite:" . DB_PATH);
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
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

// Helper: cek apakah request dari fetch (AJAX)
function is_ajax(): bool {
    return isset($_SERVER['HTTP_X_REQUESTED_WITH']) && strtolower($_SERVER['HTTP_X_REQUESTED_WITH']) === 'xmlhttprequest';
}

// Handle POST (CREATE)
if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $name   = isset($_POST["name"])   ? trim($_POST["name"])   : '';
    $weight = isset($_POST["weight"]) ? trim($_POST["weight"]) : '';
    $height = isset($_POST["height"]) ? trim($_POST["height"]) : '';

    if ($name === '' || !is_numeric($weight) || !is_numeric($height)) {
        if (is_ajax()) {
            http_response_code(400);
            header('Content-Type: application/json');
            echo json_encode(["ok" => false, "message" => "Invalid input"]);
            exit;
        } else {
            http_response_code(400);
            echo "Invalid input";
            exit;
        }
    }

    $pdo = db();
    $stmt = $pdo->prepare("INSERT INTO bmis (name, weight, height) VALUES (?, ?, ?)");
    $stmt->execute([$name, (float)$weight, (float)$height]);

    if (is_ajax()) {
        header('Content-Type: application/json');
        echo json_encode(["ok" => true, "id" => $pdo->lastInsertId()]);
        exit;
    } else {
        header("Location: " . $_SERVER["PHP_SELF"], true, 303);
        exit;
    }
}

$people = db()->query("SELECT * FROM bmis ORDER BY id DESC")->fetchAll(PDO::FETCH_ASSOC);
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>BMI</title>
    <style>
        body { font-family: Arial, sans-serif; }
        form, #result, .list { max-width: 480px; margin: 16px auto; }
        h1, h2 { text-align: center; }
        .card { border: 1px solid #ccc; padding: 12px; margin: 8px 0; border-radius: 8px; }
        form .row { display: flex; gap: 8px; margin: 6px 0; }
        form .row input { flex: 1; padding: 8px; }
        button { width: 100%; padding: 10px; background: #111; color: #fff; border: none; border-radius: 6px; cursor: pointer; }
        button:hover { opacity: .9; }
        #result { display: none; border: none; }
        .muted { color: #666; font-size: 12px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { padding: 8px; border-bottom: 1px solid #eee; text-align: left; }
    </style>
</head>
<body>
    <h1>Check Your Well Being BMI</h1>

    <form id="bmiForm" method="POST">
        <div class="card">
            <div class="row"><input type="text"   name="name"   id="name"   placeholder="Full name"     required /></div>
            <div class="row"><input type="number" name="weight" id="weight" placeholder="Weight (kg)"  step="0.1" min="0" required /></div>
            <div class="row"><input type="number" name="height" id="height" placeholder="Height (cm)"  step="0.1" min="0" required /></div>
            <button type="submit">Calculate & Save</button>
        </div>
    </form>

    <div id="result" class="card">
        <h2 id="resultElement">NO RESULT</h2>
        <div id="resultDetail" class="muted"></div>
        <button id="recheckBtn">Re-check BMI</button>
    </div>

    <script>
        function calcBMI(weightKg, heightCm) {
            const w = parseFloat(weightKg);
            const h = parseFloat(heightCm);
            if (!isFinite(w) || !isFinite(h) || w <= 0 || h <= 0) return { bmi: NaN, category: "INVALID" };

            const bmi = w / ((h / 100) ** 2);
            let cat = "WITHIN RANGE";
            if (bmi < 18.5) cat = "UNDERWEIGHT";
            else if (bmi >= 25) cat = "OVERWEIGHT";
            return { bmi: parseFloat(bmi.toFixed(2)), category: cat };
        }

        const bmiForm      = document.getElementById("bmiForm");
        const divResult    = document.getElementById("result");
        const recheckBtn   = document.getElementById("recheckBtn");
        const nameInput    = document.getElementById("name");
        const heightInput  = document.getElementById("height");
        const weightInput  = document.getElementById("weight");
        const resultEl     = document.getElementById("resultElement");
        const resultDetail = document.getElementById("resultDetail");

        bmiForm.addEventListener("submit", async function (e) {
            e.preventDefault();

            const name   = nameInput.value.trim();
            const weight = weightInput.value.trim();
            const height = heightInput.value.trim();

            const { bmi, category } = calcBMI(weight, height);
            resultEl.textContent = isNaN(bmi) ? "INVALID" : `BMI: ${bmi} — ${category}`;
            resultDetail.textContent = `${name ? name + "," : ""} ${weight} kg, ${height} cm`;

            try {

                const res = await fetch(window.location.href, {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/x-www-form-urlencoded",
                        "X-Requested-With": "XMLHttpRequest" 
                    },
                    body: new URLSearchParams({
                        name: name,
                        weight: weight,
                        height: height
                    })
                });

                const data = await res.json().catch(() => ({}));
                if (!res.ok || data.ok === false) {
                    console.error("Save failed", data);
                    alert("Gagal menyimpan data ke database.");
                    return;
                }
            } catch (err) {
                console.error("Request error:", err);
                alert("Terjadi masalah koneksi.");
                return;
            }

            this.reset();
            this.style.display = "none";
            divResult.style.display = "block";
        });

        recheckBtn.addEventListener("click", function () {
            divResult.style.display = "none";
            bmiForm.style.display = "block";
            nameInput.focus();
        });
    </script>
</body>
</html>
