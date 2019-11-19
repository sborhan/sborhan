/*
 * Sam Borhan
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 * This program demonstrates the CaesarCipher class
 */
#include "CaesarCipher.h"
#include <string>
#include <iostream>

using namespace std;


const string WORDS = "Hello, world!";

void print(CaesarCipher);

int main() {
    // two times running the test
    for (int i = 0; i < 2; i++) {

        cout << "***** RUN " << i + 1 << ": *****" << endl << endl;

        cout << "test constructor : cc" << endl;
        CaesarCipher cc;// making temporary object of CaesarCipher
        print(cc); //private method print -> prints decrypt encrypt of "hello, world!"

        cout << "test constructor : cc2" << endl;
        //each time CaesarCipher constructor calls private method getShift and it generates different 'shift' field
        CaesarCipher cc2;
        print(cc2);   // should print different encrypt value

        cout << "*** testing copy constructor and overloaded assignment ***" << endl << endl;
        cout << "test copy constructor : cc3(cc2)" << endl;
        CaesarCipher cc3(cc2); // private field of cc3 now is same as cc2
        print(cc3); // encrypt value of cc3 should be same as cc2

        cout << "test overloaded assignment operator : cc2 = cc" << endl;
        cc2.operator=(cc); // same as cc2 = cc
        print(cc2); // encrypt value of cc2 should be same as cc

        cout << "*** printing cc, cc2, and cc3 ***" << endl << endl;
        cout << "test constructor : cc" << endl;
        print(cc);
        cout << endl << "test constructor : cc2" << endl;
        print(cc2);
        cout << endl << "test constructor : cc3" << endl;
        print(cc3); // encrypt value of cc3 should be different from cc and cc2

        cout << endl << "*** testing comparators ***" << endl;
        cout << boolalpha << "cc2 == cc  is " << cc2.operator==(cc) << endl;
        cout << boolalpha << "cc  == cc2 is " << cc.operator==(cc2) << endl;
        cout << boolalpha << "cc  == cc3 is " << cc.operator==(cc3) << endl;
        cout << boolalpha << "cc2 == cc3 is " << cc2.operator==(cc3) << endl;
        cout << boolalpha << "cc3 == cc2 is " << cc3.operator==(cc2) << endl;
        cout << boolalpha << "cc  < cc3  is " << cc.operator<(cc3) << endl;
        cout << boolalpha << "cc  > cc3  is " << cc.operator>(cc3) << endl;
        cout << boolalpha << "cc3 < cc   is " << cc3.operator<(cc) << endl;
        cout << boolalpha << "cc3 < cc2  is " << cc3.operator<(cc2) << endl;

        cout << endl << "*** testing add ***" << endl;
        cout << "test add : cc2 = cc + cc3" << endl;
        cc2 = cc.operator+(cc3); //if cc + cc3 > 94 then cc2 = 32
        print(cc2); //print new encrypt value for cc2

        cout << endl << "*** testing increment ***" << endl << endl;
        CaesarCipher cc4;
        cout << "test increment (postfix) : cc4 = cc++" << endl;
        cc4 = cc.operator++(1); // same as cc++
        print(cc); // cc incremented by 1
        cout << "result of cc4 after postfix :" << endl;
        print(cc4); // cause it's postfix previous private field value of cc assigned to cc4

        cout << "test increment (prefix) : cc4 = ++cc" << endl;
        cc4 = cc.operator++();
        print(cc); // cc incremented by 1
        cout << "result of cc4 after prefix :" << endl;
        print(cc4); // cause it's prefix incremented private field value of cc4 assigned to cc4


        cout << "test increment (postfix) : cc4 = cc2++" << endl;
        cc4 = cc2.operator++(1);
        print(cc2);
        cout << "result of cc4 after postfix :" << endl;
        print(cc4);

        cout << "test increment (prefix) : cc4 = ++cc2" << endl;
        cc4 = cc2.operator++();
        print(cc2);
        cout << "result of cc4 after prefix :" << endl;
        print(cc4);


        cout << "test increment (postfix) : cc4 = cc3++" << endl;
        cc4 = cc3.operator++(1);
        print(cc3);
        cout << "result of cc4 after postfix :" << endl;
        print(cc4);

        cout << "test increment (prefix) : cc4 = ++cc3" << endl;
        cc4 = cc3.operator++();
        print(cc3);
        cout << "result of cc4 after prefix :" << endl;
        print(cc4);


    }
    return 0;

}

/**
 * print method
 * print Encrypted and Decrypted of "hello, world!" for each CaesarCipher object
 * @param cc :CaesarCipher instance variable
 */
void print(CaesarCipher cc) {
    string encryptedWord = cc.encrypt(WORDS);
    cout << "Encrypted: " << encryptedWord << endl;
    string decryptedWord = cc.decrypt(encryptedWord);
    cout << "Decrypted: " << decryptedWord << endl << endl;

}