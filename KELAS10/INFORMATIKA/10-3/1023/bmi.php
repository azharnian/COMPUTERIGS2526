<html>
    <head>
        <title>BMI php version</title>
    </head>
    <body>
        <?php
        if (isset($_POST['submit_button'])) {
            $weight = $_POST['weight'];
            $height = $_POST['height'];

            $bmi = $weight / ($height / 100)**2;
            $msg = "";
            if ($bmi < 18.5)
                $msg = "Underweight";
            else if ($bmi >= 18.5 && $bmi < 25)
                $msg = "Normal weight";
            else if ($bmi >= 25 && $bmi < 30)
                $msg = "Over weight";
            else
                $msg = "Obesity";

            echo("<h1> Your BMI is " . htmlspecialchars($bmi) . "</h1>");
            echo("<h1>" . htmlspecialchars($msg) . "</h1>");
        } 
        ?>
        <form method="post">
            <h1>Body Mass Index</h1>
            <div>
                <input type="text" name="weight" placeholder="Input your weight (kg)">
            </div>

            <div>
                <input type="text" name="height" placeholder="Input your height (cm)">
            </div>
            <div>
                <button name="submit_button">Get Result</button>
            </div>
        </form>
    </body>
</html>