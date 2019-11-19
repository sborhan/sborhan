/*
 * Sam Borhan
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 * This program demonstrates the CaesarCipher class
 */

#include "CaesarCipher.h"
#include <iostream>


//using this const boolean to feed rand() with srand()
bool CaesarCipher::isSeeded = false;

/**
 * default constructor
 */
CaesarCipher::CaesarCipher() {
    shift = getShift(); //calls private method getShift to assign a random number to the shift.
}

/**
 * copy constructor
 * copying obj fields to this
 * @param obj :const CaesarCipher &
 */
CaesarCipher::CaesarCipher(const CaesarCipher &obj) {
    shift = obj.shift; // assigns private field of obj to this.
}

/**
 * encrypt method
 * @param words : String
 * @return :String value of encrypted words using encryptDecrypt private method
 */
string CaesarCipher::encrypt(string words) {
    return encryptDecrypt(words, true);
}


/**
 * decrypt method
 * @param words : String
 * @return : String value of decrypted words using encryptDecrypt private method
 */
string CaesarCipher::decrypt(string words) {
    return encryptDecrypt(words, false);
}

/**
 * overloading operator= method
 * @param obj : const CaesarCipher &
 * @return : CaesarCipher object with assigned obj private field value to its private field
 */
CaesarCipher &CaesarCipher::operator=(const CaesarCipher &obj) {
    if (this != &obj) {    // only assign if this != &obj
        // assign shift (from obj)
        shift = obj.shift;
    }
    return *this;
}

/**
 * overloading operator+ method
 * @param right :const CaesarCipher &
 * @return :CaesarCipher Object with a shift field value which is the summation of this and right fields value
 */
CaesarCipher CaesarCipher::operator+(const CaesarCipher &right) {
    CaesarCipher temp;

    temp.shift = shift + right.shift;

    /*
     * using shiftRange method to check if it exceeds (OFFSET_MAX - OFFSET_MIN) = 94 assigns-
     * OFFSET_MIN (26) to temp.shift to avoid unacceptable characters.
     */
    temp.shift = shiftRange(temp.shift);

    return temp;
}

/**
 * OverLoad method operator==
 * @param right : const CaesarCipher &
 * @return : returns true if this and right object have same private field value
 */
bool CaesarCipher::operator==(const CaesarCipher &right) {
    bool status;

    if (shift == right.shift)
        status = true;
    else
        status = false;

    return status;
}

/**
 * OverLoad method operator<
 * @param right : const CaesarCipher &
 * @return : returns true if this private field value is less than right object field
 */
bool CaesarCipher::operator<(const CaesarCipher &right) {
    bool status;

    if (shift < right.shift)
        status = true;
    else
        status = false;

    return status;
}

/**
 *OverLoad method operator>
 * @param right : const CaesarCipher&
 * @return : returns true if this private field value is bigger than right object field
 */
bool CaesarCipher::operator>(const CaesarCipher &right) {
    bool status;

    if (shift > right.shift)
        status = true;
    else
        status = false;

    return status;
}

/**
 * OverLoad prefix increment method
 * @return : operator ++ returns CaesarCipher object with incremented field
 */
CaesarCipher &CaesarCipher::operator++() {
    ++shift;
    /*
      * using shiftRange method to check shift value it exceeds (OFFSET_MAX - OFFSET_MIN) = 94 assigns-
      * OFFSET_MIN (26) to temp.shift to avoid unacceptable characters.
    */
    shift = shiftRange(shift);
    return *this;
}


/**
 * OverLoad postfix increment method
 * @return : operator ++ returns CaesarCipher object with previous field
 */
CaesarCipher CaesarCipher::operator++(int) {
    CaesarCipher temp(*this);
    shift++;
    /*
      * using shiftRange method to check if shift value exceeds (OFFSET_MAX - OFFSET_MIN) = 94 assigns-
      * OFFSET_MIN (26) to temp.shift to avoid unacceptable characters.
    */
    shift = shiftRange(shift);

    return temp;
}

/**
 * shiftRange method
 * checks if Integer range value exceeds (OFFSET_MAX - OFFSET_MIN) = 94 assigns -
 * OFFSET_MIN (26) to temp.shift to avoid unacceptable characters.
 * @param range : Integer
 * @return      : Integer
 */
int CaesarCipher::shiftRange(int range) {
    int shift = range;
    if (shift > (OFFSET_MAX - OFFSET_MIN))
        shift = OFFSET_MIN;

    return shift;
}

/**
 * getShift method
 * @return : Random Integer value between range of 1-94
 */
int CaesarCipher::getShift() {
    //making sure to get different random number when running the program multiple times
    if (!isSeeded) {
        srand(time(0));
        isSeeded = true;
    }
    int low = 1;
    int high = OFFSET_MAX - OFFSET_MIN;
    int range = high - low + 1;
    return rand() % range + low;
}

/**
 * encryptDecrypt method
 *
 * @param words   : String
 * @param encrypt : String
 * @return : String value of encrypted or decrypted words depends on boolean is true or false
 */
string CaesarCipher::encryptDecrypt(string words, bool encrypt) {
    stringstream ss;

   for (char const &c : words) {
        int indx = c, cpos;
        if (!isPositionInRange(indx))
            throw invalid_argument("String to be encrypted has unrecognized character " + c);

        if (encrypt) {
            cpos = indx + shift;
            if (cpos > OFFSET_MAX)
                cpos = OFFSET_MIN + (cpos - OFFSET_MAX);
        } else {
            cpos = indx - shift;
            if (cpos < OFFSET_MIN)
                cpos = OFFSET_MAX - (OFFSET_MIN - cpos);
        }
        ss << (char) cpos;
    }

    return ss.str();
}

/**
 *isPositionInRange method
 * @param indx :Integer
 * @return true if indx parameter between (OFFSET_MIN , OFFSET_MAX)
 */
bool CaesarCipher::isPositionInRange(int indx) {
    return indx >= OFFSET_MIN && indx <= OFFSET_MAX;
}
