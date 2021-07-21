#include <iostream>

int main() {
    std::string ip;
    std::cout << "Enter an ip address: ";
    std::cin >> ip;
    char arr[4];
    int i = 0;
    while(ip[i] != '.') {
        arr[i] = ip[i];
        i++;
    }
    char returnClass;
    int ipClass = atoi(arr); 
    if(ipClass >=1 && ipClass <=126) {
        returnClass = 'A';
    } else if(ipClass <=191) {
        returnClass = 'B';
    } else if(ipClass <= 223) {
        returnClass = 'C';
    } else if(ipClass <= 239) {
        returnClass = 'D';
    } else {
        returnClass = 'E';
    }
    std::cout << "Class of " << ip << " is: " << returnClass;
    std::cout << std::endl;
}