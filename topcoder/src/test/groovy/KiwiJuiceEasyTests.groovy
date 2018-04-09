import spock.lang.Specification

class KiwiJuiceEasyTests extends Specification {

  def kiwiJuiceEasy = new KiwiJuiceEasy()

  def 'kiwiJuiceEasyTests'() {
    expect:
    kiwiJuiceEasy.thePouring(capacities as int[], bottles as int[], fromId as int[], toId as int[]) == expectResults as int[]

    where:
    capacities                        | bottles                          | fromId                   | toId                     || expectResults
    [10, 10]                          | [5, 8]                           | [0]                      | [1]                       | [3, 10]
    [30, 20, 10]                      | [10, 5, 5]                       | [0, 1, 2]                | [1, 2, 0]                || [10, 10, 0]
    [14, 35, 86, 58, 25, 62]          | [6, 34, 27, 38, 9, 60]           | [1, 2, 4, 5, 3, 3, 1, 0] | [0, 1, 2, 4, 2, 5, 3, 1] || [0, 14, 65, 35, 25, 35]
    [700000, 800000, 900000, 1000000] | [478478, 478478, 478478, 478478] | [2, 3, 2, 0, 1]          | [0, 1, 1, 3, 2]           | [0, 156956, 900000, 856956]
  }
}
