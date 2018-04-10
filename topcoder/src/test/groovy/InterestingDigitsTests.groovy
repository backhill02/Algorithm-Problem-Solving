import spock.lang.Specification

class InterestingDigitsTests extends Specification {

  def interestingDigits = new InterestingDigits()

  def 'interestingDigitsTests'() {
    expect:
    interestingDigits.digits(base) == expectResult as int[]

    where:
    base || expectResult
    10   || [3, 9]
    3    || [2]
    9    || [2, 4, 8]
    26   || [5, 25]
    30   || [29]
  }
}
