# Apache Solr Demo

Introduction
================
Using SolrJ

<p>Maven</p>
<p>Spring MVC</p>
<p>Apache Solr</p>

Server
================

Download Solr <a href="http://lucene.apache.org/solr/">http://lucene.apache.org/solr/</a>

Create Core
<code>./solr create_core -c news</code>
Start Solr
<code>./solr start -f</code>

Build
================

<code>mvn -Dmaven.test.skip=true install</code>

Run
================

<p>Deploy Tomcat</p>

<code>http://localhost:9090/solr-web/index/add</code>
<code>http://localhost:9090/solr-web/index/list</code>
<code>http://localhost:9090/solr-web/index/del</code>