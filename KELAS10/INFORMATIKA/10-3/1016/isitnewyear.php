<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Is It New Year?</title>
</head>
<body>
    <?php
        if (date("m-d") == "01-01")
        {
            echo("<h1>YES</h1>");
        } else 
        {
            echo("<h1>NO!</h1>");
        }
    ?>
    <h1 id="newYear"></h1>
    <script>
        const newYear = document.getElementById("newYear");

        const today = new Date();
        if (today.getDate() === 1 && today.getMonth() === 0)
        {
            newYear.innerHTML = "YES";
        } else 
        {
            newYear.innerHTML = "NO!";
        }
    </script>
</body>
</html>