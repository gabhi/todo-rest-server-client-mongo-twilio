---
layout: page
title: Architecture
permalink: /architecture/
---

todo-rest-server-client-mongo-twilio
====================================

a simple todo client server app using mongodb and twilio sms notification


Architecture

SERVER
		server built using Jersey
			response type json/xml
			i18n
			Ping server

		Database
			pluggable
			interface for mongodb or filesystem or redis

		Error Handling
			response codes

		Mongodb REST ful resources
		Hypermdeia response

		CORS support


Client
		Angular js consuming the rest server

		allow option to select to send sms or email

Documentaion
		Swagger ui


Notification System
		Twilio


Social Networking 
		FB like
		Twitter share

Analytics
		Google Analytics
		Server side
		Mixpanel



URL:

Fron End: 
		http://serene-mountain-7282.herokuapp.com/

Spring Data Rest service: 
		http://safe-ocean-7286.herokuapp.com/

Documentation: 
		http://gabhi.github.io/todo-rest-server-client-mongo-twilio/

Web service: 
		http://thawing-sands-2974.herokuapp.com/

		
Example URI

	curl -i -X POST -H "Content-Type:application/json" -d '{  "title" : "Frodo",  "body" : "44444444Baggins2" }' http://localhost:5000/todo


curl -i -X POST -H "Content-Type:application/json" -d '{  "title" : "mash",  "body" : "ape", "done":true }' http://localhost:5000/todo


	curl -X PUT -H "Content-Type:application/json" -d '{ "title": "B", "body": "Bs" }' http://localhost:5000/todo/539a5b8b036409028784ed41




