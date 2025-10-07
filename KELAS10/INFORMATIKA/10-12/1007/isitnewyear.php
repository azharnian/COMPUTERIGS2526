<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        if (date('m-d') === '01-01') {
            echo("<h1>Happy New Year!</h1>");
        } else {
            echo("<h1>No!</h1>");
        }
    ?>

    <h1 id="textH1"></h1>

    <script>
        const textH1 = document.getElementById("textH1");

        const today = new Date();

        if (today.getDate() === 1 && today.getMonth() === 0)
        {
            textH1.innerHTML = "Happy New Year!";
        } else 
        {
            textH1.innerHTML = "No!";
        }
    </script>
</body>
</html>