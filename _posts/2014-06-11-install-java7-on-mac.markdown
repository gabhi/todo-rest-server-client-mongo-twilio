---
layout: post
title:  "Install Java 7 on mac"
date:   2014-06-11 21:03:15
categories: JAVA install mac
---


1. Download java 7 installer from http://www.java.com/en/download/mac_download.jsp?locale=en
2. Run following commands

	cd /System/Library/Frameworks/JavaVM.framework/Versions

	sudo rm CurrentJDK

	sudo ln -s /Library/Java/JavaVirtualMachines/jdk1.7.0_60.jdk/Contents CurrentJDK





