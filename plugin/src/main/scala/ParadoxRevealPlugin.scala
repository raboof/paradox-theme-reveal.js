package net.bzzt.paradox.reveal.js

import sbt._
import sbt.Keys.resolvers
import com.lightbend.paradox.sbt.ParadoxPlugin

object ParadoxRevealPlugin extends AutoPlugin {
  import ParadoxPlugin.autoImport._

  override def requires = ParadoxPlugin

  override def projectSettings: Seq[Setting[_]] = Seq(
    resolvers += Resolver.bintrayRepo("raboofje", "maven"),
    paradoxTheme := Some("net.bzzt" % "paradox-theme-reveal-js" % BuildInfo.version),
    paradoxDirectives += {
      import com.lightbend.paradox.markdown.Writer.Context
      import com.lightbend.paradox.markdown.WrapDirective

      (_: Context) =>
        new WrapDirective("section") {
          import org.pegdown.ast._
          import org.pegdown.Printer

          override def render(node: DirectiveNode,
                              visitor: Visitor,
                              printer: Printer): Unit = {
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
            val attrs = node.attributes.keys.asScala
              .map(key => s""" $key="${node.attributes.value(key)}"""")
              .mkString
            printer.print(s"""<$typ$id$classes$attrs>""")
            node.contentsNode.accept(visitor)
            printer.print(s"</$typ>")
          }
        }
    },
    paradoxDirectives += {
      import com.lightbend.paradox.markdown.Writer.Context
      import com.lightbend.paradox.markdown.Directive

      (_: Context) =>
        new Directive() {
          import org.pegdown.ast._
          import org.pegdown.Printer
          import org.pegdown.ast.DirectiveNode

          override val names = Seq("notes", "notes".toUpperCase)
          override val format = Set(DirectiveNode.Format.ContainerBlock, DirectiveNode.Format.Inline)

          override def render(node: DirectiveNode,
                              visitor: Visitor,
                              printer: Printer): Unit = {
            val id =
              node.attributes.identifier match {
                case null => ""
                case x    => s""" id="$x""""
              }
            import scala.collection.JavaConverters._
            val classes = ("notes" +: node.attributes.classes.asScala).mkString(" ")
            val attrs = node.attributes.keys.asScala
              .map(key => s""" $key="${node.attributes.value(key)}"""")
              .mkString
            printer.print(s"""<aside$id class="$classes"$attrs>""")
            node.contentsNode.accept(visitor)
            printer.print(s"</aside>")
          }
        }
    }
  )
}
