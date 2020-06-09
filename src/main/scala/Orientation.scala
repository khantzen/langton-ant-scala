object Orientation extends Enumeration {

  protected case class Val(clockwise: () => Val,
                           antiClockwise: () => Val,
                           forward: Position => Position) extends super.Val

  type Orientation = Val

  val East: Val = Val(() => Orientation.South, () => Orientation.North, (pos: Position) => Position(pos.x + 1, pos.y))
  val South: Val = Val(() => Orientation.West, () => Orientation.East, (pos: Position) => Position(pos.x, pos.y - 1))
  val West: Val = Val(() => Orientation.North, () => Orientation.South, (pos: Position) => Position(pos.x - 1, pos.y))
  val North: Val = Val(() => Orientation.East, () => Orientation.West, (pos: Position) => Position(pos.x, pos.y + 1))

}
