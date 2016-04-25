package agh.parkify.tokens

case class Token(userId: Long, points: Int) {
  override def toString(): String = userId + " has " + points  + " points"
}