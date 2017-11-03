leila-json
==========

*leila-json* is a demo plugin for the tool [leila](https://github.com/raymanrt/leila).

*leila-json* demonstrates simply how can be implemented a custom formatting plugin for *leila*.

*leila-json* serialize each *lucene* Document extracted with *leila* into a standard json.

It consists of a single class `JsonFormatter` whith just one constructor. If the constructor receives the `pprint`
argument, then the output will be pretty printed.

The class ha just one public method, which receives a Document and returns a String, representing the json.

Dependencies:
* gson 2.8.0
* lucene-core 4.10.4

This software is open-source, released under [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0),
and made without any commercial intent. Please feel free to contribute, especially if you find *leila* usefull and
discover some bug or missing feature.
The non-exhaustive feature request list is at the bottom of this page.

Build from source
-----------------

*leila-json* source can be downloaded from this repository and can be build with maven. The requirements are a JVM compatible
with Java 1.8 version.

```
git clone https://github.com/raymanrt/leila-json.git
cd leila-json
mvn clean package
ls target/leila-json.jar
```

A portable fat jar is build which includes every dependency required to use leila-json in bundle with leila.

Using leila-json
----------------

To make leila-json visible to leila you should run the leila Main with the java command, not forgetting to include the
generated jar in your classpath, for example:
```
java -cp 'target/leila.jar:../leila-json/target/leila-json.jar' com.github.raymanrt.leila.Main \
    target/demo-index \
    -p com.github.raymanrt.leila.json.JsonFormatter pprint
```

Please remember the syntax for the `-p` option:
* the first argument is the path of the desired class
* the following arguments are the builder parameters

Limits and desired functions
----------------------------

* *leila-json* considers each document as having only String values (or list of String values);
with more configuration it should be easy make it cast one or more fields to some custom type;
also some kind of type inference could be considered