<?php
    $con = mysqli_connect("localhost", "zex199", "pass124!", "zex199");
    mysqli_query($con,'SET NAMES utf8');

    $newLog = $_POST["newLog"];
    $userID = $_POST["userID"];

    $statement = mysqli_prepare($con, "UPDATE USER SET userLog = ? WHERE userID = ?");
    mysqli_stmt_bind_param($statement, "is", $newLog, $userID);
    mysqli_stmt_execute($statement);


    $response = array();
    $response["success"] = true;


    echo json_encode($response);



?>
