case class Person(name: String, age: Int, children: Option[Seq[Person]])

/**
  * It's not safe since it requires type to be Product
  */
extension (p: Product)
  def toJson: String =
    def formatValue(value: Matchable): String = value match
      case o: Option[?] =>
        o match
          case Some(v) => formatValue(v)
          case None    => "null"
      case itr: Iterable[Product] @unchecked =>
        itr.map(_.toJson).mkString("[", ",", "]")
      case arr: Array[Product] => arr.map(_.toJson).mkString("[", ",", "]")
      case prod: Product       => prod.toJson
      case s: String           => s"\"$s\""
      case _                   => value.toString

    val fields = p.productElementNames
      .zip(p.productIterator)
      .map { (name, value) => s"\"$name\":${formatValue(value)}" }
      .mkString(",")

    s"{$fields}"

val p = Person("Dove", 27, Some(List(Person("Dragon", 11, None))))
p.toJson
