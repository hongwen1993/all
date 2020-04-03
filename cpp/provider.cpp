#include <string>
#include <iostream>
#include "buttonrpc.hpp"

void cat() {
	std::cout << "provid cat" << std::endl;
}

void dog() {
	std::cout << "provid dog" << std::endl;
}

int pig(int parm) {
	std::cout << "provid pig" << std::endl;
	return --parm;
}

int main() {
	buttonrpc server;
	server.as_server(5555);
	server.bind("cat", cat);
	server.bind("dog", dog);
	server.bind("pig", std::function<int(int)>(pig));
	std::cout << "provider : " << 5555 << std::endl;
	server.run();
	return 0;
}