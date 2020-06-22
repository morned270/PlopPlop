<?php
    $con = mysqli_connect("localhost", "zex199", "pass124!", "zex199");
    mysqli_query($con,'SET NAMES utf8');

    $logUser = $_POST["logUser"];
    $logNumber = $_POST["logNumber"];

    $statement = mysqli_prepare($con, "SELECT * FROM LOGBOOK WHERE logUser = ? AND logNumber = ?");
    mysqli_stmt_bind_param($statement, "si", $logUser, $logNumber);
    mysqli_stmt_execute($statement);


    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $logUser,$logNumber,$logDate,$logLocation,$logLocationType,
    $logPoint,$logTemperature,$logEnterTime,$logExitTime,$logRestTime,$logWeight,$logEnterPressure,$logExitPressure,$logView,
    $logWave,$logMaxDepth,$logAveDepth,$logStopFollow,$logSpeedFollow,$logMemo);

    $response = array();
    $response["success"] = false;

    while(mysqli_stmt_fetch($statement)) {
        $response["success"] = true;
        $response["logUser"] = $logUser;
        $response["logNumber"] = $logNumber;
        $response["logDate"] = $logDate;
        $response["logLocation"] = $logLocation;
        $response["logLocationType"] = $logLocationType;
        $response["logPoint"] = $logPoint;
        $response["logTemperature"] = $logTemperature;
        $response["logEnterTime"] = $logEnterTime;
        $response["logExitTime"] = $logExitTime;
        $response["logRestTime"] = $logRestTime;
        $response["logWeight"] = $logWeight;
        $response["logEnterPressure"] = $logEnterPressure;
        $response["logExitPressure"] = $logExitPressure;
        $response["logView"] = $logView;
        $response["logWave"] = $logWave;
        $response["logMaxDepth"] = $logMaxDepth;
        $response["logAveDepth"] = $logAveDepth;
        $response["logStopFollow"] = $logStopFollow;
        $response["logSpeedFollow"] = $logSpeedFollow;
        $response["logMemo"] = $logMemo;
    }

    echo json_encode($response);



?>
