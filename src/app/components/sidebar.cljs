(ns app.components.sidebar)

(defn sidebar
  [items content options]
  (let [{:keys [side no-stretch gap sidebar-width-rem content-min-width-pct]
         :or {side ::left no-stretch false gap false sidebar-width-rem 20 content-min-width-pct 50}} options
        sidebar-attrs {:style {:flex-basis (str sidebar-width-rem "rem")}}]
    [:div.flex.flex-wrap
     {:class (str
              (when no-stretch (str " " "items-start"))
              (when gap (str " " "gap-" gap)))}
     (when (= side ::left)
       [:div.grow.border-r sidebar-attrs items])
     [:div.basis-0 {:class (str "grow-[999] min-w-[" content-min-width-pct "%]")} content]
     (when (= side ::right)
       [:div.grow.border-l sidebar-attrs items])]))
