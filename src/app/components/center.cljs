(ns app.components.center)

(defn center
  [content]
  [:div.box-content.ml-auto.mr-auto
   {:class "max-w-[90ch]"}
   content])
