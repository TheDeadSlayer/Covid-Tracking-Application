<?php

	class DbOperations{
		private $con;
		
		function __construct(){
		    require_once dirname(__FILE__).'/DbConnect.php';
		
	

		$db = new DbConnect();

		$this->con=$db->connect();

		}
	
		public function createClient($ID,$NameP,$Age,$Location,$PhoneNumber)

		{
		    if($this->isClientExist($ID,$PhoneNumber))
            {
                return  0;
            }
		    else {
                $stmt = $this->con->prepare("INSERT INTO `clientinfo` (`ID`, `NameP`, `Age`, `Location`, `PhoneNumber`, `Institution`, `CT`, `VaccinationStatus`, `VaccineName`, `FirstDoseDate`, `SecondDoseDate`, `TypeS`, `SeverityLevel`, `Contacts`, `ArrivedFrom`, `Verified`) VALUES (?, ?, ?, ?, ?, 0, 0, 'No', 0, 0, 0, 0, 0, 0, 0, 'No');");

                $stmt->bind_param("ssiss", $ID, $NameP, $Age, $Location, $PhoneNumber);

                if ($stmt->execute()) {
                    return 1;
                } else {
                    return 2;
                }
            }


		}

        public function clientLogin($ID,$PhoneNumber)
        {
            $stmt=$this->con->prepare("Select id FROM clientInfo WHERE ID= ? AND PhoneNumber=?");
            $stmt->bind_param("ss",$ID,$PhoneNumber);
            $stmt->execute();
            $stmt->store_result();
            return $stmt->num_rows>0;
        }

        public function getClientByID($ID){
		    $stmt=$this->con->prepare("SELECT * FROM clientInfo WHERE ID=?");
            $stmt->bind_param("s",$ID);
            $stmt->execute();
		    return $stmt->get_result()->fetch_assoc();
		}

		private function isClientExist($ID,$PhoneNumber){
		    $stmt= $this->con->prepare("Select id FROM clientInfo WHERE ID= ? OR PhoneNumber=?");
		    $stmt->bind_param("ss",$ID,$PhoneNumber);
		    $stmt->execute();
		    $stmt->store_result();
		    return $stmt->num_rows>0;

        }
	}
