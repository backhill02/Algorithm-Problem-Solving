import spock.lang.Specification

class InterestingPartyTests extends Specification {

  def interestingParty = new InterestingParty()

  def 'interestingPartyTests'() {
    expect:
    interestingParty.bestInvitation(first as String[], second as String[]) == expectResults

    where:
    first                                             | second                                           || expectResults
    ['fishing', 'gardening', 'swimming', 'fishing']   | ['hunting', 'fishing', 'fishing', 'biting']      || 4
    ['variety', 'diversity', 'loquacity', 'courtesy'] | ['talking', 'speaking', 'discussion', 'meeting'] || 1
    ['snakes', 'programing', 'cobra', 'monty']        | ['python', 'python', 'anaconda', 'python']       || 3
  }

  def 'many people test'() {
    given:
    def firstDummy = ['t', 'o', 'p', 'c', 'o', 'd', 'e', 'r', 's', 'i', 'n', 'g', 'l', 'e', 'r', 'o', 'u', 'n', 'd', 'm', 'a', 't', 'c', 'h', 'f', 'o', 'u', 'r', 'n', 'i']
    def secondDummy = ['n', 'e', 'f', 'o', 'u', 'r', 'j', 'a', 'n', 'u', 'a', 'r', 'y', 't', 'w', 'e', 'n', 't', 'y', 't', 'w', 'o', 's', 'a', 't', 'u', 'r', 'd', 'a', 'y']

    when:
    def result = interestingParty.bestInvitation(firstDummy as String[], secondDummy as String[])

    then:
    result == 6
  }
}
