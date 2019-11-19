/*
 * Sam Borhan
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

#ifndef CAESARCIPHER_H
#define CAESARCIPHER_H

#include <string>
#include <cstring>
#include <sstream>

using namespace std;

class CaesarCipher {
public:
    // * default constructor
    CaesarCipher();

    // * copy constructor
    CaesarCipher(const CaesarCipher &);

    // * encrypt method
    string encrypt(string);

    // * decrypt method
    string decrypt(string);

    // * overloading operator= method
    CaesarCipher &operator=(const CaesarCipher &);

    // * overloading operator+ method
    CaesarCipher operator+(const CaesarCipher &);

    // * OverLoad method operator==
    bool operator==(const CaesarCipher &);

    // * OverLoad method operator<
    bool operator<(const CaesarCipher &);

    //* OverLoad method operator>
    bool operator>(const CaesarCipher &);

    // * OverLoad prefix increment method
    CaesarCipher &operator++();

    // * OverLoad postfix increment method
    CaesarCipher operator++(int);


private:
    // private fields
    static bool isSeeded;
    int shift;
    const int OFFSET_MIN = 32;
    const int OFFSET_MAX = 126;

    // getShift method
    int getShift();

    // encryptDecrypt method
    string encryptDecrypt(string, bool);

    // isPositionInRange method
    bool isPositionInRange(int);

    // shiftRange method
    int shiftRange(int);
};

#endif