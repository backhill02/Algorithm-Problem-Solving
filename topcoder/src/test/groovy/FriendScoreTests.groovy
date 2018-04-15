import spock.lang.Specification

class FriendScoreTests extends Specification {
  def 'friendScoreTests'() {
    expect:
    new FriendScore().highstScore(s as String[]) == expectResult

    where:
    s                   || expectResult
    ['NNN',
     'NNN',
     'NNN']             || 0
    ['NYY',
     'YNY',
     'YYN']             || 2
    ['NYNNN',
     'YNYNN',
     'NYNYN',
     'NNYNY',
     'NNNYN']           || 4
    ['NNNNYNNNNN',
     'NNNNYNYYNN',
     'NNNYYYNNNN',
     'NNYNNNNNNN',
     'YYYNNNNNNY',
     'NNYNNNNNYN',
     'NYNNNNNYNN',
     'NYNNNNYNNN',
     'NNNNNYNNNN',
     'NNNNYNNNNN']      || 8
    ['NNNNNNNNNNNNNNY',
     'NNNNNNNNNNNNNNN',
     'NNNNNNNYNNNNNNN',
     'NNNNNNNYNNNNNNY',
     'NNNNNNNNNNNNNNY',
     'NNNNNNNNYNNNNNN',
     'NNNNNNNNNNNNNNN',
     'NNYYNNNNNNNNNNN',
     'NNNNNYNNNNNYNNN',
     'NNNNNNNNNNNNNNY',
     'NNNNNNNNNNNNNNN',
     'NNNNNNNNYNNNNNN',
     'NNNNNNNNNNNNNNN',
     'NNNNNNNNNNNNNNN',
     'YNNYYNNNNYNNNNN'] || 6
  }
}
