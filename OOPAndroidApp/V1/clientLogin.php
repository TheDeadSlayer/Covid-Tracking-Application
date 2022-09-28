<?php

$response=array();

require_once'../include/DbOperations.php';

if($_SERVER['REQUEST_METHOD']=='POST'){

    if(isset($_POST['ID']) and isset($_POST['PhoneNumber']))
    {
        $db = new DbOperations();

        if($db->clientLogin($_POST['ID'],$_POST['PhoneNumber'])){
            $user= $db->getClientByID($_POST['ID']);
            $response['error']=false;
            $response['ID']=$user['ID'];
            $response['NameP']=$user['NameP'];
            $response['Age']=$user['Age'];
            $response['Location']=$user['Location'];
            $response['PhoneNumber']=$user['PhoneNumber'];
            $response['Institution']=$user['Institution'];
            $response['CT']=$user['CT'];
            $response['VaccinationStatus']=$user['VaccinationStatus'];
            $response['VaccineName']=$user['VaccineName'];
            $response['FirstDoseDate']=$user['FirstDoseDate'];
            $response['SecondDoseDate']=$user['SecondDoseDate'];
            $response['TypeS']=$user['TypeS'];
            $response['SeverityLevel']=$user['SeverityLevel'];
            $response['Contacts']=$user['Contacts'];
            $response['ArrivedFrom']=$user['ArrivedFrom'];
            $response['Verified']=$user['Verified'];
        }else{
            $response['error']=true;
            $response['message']="Unregistered ID or Phone Number";
        }
    }else{
        $response['error']=true;
        $response['message']="Required Fields are missing";
    }
}

echo json_encode($response);