# reveal.js theme for Paradox

This plugin extends the Paradox sbt plugin with useful directives and a theme
to create [Reveal.js](https://github.com/hakimel/reveal.js) presentations.

The main advantage is that this makes it easy to include code snippets from
this sbt projects.

## Usage

Write your presentation as a paradox page in src/main/paradox as described in the
[paradox documentation](https://developer.lightbend.com/docs/paradox/latest)

`sbt paradox` will generate the presentation and place it in
`target/paradox/main/site`

## Alternatives

This theme has been inspired by the excellent
[tut](https://github.com/tpolecat/tut). The main advantage of paradox is that
it supports snippets from files in other languages than Scala, and makes it
easy to maintain code snippets in an IDE. The advantage of tut is that it
allows including not just the code, but also the output that code would give
on the REPL.

## TODO

- generate page.st from upstream index.html
- clean up and document directives
- take reveal.js from a submodule rather than duplicating
- properly generate the akka theme
