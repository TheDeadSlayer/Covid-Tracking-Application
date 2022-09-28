<?php

$response=array();

require_once'../include/DbOperations.php';
	
if($_SERVER['REQUEST_METHOD']=='POST'){

	if(isset($_POST['ID']) and isset($_POST['NameP'])and isset($_POST['Age'])and isset($_POST['Location'])and isset($_POST['PhoneNumber'])){
		
		$db= new DbOperations();
		$result=($db->createClient($_POST['ID'],$_POST['NameP'],$_POST['Age'],$_POST['Location'],$_POST['PhoneNumber']));

		if($result==1){
			$response['error']=false;
			$response['message']="User Registered Successfully";
		}elseif($result==2){
			$response['error']=true;
			$response['message']="Error Occurred";
		}elseif($result==0)
        {
            $response['error']=true;
            $response['message']="User Already Registered";
        }

		

	
	}
		else{
		$response['error']=true;
		$response['message']="Required Fields are missing";
			}
	}

	else{	$response['error']=true;
		$response['message']="Invalid Request";
	}

echo json_encode($response);
	
		
