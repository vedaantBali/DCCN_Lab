#include <iostream>

void decToBin(int decimal) {
    for(int i=128; i != 0; i=i>>1) {
        if(decimal & i)
            std::cout << 1;
        else    
            std::cout << 0;
    }
}

int main() {
    int decimal[4];
    int binary[8] = {128, 64, 32, 16, 8, 4, 2, 1};
    std::cout << "Enter the IP Address: ";
    for(int i=0; i<4; i++) {
        std::cin >> decimal[i];
    }
    std::cout << "The binary IP Address is: ";
    for(int i=0; i<4; i++) {
        decToBin(decimal[i]);
        if(i < 3) {
            std::cout << ".";
        }
    }
    std::cout << std::endl;
}