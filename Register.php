<?php
    $con = mysqli_connect("localhost", "zex199", "pass124!", "zex199");
    mysqli_query($con,'SET NAMES utf8');

    $userID = $_POST["userID"];
    $userPassword = $_POST["userPassword"];
    $userName = $_POST["userName"];
    $userCourse = $_POST["userCourse"];
    $userSpeciality = $_POST["userSpeciality"];
    $userLog = $_POST["userLog"];
    $userGoal = $_POST["userGoal"];

    $statement = mysqli_prepare($con, "INSERT INTO USER VALUES (?,?,?,?,?,?,?)");
    mysqli_stmt_bind_param($statement, "sssssii", $userID, $userPassword, $userName, $userCourse, $userSpeciality, $userLog, $userGoal);
    mysqli_stmt_execute($statement);


    $response = array();
    $response["success"] = true;


    echo json_encode($response);



?>
