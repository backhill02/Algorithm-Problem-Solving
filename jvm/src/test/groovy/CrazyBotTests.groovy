import com.dgseo.topcoder.CrazyBot
import spock.lang.Specification

class CrazyBotTests extends Specification {

  def crazyBot = new CrazyBot()

  def 'crazyBotTests'() {
    expect:
    expectResult as double == crazyBot.getProbability(n, east, west, south, north)

    where:
    n | east | west | south | north || expectResult
    1 | 25   | 25   | 25    | 25    || 1.0
    2 | 25   | 25   | 25    | 25    || 0.75
    7 | 50   | 0    | 0     | 50    || 1.0
  }
}
