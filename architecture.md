---
layout: page
title: Architecture
permalink: /architecture/
---

todo-rest-server-client-mongo-twilio
====================================

a simple todo client server app using mongodb and twilio sms notification

 
<img src="{{site.baseurl}}/assets/architecture.png">

Architecture

SERVER
		server built using Jersey
			response type json
			
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

		allow option to select to send sms/email

Documentaion
				Jekyll


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

Search Service:
		http://obscure-waters-1043.herokuapp.com/search?q=3
		




