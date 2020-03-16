package com.dgseo.topcoder

import spock.lang.Specification

class ThePalindromeTests extends Specification {

    def thePalindrome = new ThePalindrome()

    def 'thePalindromeTests'() {
        expect:
        thePalindrome.find(s) == expectResult

        where:
        s                             || expectResult
        'abab'                        || 5
        'abacaba'                     || 7
        'qwerty'                      || 11
        'abdfhdyrbdbsdfghjkllkjhgfds' || 38
    }
}
