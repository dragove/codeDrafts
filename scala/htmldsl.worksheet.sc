import scala.collection.mutable.ArrayBuffer
class HtmlBuilder(contents: ArrayBuffer[String] = ArrayBuffer.empty):
  def appendContent(tag: String, content: String) = 
    contents.append(s"<$tag>$content</$tag>")
    this
  def build() = contents.mkString("\n")

def p(content: String)(using builder: HtmlBuilder) =
  builder.appendContent("p", content)

def h1(content: String)(using builder: HtmlBuilder) =
  builder.appendContent("h1", content)

def html(contents: HtmlBuilder ?=> Unit) =
  given builder: HtmlBuilder = HtmlBuilder()
    contents
  builder.build()

html {
  h1("title")
  p("content")
}

