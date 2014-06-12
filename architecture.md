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

		Hypermdeia response



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

