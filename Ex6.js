const http = require("http");
const word = "LeBron";
var ans = "All options are: \n" + word + "\n";
var rotateWord = word;
var i;

for (i = 1; i < word.length; i++) {
	rotateWord = rotateWord.substring(rotateWord.length - 1, rotateWord.length) + rotateWord.substring(0, rotateWord.length - 1);
    ans += rotateWord + "\n"
}

let server = http.createServer(function(request, response) {
	response.writeHead(200);
	response.end(ans);
});
server.listen(8080);