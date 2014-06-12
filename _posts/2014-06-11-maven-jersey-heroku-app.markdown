---
layout: post
title:  "Jersey maven generator"
date:   2014-06-11 21:03:15
categories: maven jersey heroku
---


1. Run following command so that Maven will generate a jersey app which can be deployed on heroku

	
{% highlight ruby %}
	mvn archetype:generate -DarchetypeArtifactId=jersey-heroku-webapp \
                -DarchetypeGroupId=org.glassfish.jersey.archetypes -DinteractiveMode=false \
                -DgroupId=com.example -DartifactId=todo-rest-server-client-mongo-twilio -Dpackage=com.example \
                -DarchetypeVersion=2.9

               {% endhighlight %}


2. heroku create
3. git add src/ pom.xml Procfile system.properties
4. git commit -a -m "initial commit for heroku"
5. git push heroku master


setting up searchly

setting up mongolab
	mongodb://demo:demo@ds029297.mongolab.com:29297/mytodo
