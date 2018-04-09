const readline = require('readline');

const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

rl.on('line', function(line) {
	var input = line.split(" ");
	var a = parseInt(input[0]);
	var b = parseInt(input[1]);
	console.log(a+b);
	rl.close();
});
