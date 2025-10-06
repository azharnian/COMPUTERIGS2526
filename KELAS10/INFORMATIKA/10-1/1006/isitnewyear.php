<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            display : flex;
            min-height : 100vh;
            justify-content : center;
            align-items : center;
        }

        h1 {
            font-size : 100px;
        }
    </style>
</head>
<body>
    <h1 id="textH1"></h1>

    <script>
        const textH1 = document.getElementById("textH1");

        const today = new Date();
        if (today.getDate() === 1  && today.getMonth() === 0)
        {
            textH1.innerHTML = "Happy New Year";
        } else 
        {
            textH1.innerHTML = "No!";
        }

    </script>
</body>
</html>