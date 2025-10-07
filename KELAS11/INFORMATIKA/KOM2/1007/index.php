<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Day of the week</title>
</head>
<body>
    <form id="dayForm" method="post">
        <input type="text" placeholder="day" name="day" id="day">
        <input type="text" placeholder="month" name="month" id="month">
        <input type="text" placeholder="year" name="year" id="year">

        <button>Get Result</button>
    </form>
    
    <?php
        function getTheDay($d, $m, $y)
        {
            $y0 = $y - floor((14 - $m)/12);
            $x0 = $y0 + floor($y0/4) - floor($y0/100) + floor($y0/400);
            $m0 = $m + 12 * floor((14 - $m)/12) - 2;
            $D = ($d + $x0 + floor(31 * $m0 / 12)) % 7;

            if ($D == 0)
                return "Sunday";
            if ($D == 1)
                return "Monday";
            if ($D == 2)
                return "Tuesday";
            if ($D == 3)
                return "Wednesday";
            if ($D == 4)
                return "Thursday";
            if ($D == 5)
                return "Friday";
            return "Saturday";
        }

        if ($_SERVER["REQUEST_METHOD"] == "POST")
        {   
            $day = (int)$_POST["day"];
            $month = (int)$_POST["month"];
            $year = (int)$_POST["year"];

            $res = getTheDay($day, $month, $year);

            echo("<h1>The day is " . $res . "</h1>");
        }
        
    ?>

    <script>
        function getTheDay(d, m, y)
        {
            const y0 = y - Math.floor((14 - m)/12);
            const x0 = y0 + Math.floor(y0/4) - Math.floor(y0/100) + Math.floor(y0/400);
            const m0 = m + 12 * Math.floor((14-m)/12) - 2;
            const D = (d + x0 + Math.floor(31 * m0 / 12)) % 7; 

            // 0 - 6
            if (D === 0)
                return "Sunday";
            if (D === 1)
                return "Monday";
            if (D === 2)
                return "Tuesday";
            if (D === 3)
                return "Wednesday";
            if (D === 4)
                return "Thursday";
            if (D === 5)
                return "Friday";
            return "Saturday";
        }

        const dayForm = document.getElementById("dayForm");
        const day = document.getElementById("day");
        const month = document.getElementById("month");
        const year = document.getElementById("year");

        dayForm.addEventListener("submit", function(event){
            // event.preventDefault();
            // const d = parseInt(day.value);
            // const m = parseInt(month.value);
            // const y = parseInt(year.value);

            // const res = getTheDay(d, m, y);

            // alert("The day is " + res);
            // dayForm.reset();
        });
    </script>
</body>
</html>