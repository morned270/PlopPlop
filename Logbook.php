<?php
    $con = mysqli_connect("localhost", "zex199", "pass124!", "zex199");
    mysqli_query($con,'SET NAMES utf8');

    $logUser = $_POST["logUser"];
    $logNumber = $_POST["logNumber"];             //int
    $logDate = $_POST["logDate"];                 //date
    $logLocation = $_POST["logLocation"];
    $logLocationType = $_POST["logLocationType"];
    $logPoint = $_POST["logPoint"];
    $logTemperature = $_POST["logTemperature"];   //int
    $logEnterTime = $_POST["logEnterTime"];       //time
    $logExitTime = $_POST["logExitTime"];         //time
    $logRestTime = $_POST["logRestTime"];         //time
    $logWeight = $_POST["logWeight"];             //int
    $logEnterPressure = $_POST["logEnterPressure"]; //int
    $logExitPressure = $_POST["logExitPressure"];   //int
    $logView = $_POST["logView"];                   //int
    $logWave = $_POST["logWave"];
    $logMaxDepth = $_POST["logMaxDepth"];           //int
    $logAveDepth = $_POST["logAveDepth"];           //int
    $logStopFollow = $_POST["logStopFollow"];       //int
    $logSpeedFollow = $_POST["logSpeedFollow"];     //int
    $logMemo = $_POST["logMemo"];

    $statement = mysqli_prepare($con, "INSERT INTO LOGBOOK VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    mysqli_stmt_bind_param($statement, "isissssisssiiiisiiiis", $logUser,$logNumber,$logDate,$logLocation,$logLocationType,
    $logPoint,$logTemperature,$logEnterTime,$logExitTime,$logRestTime,$logWeight,$logEnterPressure,$logExitPressure,$logView,
    $logWave,$logMaxDepth,$logAveDepth,$logStopFollow,$logSpeedFollow,$logMemo);
    mysqli_stmt_execute($statement);


    $response = array();
    $response["success"] = true;


    echo json_encode($response);



?>
