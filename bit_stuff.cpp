#include <iostream>

void bitStuff(std::string bitStr) {
    int j=0;
    for(int i=0; i<bitStr.length(); i++) {
        if(bitStr[i] == '1') {
            j++;
        } else {
            j = 0;
        }
        if(j == 5) {
            bitStr.insert(i+1, "0");
        }
    }
    std::cout << "The bit-stuffed string is: " << bitStr << std::endl;
}

void bitDeStuff(std::string bitStr) {
    int j=0;
    for(int i=0; i<bitStr.length(); i++) {
        if(bitStr[i] == '1') {
            j++;
        } else {
            j = 0;
        }
        if(j == 5) {
            bitStr.erase(i+1, i+2);
        }
    }
    std::cout << "The bit de-stuffed string is: " << bitStr << std::endl;
}

int main() {
    std::string bitStr;
    std::cout << "Enter the bit string: ";
    std::cin >> bitStr;
    bitStuff(bitStr);
    bitDeStuff(bitStr);
}