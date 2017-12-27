# Documentation

# Simple Chat Sample Project

instant messaging project designed to demonstrate WebSockets in a load-balanced environment. Users  login/logout, see a participant list, message, and notifications. 

##  Technologies/Design Decisions

Backend: Java 8 with Sprint Boot
Frontend: Angular.js
Database: Embedded H2
ORM: Hibernate
WebSocket messaging protocol: Stomp
WebSocket handler: Sock.js (with cross-browser fallbacks)
Session Management: Spring Session Redis
Security: Spring Security

## packaged 

This repo is for distribution on `npm` and `bower`. The source for this module is in the
[main AngularJS repo](https://github.com/angular/angular.js/tree/master/src/ngAnimate).
Please file issues and pull requests against that repo.

### Install

### npm

```shell
npm install angular-animate
```

Add a `<script>` to your `index.html`:

```html
<script src="/node_modules/angular-animate/angular-animate.js"></script>
```

Then add `ngAnimate` as a dependency for your app:

```javascript
angular.module('myApp', ['ngAnimate']);
```

Note that this package is not in CommonJS format, so doing `require('angular-animate')` will
return `undefined`.

### bower

```shell
bower install angular-animate
```

Then add a `<script>` to your `index.html`:

```html
<script src="/bower_components/angular-animate/angular-animate.js"></script>
```

Then add `ngAnimate` as a dependency for your app:

```javascript
angular.module('myApp', ['ngAnimate']);
```

## Setup and Run
1. Install system dependencies: latest versions (at the time of this writing) of Java, Redis, Node, NPM
2. `cd` to root of the project and execute `$ mvn spring-boot:run` or  (`$ mvn spring-boot:run -Drun.jvmArguments='-Dserver.port={{your port here}}'` if you wish to run a few servers)
3. Visit [http://localhost:8080/](http://localhost:8080) 

## Notes
- Chat messages are persisted to the database.
- Participant List is just every user in the session other than the current user (simple feature for demo, not meant to be realistic)
- Authentication users are not persisted to the database.
- Admin is the superuser and  password decided to admin.

## License
MIT
