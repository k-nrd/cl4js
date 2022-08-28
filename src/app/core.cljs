(ns app.core
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [reagent.dom :as rdom]
            [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [app.components.center :refer [center]]
            [app.components.sidebar :refer [sidebar]]))

(def function-url (str (. js/window -location) "api/hello"))

(defn- invoke-function
  []
  (go (let [response (<! (http/get function-url))]
        (js/console.log (:body response)))))

(defn app
  []
  [:div.min-w-full.min-h-full
   [center
    [sidebar
     [:div.flex.flex-col.pt-4
      [:div.w-full.flex.justify-center [:h1.text-4xl.font-bold "cl4js"]]
      [:div.h-screen.w-full]]
     [:div.flex.flex-col.pt-4 "yolo"]]]])

(defn start []
  (rdom/render [app] (. js/document (getElementById "app"))))

(defn ^:export init []
  ;; init is called ONCE when the page loads
  ;; this is called in the index.html and must be exported
  ;; so it is available even in :advanced release builds
  (start))

(defn stop []
  ;; stop is called before any code is reloaded
  ;; this is controlled by :before-load in the config
  (js/console.log "stop"))
