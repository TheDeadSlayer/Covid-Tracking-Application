
<?php
 
/**
 * A class file to connect to database
 */
class DbConnect {

	private $con;
 
    // constructor
    function __construct() {
        // connecting to database
    }

 
    /**
     * Function to connect with database
     */
    function connect() {
        // import database connection variables
        include_once dirname(__FILE__).'/Constants.php';
	$this->con = new mysqli(DB_HOST,DB_USER,DB_PASSWORD,DB_NAME);
 	
	if(mysqli_connect_errno()){
		echo "Failed to connect with database".mysqli_connect_err();
	}

        return $this->con;
       
    }

}
 
