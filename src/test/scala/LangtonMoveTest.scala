import Orientation._
import org.scalatest.FunSuite

class LangtonMoveTest extends FunSuite {

  test("Ant on white case facing East should end on bellow case facing South and last case should be painted") {
    val ant = Ant(East, Position(0, 0))
    val painted = List()
    val world = World(ant, painted)


    assert( world.next() ==  World(Ant(South, Position(0, -1)), List(Position(0, 0))))
  }

  test("Ant on white case facing West should end on top case facing North and last case should be painted") {
    val ant = Ant(West, Position(0, 0))
    val painted = List()
    val world = World(ant, painted)

    assert( world.next() == World(Ant(North, Position(0, 1)), List(Position(0, 0))))
  }

  test("Ant on white case facing North should end on right case facing East and last case should be painted") {
    val ant = Ant(North, Position(7, 5))
    val painted = List(Position(4, 4))
    val world = World(ant, painted)

    assert( world.next() == World(Ant(East, Position(8, 5)), List(Position(4,4), Position(7, 5) ) ) )
  }

  test("Ant on painted case facing North should end on left case facing West and last case should be unpainted") {
    val ant = Ant(North, Position(5, 5))
    val painted = List(Position(5,5))
    val world = World(ant, painted)

    assert( world.next() == World( Ant(West, Position(4,5)), List() ))
  }

  test("Ant on painted case facing South should end on right case facing East and last case should be unpainted") {
    val ant = Ant(South, Position(5, 5))
    val painted = List(Position(4,5), Position(5,5), Position(5,6))
    val world = World(ant, painted)

    assert( world.next() == World( Ant(East, Position(6,5)), List(Position(4,5), Position(5,6)) ))
  }
}
