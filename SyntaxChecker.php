<?php

function array_peek($array) {
	return $array[ sizeof($array) - 1 ];
}

$mapping = array(']' => '[',
				'}' =>'{',
				')' => '(');

$closers = array_keys($mapping);
$openers = array_values($mapping);

$input = "({]}[])";

$stack = array();

for($i = 0 ; $i < strlen($input) ; $i++) {
	$c = substr($input, $i , 1);
	// echo $c;
	if (in_array($c, $openers) ) {
		array_push($stack, $c);
	} else if ( in_array($c, $closers)){

		if ( $mapping[$c] == array_peek($stack)) {
			# code...
			array_pop($stack);
		} else {
			echo "Invalud closing syntax";
			break;
		}
		// echo $mapping[$c] . "\n";
		// echo array_peek($stack) . "\n";

	} else {
		echo "Unregonized syntax";
		break;
	}

	// print_r($stack);
}

if (sizeof($stack) == 0 ) {
	# code...
	echo $input." is valid.\n";
} else {
	echo $input." is not valid.\n";
}

?>