<?php

	//$judul = $_GET['judul'];
	//$isi = $_GET['isi'];
	$judul = 'Haii';
	$isi = 'Hello World';
	
	$url = "https://fcm.googleapis.com/fcs/send";
	
	$token = "dj3wDfJdJbE:APA91bHT4pnibmGjBvi4Y1otaUVXh3LQvSZE9vrDz9iT9oF48l4LYiE7pvl33oEEQgmh3qM4lw6125ax3OL9yohO5Rzu_rFvBEOIixgzNdde9mZWvstNOTRBy6dopk3Iaqu9zA088kH2";
	
	$serverkey = "AAAAoYRARjw:APA91bHysW50rsewYnPZFrVYXqTiFaUuWelGKVtzYLTqO9K_xuS_vZJM_AtNhR_ojJrpF7UNcuVbsfBTBhQ9RK9OT4nlqD5sBFIA9ru7F-7pyEHfQTGbo2eZSYw5tlg8IZV1GkOw0QtX";
	
	$notification = array('title'=>$judul, 'body'=>$isi, 'sound'=>'default', 'badge'=>'1');
	
	$arraytosend = array('to'=>$token, 'notification'=>$notification, 'priority'=>'high');
	
	$json = json_encode($arraytosend);
	
	$header = array();
	$header[] = 'Content-Type:application/json';
	$header[] = 'Authorization: key='.$serverkey;
	
	$ch = curl_init();
	curl_setopt($ch, CURLOPT_URL, 'https://fcm.googleapis.com/fcs/send');
	curl_setopt($ch, CURLOPT_POST, true);
	curl_setopt($ch, CURLOPT_HTTPHEADER, $header);
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
	curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
	curl_setopt($ch, CURLOPT_POSTFIELDS, $json);
	
	$response = curl_exec($ch);
	
	if($response == FALSE){
		die('FCM Send Error : '.curl_error($ch));
	}
	
	curl_close($ch);
	
?>