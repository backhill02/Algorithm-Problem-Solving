package com.dgseo.topcoder

import spock.lang.Specification

class CryptographyTests extends Specification {

  def cryptography = new Cryptography()

  def 'cryptographyTests'() {
    expect:
    cryptography.encrypt(numbers as int[]) == expectResult

    where:
    numbers                         || expectResult
    [1, 2, 3]                       || 12
    [1, 3, 2, 1, 1, 3]              || 36
    [1000, 999, 998, 997, 996, 995] || 986074810223904000
    [1, 1, 1, 1]                    || 2
  }
}
