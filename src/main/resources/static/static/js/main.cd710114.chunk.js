(this["webpackJsonpprototyp-app"]=this["webpackJsonpprototyp-app"]||[]).push([[0],{41:function(e,t,n){},42:function(e,t,n){},43:function(e,t,n){},44:function(e,t,n){},46:function(e,t,n){},70:function(e,t,n){"use strict";n.r(t);var o=n(2),s=n.n(o),c=n(16),a=n.n(c),i=(n(41),n(9)),r=(n(42),n(43),n(44),n(4)),u=function(e){var t=Object(o.useState)("What's your guess?"),n=Object(i.a)(t,2),s=n[0],c=n[1],a=Object(o.useState)(""),u=Object(i.a)(a,2),b=u[0],j=u[1],l=Object(o.useState)(!0),d=Object(i.a)(l,2),h=d[0],p=d[1];return Object(r.jsxs)("div",{hidden:e.isVisible,children:[Object(r.jsx)("p",{children:"( 1 - 99 )"}),Object(r.jsx)("input",{className:"input",type:"text",maxLength:"2",onChange:function(e){var t;(""===(t=e.target.value)||/^[0-9\b]+$/.test(t))&&(c("What's your guess?"),j(t))},value:b}),Object(r.jsx)("br",{}),Object(r.jsx)("button",{className:"button",hidden:!h,onClick:function(){b>e.number?b-e.number<5?c("Almost!! Guess lower"):c("Lower number"):b<e.number?e.number-b<5?c("You're close!! Try raising your number"):c("Try a higher number"):(c("You guessed it! It's "+e.number),p(!1),navigator.serviceWorker.getRegistration("/").then((function(e){e.showNotification("Congratulations",{body:"You just guessed the number!"})})))},children:"Guess"}),Object(r.jsx)("p",{children:Object(r.jsx)("strong",{children:s})}),Object(r.jsx)("button",{className:"button",hidden:h,onClick:function(){e.generate(),c("What's your guess?"),j(""),p(!0)},children:"Play again?"})]})},b=function(){var e=Object(o.useState)(0),t=Object(i.a)(e,2),n=t[0],s=t[1],c=Object(o.useState)(!1),a=Object(i.a)(c,2),b=a[0],j=a[1],l=Object(o.useState)(!0),d=Object(i.a)(l,2),h=d[0],p=d[1],O=function(){s(Math.floor(98*Math.random())+1)};return Object(r.jsxs)("div",{className:"containerNative",children:[Object(r.jsx)("h3",{children:"GUESS THE NUMBER"}),Object(r.jsx)(u,{isVisible:h,number:n,generate:O}),Object(r.jsx)("button",{className:"button",onClick:function(){j(!0),p(!1),O()},hidden:b,children:"Start Game"})]})},j=(n(46),n(18)),l=n.n(j),d=function(e){var t=Object(o.useState)(""),n=Object(i.a)(t,2),s=n[0],c=n[1],a=Object(o.useState)("Show Firebase Token"),u=Object(i.a)(a,2),b=u[0],j=u[1],d=Object(o.useState)(!0),h=Object(i.a)(d,2),p=h[0],O=h[1],g=Object(o.useState)(!0),f=Object(i.a)(g,2),m=f[0],x=f[1],y=Object(o.useState)(!0),v=Object(i.a)(y,2),k=v[0],S=v[1];return Object(r.jsxs)("div",{children:[Object(r.jsx)("button",{className:"button",onClick:function(){!0===p?(navigator.onLine?c(e.tkn):c("You are offline, cannot generate firebase token."),j("Hide Firebase Token"),O(!1),x(!1)):(j("Show Firebase Token"),O(!0),x(!0),S(!0))},children:b}),Object(r.jsx)("br",{}),Object(r.jsx)("textarea",{className:"textarea",hidden:p,value:s}),Object(r.jsx)("br",{}),Object(r.jsx)("p",{className:"warn",hidden:k,children:"Successfully copied!"}),Object(r.jsx)("br",{}),Object(r.jsx)("button",{className:"button",hidden:m,onClick:function(){navigator.clipboard.writeText(e.tkn),S(!1)},children:"Copy"}),Object(r.jsx)("button",{className:"button",hidden:m,onClick:function(){l.a.post("https://prototypepushserver.herokuapp.com/push/user",{title:"Hello there!",message:"I've been requested from reactjs",topic:"",token:s},{headers:{"Content-Type":"application/json"}}).then((function(e){console.log(e)})).then((function(e){console.log(e)}))},children:"Push Notif"})]})},h=n(73),p=(n(64),function(e){var t=Object(o.useState)(0),n=Object(i.a)(t,2),s=(n[0],n[1],Object(o.useState)("just now")),c=Object(i.a)(s,2),a=c[0];c[1];return Object(o.useEffect)((function(){})),Object(r.jsxs)(h.a,{onClose:function(){return e.setShow(!1)},show:e.show,delay:5e3,autohide:!0,animation:!0,style:{position:"absolute",top:20,right:20},children:[Object(r.jsxs)(h.a.Header,{children:[Object(r.jsx)("img",{src:"holder.js/20x20?text=%20",className:"rounded mr-2",alt:""}),Object(r.jsx)("strong",{className:"mr-auto",children:e.payload.title}),Object(r.jsx)("small",{children:a})]}),Object(r.jsx)(h.a.Body,{children:e.payload.body})]})}),O=n(17);O.a.initializeApp({apiKey:"AIzaSyCPNhBH4P3wTs05G-FoDi-RUR2RsM2ZG8A",authDomain:"prototype-app-2ce47.firebaseapp.com",projectId:"prototype-app-2ce47",storageBucket:"prototype-app-2ce47.appspot.com",messagingSenderId:"1054726933042",appId:"1:1054726933042:web:a66b173a713db950dc4a2b",measurementId:"G-XE02ZTB1JV"}),console.log(O.a.messaging);var g=O.a;var f=function(){var e=Object(o.useState)({title:"",body:""}),t=Object(i.a)(e,2),n=t[0],s=t[1],c=Object(o.useState)(!1),a=Object(i.a)(c,2),u=a[0],j=a[1],h=Object(o.useState)(""),f=Object(i.a)(h,2),m=f[0],x=f[1];return Object(o.useEffect)((function(){return g.messaging().getToken().then((function(e){console.warn("token",e),l.a.post("https://prototypepushserver.herokuapp.com/subscribe",{title:"",message:"",topic:"",token:e},{headers:{"Content-Type":"application/json"}}).then((function(e){console.log(e)})),x(e)}))})),new Promise((function(e){O.a.messaging().onMessage((function(t){e(t)}))})).then((function(e){j(!0),s({title:e.notification.title,body:e.notification.body}),console.log(e)})).catch((function(e){return console.log("failed",e)})),Object(r.jsxs)("div",{className:"App",children:[Object(r.jsx)(b,{}),Object(r.jsx)(d,{tkn:m}),Object(r.jsx)(p,{show:u,setShow:j,payload:n})]})},m=function(e){e&&e instanceof Function&&n.e(3).then(n.bind(null,74)).then((function(t){var n=t.getCLS,o=t.getFID,s=t.getFCP,c=t.getLCP,a=t.getTTFB;n(e),o(e),s(e),c(e),a(e)}))};(function(){"serviceWorker"in navigator?window.addEventListener("load",(function(){navigator.serviceWorker.register("serviceWorker.js").then((function(e){console.log("Worker registration successful",e.scope)}),(function(e){console.log("Worker registration failed",e)})).catch((function(e){console.log(e)}))})):console.log("Service Worker is not supported by browser.")})(),a.a.render(Object(r.jsx)(s.a.StrictMode,{children:Object(r.jsx)(f,{})}),document.getElementById("root")),m()}},[[70,1,2]]]);
//# sourceMappingURL=main.cd710114.chunk.js.map