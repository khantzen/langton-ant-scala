sealed abstract class Orientation(val clockwise: () => Orientation,
                                  val antiClockwise: () => Orientation,
                                  val forward: Position => Position
                                 )

case object East extends Orientation(() => South, () => North, (pos: Position) => Position(pos.x + 1, pos.y))

case object South extends Orientation(() => West, () => East, (pos: Position) => Position(pos.x, pos.y - 1))

case object West extends Orientation(() => North, () => South, (pos: Position) => Position(pos.x - 1, pos.y))

case object North extends Orientation(() => East, () => West, (pos: Position) => Position(pos.x, pos.y + 1))
