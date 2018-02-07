package net.bzzt

import sbt._
import com.lightbend.paradox.sbt.ParadoxPlugin

object ParadoxRevealPlugin extends AutoPlugin {
  import ParadoxPlugin.autoImport._

  override def requires = ParadoxPlugin

  override def projectSettings: Seq[Setting[_]] = Seq(
    paradoxDirectives += {
  import com.lightbend.paradox.markdown.Writer.Context
  import com.lightbend.paradox.markdown.WrapDirective

  (_: Context) => new WrapDirective("section") {
    import org.pegdown.ast._
    import org.pegdown.Printer

    override def render(node: DirectiveNode, visitor: Visitor, printer: Printer): Unit = {
      val id =
        node.attributes.identifier match {
          case null => ""
          case x    => s""" id="$x""""
        }
      val classes =
        node.attributes.classesString match {
          case "" => ""
          case x  => s""" class="$x""""
        }
      import scala.collection.JavaConverters._
      val attrs = node.attributes.keys.asScala.map(key => s""" $key="${node.attributes.value(key)}"""").mkString
      printer.print(s"""<$typ$id$classes$attrs>""")
      node.contentsNode.accept(visitor)
      printer.print(s"</$typ>")
    }
  }
},

paradoxDirectives += {
  import com.lightbend.paradox.markdown.Writer.Context
  import com.lightbend.paradox.markdown.WrapDirective

  (_: Context) => new WrapDirective("section") {
    import org.pegdown.ast._
    import org.pegdown.Printer

    override def render(node: DirectiveNode, visitor: Visitor, printer: Printer): Unit = {
      val id =
        node.attributes.identifier match {
          case null => ""
          case x    => s""" id="$x""""
        }
      val classes =
        node.attributes.classesString match {
          case "" => ""
          case x  => s""" class="$x""""
        }
      import scala.collection.JavaConverters._
      val attrs = node.attributes.keys.asScala.map(key => s""" $key="${node.attributes.value(key)}"""").mkString
      printer.print(s"""<$typ$id$classes$attrs>""")
      node.contentsNode.accept(visitor)
      printer.print(s"</$typ>")
    }
  }
},

paradoxDirectives += {
  import com.lightbend.paradox.markdown.Writer.Context
  import com.lightbend.paradox.markdown.InlineDirective

  (_: Context) => new InlineDirective("notes") {
    import org.pegdown.ast._
    import org.pegdown.Printer

    override def render(node: DirectiveNode, visitor: Visitor, printer: Printer): Unit = {
      printer.print(s"""<aside class="notes">""")
      node.contentsNode.accept(visitor)
      printer.print(s"</aside>")
    }
  }
}
)
}
