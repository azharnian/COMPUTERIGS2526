<html>
<head>
    <title>Is It New Year ?</title>
</head>
<body>
    <?php
        // echo("Hello, world!</br>");
        // echo "Hello, PHP!</br>";

        // echo(date("m-d"));
        if (date("m-d")== "01-01")
        {
            echo("<h1>Happy New Year</h1>");
        } else 
        {
            echo("<h1>No!</h1>");
        }
    ?>
</body>
</html>