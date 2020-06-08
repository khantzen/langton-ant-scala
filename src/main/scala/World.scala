case class World(ant: Ant, painted: List[Position]) {

  def next(): World =
    ant match {
      case Ant(orientation, pos) if painted.contains(pos) =>
        World(
          Ant(
            orientation.antiClockwise(),
            orientation.antiClockwise().forward(pos)),
          painted.filter(p => p != pos)
        )
      case Ant(orientation, pos) =>
        World(
          Ant(
            orientation.clockwise(),
            orientation.clockwise().forward(pos)),
          painted :+ pos
        )
    }
}
