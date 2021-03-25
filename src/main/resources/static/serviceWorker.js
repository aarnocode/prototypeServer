// Flag for enabling cache in production
var doCache = true;

var CACHE_NAME = "prototype-app-cache";

// // Delete old caches
// self.addEventListener("activate", (event) => {
//   const currentCachelist = [CACHE_NAME];
//   console.log("Deleting cache");
//   event.waitUntil(
//     caches.keys().then((keyList) =>
//       Promise.all(
//         keyList.map((key) => {
//           if (!currentCachelist.includes(key)) {
//             return caches.delete(key);
//           }
//         })
//       )
//     )
//   );
// });



// This triggers when user starts the app
self.addEventListener("install", function (event) {
  if (doCache) {
    event.waitUntil(
      caches.open(CACHE_NAME).then(function (cache) {
            // We will cache initial page and the main.js
            // We could also cache assets like CSS and images
            const urlsToCache = [
              "/",
              "/index.html",
              "/static/css/2.4c97ca4f.chunk.css",
              "/static/css/main.3c0201c3.chunk.css",
              "/static/js/2.32a58afa.chunk.js",
              "/static/js/main.cd710114.chunk.js",
              "/static/js/bundle.js",
              "/static/js/vendors~main.chunk.js",
              "/static/js/main.chunk.js",
              "/firebase-messaging-sw.js",
              "/__/firebase/8.3.1/firebase-app.js",
              "/__/firebase/8.3.1/firebase-analytics.js",
              "/__/firebase/init.js",
              "/favicon.ico",
              "/manifest.json",
              "/logo192.png"
            ];
            cache.addAll(urlsToCache);
            console.log("cached");
      })
    );
  }
});

// Here we intercept request and serve up the matching files
self.addEventListener("fetch", function (event) {
  if (!navigator.onLine) {
    if (event.request.url === "https://prototypepushserver.herokuapp.com/") {
      event.waitUntil(
        this.registration.showNotification("Offline Mode", {
          body: "Hello, you are currently on offline mode",
        })
      );
    }
    event.respondWith(
      caches.match(event.request).then(function (response) {
          if(response){
            return response;
          }else{
            fetch(event.request);
          }
      })
    );

  }
});
