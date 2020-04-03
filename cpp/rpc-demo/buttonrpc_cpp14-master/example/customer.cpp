#include <string>
#include <iostream>
#include <ctime>
#include "buttonrpc.hpp"

int main() {
	buttonrpc client;
	client.as_client("127.0.0.1", 5555);
	client.set_timeout(5000);

	std::cout << "rpc start" << std::endl;
	while (true) {
		client.call<void>("cat");
		std::cout << "call cat end" << std::endl;
		client.call<void>("dog");
		std::cout << "call dog end" << std::endl;
		int pig = client.call<int>("pig", 10).val();
		std::cout << "call pig end, result : " << pig << std::endl;

		Sleep(5000);
	}
	std::cout << "rpc end" << std::endl;
	return 0;
}