# Apache Solr Demo

Introduction
================
Using SolrJ

<p>Maven</p>
<p>Spring MVC</p>
<p>Apache Solr</p>

Server
================

<p>Download Solr <a href="http://lucene.apache.org/solr/">http://lucene.apache.org/solr/</a></p>

<p>Create Core</p>
<p><code>./solr create_core -c news</code></p>
<p>Start Solr</p>
<p><code>./solr start -f</code></p>

Build
================

<p><code>mvn -Dmaven.test.skip=true install</code></p>

Run
================

<p>Deploy Tomcat</p>

<p><code>http://localhost:9090/solr-web/index/add</code></p>
<p><code>http://localhost:9090/solr-web/index/list</code></p>
<p><code>http://localhost:9090/solr-web/index/del</code></p>