importScripts("https://www.gstatic.com/firebasejs/8.3.1/firebase-app.js");
importScripts("https://www.gstatic.com/firebasejs/8.3.1/firebase-messaging.js");

const firebaseConfig = {
    apiKey: "AIzaSyCPNhBH4P3wTs05G-FoDi-RUR2RsM2ZG8A",
    authDomain: "prototype-app-2ce47.firebaseapp.com",
    projectId: "prototype-app-2ce47",
    storageBucket: "prototype-app-2ce47.appspot.com",
    messagingSenderId: "1054726933042",
    appId: "1:1054726933042:web:a66b173a713db950dc4a2b",
    measurementId: "G-XE02ZTB1JV",
  };

firebase.initializeApp(firebaseConfig);

const initMessaging = firebase.messaging();

