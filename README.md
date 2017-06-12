Material design theme for Vaadin Framework 8
==============

[Live demo ↗](http://jouni.app.fi/material-theme-fw8-1.0.0-alpha1/)

A Sass based Material design theme for Vaadin Framework 8. Not based on the Vaadin Framework Valo theme.

Contains multiple [custom components](https://github.com/vaadin/material-theme-fw8/tree/master/src/main/java/org/test/components) on top of Sass/CSS, such as a modern [Flexbox based layout](https://github.com/vaadin/material-theme-fw8/blob/master/src/main/java/org/test/layout/FlexLayout.java).

Workflow
========

To compile the entire project, run \"mvn install\".

To run the application, run \"mvn jetty:run\" and open http://localhost:8080/ .

To produce a deployable production mode WAR:
- change productionMode to true in the servlet class configuration (nested in the UI class)
- run \"mvn clean package\"
- test the war file with \"mvn jetty:run-war\"


Developing a theme using the runtime compiler
-------------------------

When developing the theme, Vaadin can be configured to compile the Sass based
theme at runtime in the server. This way you can just modify the scss files in
your IDE and reload the browser to see changes.

To use the runtime compilation, open pom.xml and comment out the compile-theme 
goal from vaadin-maven-plugin configuration. To remove a possibly existing 
pre-compiled theme, run \"mvn clean package\" once.

When using the runtime compiler, running the application in the \"run\" mode 
(rather than in \"debug\" mode) can speed up consecutive theme compilations
significantly.

It is highly recommended to disable runtime compilation for production WAR files.

Using Vaadin pre-releases
-------------------------

If Vaadin pre-releases are not enabled by default, use the Maven parameter
\"-P vaadin-prerelease\" or change the activation default value of the profile in pom.xml .
