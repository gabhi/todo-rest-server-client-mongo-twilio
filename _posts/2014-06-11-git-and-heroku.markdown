---
layout: post
title:  "GIT and Heroku!"
date:   2014-06-11 21:03:15
categories: jekyll update
---

Git is a powerful decentralized revision control system, and is the means for deploying apps to Heroku. You don’t need to be proficient with Git to use it for deploying code to Heroku, but you may find it valuable to learn the basics.
Tracking your app in git

Heroku apps expect the app directory structure at the root of the repository. If your app is inside a subdirectory in your repository, it won’t run when pushed to Heroku.
Before you can push an app to Heroku, you’ll need to initialize a local Git repo and commit your files to it. For example, if you have an app in a directory, myapp, then create a new repo for it:
$ cd myapp
$ git init
Initialized empty Git repository in .git/
$ git add .
$ git commit -m "my first commit"
Created initial commit 5df2d09: my first commit
 44 files changed, 8393 insertions(+), 0 deletions(-)
 create mode 100644 README
 create mode 100644 Procfile
 create mode 100644 app/controllers/source_file
...
This is a local repository, now residing inside the .git directory. Nothing has been sent anywhere yet; you’ll need to create a remote and do a push to deploy your code to Heroku.
Creating a Heroku remote

Git remotes are references to remote repositories. You can have any number of these, but for now we’ll focus on just the remote to Heroku. The heroku create command creates a new application on Heroku – along with a git remote that must be used to receive your application source.
$ heroku create
Creating falling-wind-1624... done, stack is cedar
http://falling-wind-1624.herokuapp.com/ | git@heroku.com:falling-wind-1624.git
Git remote heroku added
Heroku’s git remotes use SSH as a transport, so you’ll need to make sure your SSH public key has been added to your Heroku account.
You can verify the remote in your git configuration as well:
$ git remote -v
heroku     git@heroku.com:falling-wind-1624.git (fetch)
heroku     git@heroku.com:falling-wind-1624.git (push)
You can also take an existing Git repo and add a remote using the git URL provided when you created your app. You may need to do this to associate a Git repo with an existing application. The heroku git:remote command will add this remote for you based on your applications git url.
$ heroku git:remote -a falling-wind-1624
Git remote heroku added.
The remote is named heroku in this example, but you can name the remote anything you want by passing -r other_remote_name. You may find it easier to follow the examples if you stick to using the heroku remote rather than using one with a different name.
There is one special remote name: origin, which is the default for pushes. Using origin as the remote name will allow you to type just git push instead of git push heroku, but we recommend using an explicitly named remote.
Deploying code

Your Heroku app starts with a blank repository – it has no branches and no code. So the first time you deploy, you’ll need to specify a remote branch to push to. You can do your first push:
$ git push heroku master
Initializing repository, done.
updating 'refs/heads/master'
...
This will push your code to the heroku remote, created earlier. Use this whenever you want to deploy the latest code committed in Git to Heroku.
At beginning of your first build, Initializing repository will be displayed while your app’s repository is being is being created on Heroku. On subsequent builds, Fetching repository will be displayed while your app’s repository is being is being fetched and prepared to accept your push.
Branches pushed to Heroku other than master will be ignored by this command. If you’re working out of another branch locally, you can either merge to master before pushing, or specify that you want to push your local branch to a remote master. To push a branch other than master, use this syntax:
$ git push heroku yourbranch:master
Applications that rely on git submodules are supported, in addition to many other dependency resolution strategies.
Canceling a deployment

When deploying code using git push, you can interrupt the build process on Heroku by pressing Ctrl + C on your machine. As long as this is not done as the build process completes (generally around the “Launching…” message), and you’ve taken latency into account, then it will halt the build process and no new release will be generated.
Multiple remotes and environments

The same techniques used to deploy to production can be used to deploy a development branch of your application to a staging application on Heroku, as described in Managing Multiple Environments for an App.
Build cache

Buildpacks can optionally cache content for re-use between builds. A typical use-case for the buildpack is to speed up builds by caching dependencies so that they don’t have to be re-fetched on every build. This greatly speeds up builds.
If you suspect that a build-problem is related to this caching, you can use the heroku-repo plugin to clear the cache.
Repo size

While there is not a hard limit on your repository size, very large repositories (over 600MB) are not recommended; they may cause timeouts and slow pushes overall. Running heroku apps:info will show you your repository size. The app build cache is stored inside the app repository, so don’t be surprised if the repository is larger remotely than locally.
Common causes of large repositories are binary files checked into the repo (git is notoriously bad at handling binaries) or constantly-changing development logs. Removing files committed by accident can be done with git filter-branch, though after running it you will have to push with the --force option, which is something that requires coordination among your team.
Other limits

To protect the Git service, users are limited to a rolling window of 75 Git requests per hour, per SSH key. Once this limit is reached, Git requests are denied until request levels dropped below the limit for a few minutes, with the error message:
 !  Too many requests for this Git repo. Please try again later.
If you reach this limit, ensure there are not automated processes or scripts polling the Git repo.
Using subversion or other revision control systems

What if you’re already using Subversion or another revision control system to track your source code? Although we believe that Git is one of the best choices available for revision control, you don’t need to stop using your current revision control system. Git can be purely a deployment mechanism, existing side-by-side with your other tool.
You can learn much more about .gitignore in our article on the topic.
For example, if you are using Subversion, initialize your Git repo as described above. Then, add a .gitignore file to tell Git to ignore your Subversion directories.
$ git init
$ echo .svn > .gitignore
$ git add .
$ git commit -m "using git for heroku deployment"
Now tell Subversion to ignore Git:
$ svn propset svn:ignore .git .
property 'svn:ignore' set on '.'
$ svn commit -m "ignoring git folder (git is used for heroku deployment)"
The -f (force flag) is recommended in order to avoid conflicts with other developers' pushes. Since you are not using Git for your revision control, but as a transport only, using the force flag is a reasonable practice.
Each time you wish to deploy to Heroku:
$ git add -A
$ git commit -m "commit for deploy to heroku"
...

$ git push -f heroku
Additional resources

Git on Rails shows common conventions for using Git to track Rails apps.
Git cheat sheets for web and print consumption.
Git - SVN Crash Course
Pro Git and The Git Community Book are great books covering all of Git.