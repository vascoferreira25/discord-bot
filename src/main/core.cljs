(ns core
  (:require ["discord.js" :as Discord]
            [config]))


(def client
  "New instance of client, notice the last `.`"
  (Discord/Client.))


;; Send login message and set activity
(defn login-message []
  (println "The bot is online.")
  ;; TODO: change the activity of the bot
  (.setActivity (.-user client) "Doin' random stuff")
  (-> client
      (.-channels)
      (.get config/general-chat-id)
      ;; TODO: message when the bot logs into a server
      (.send "How do you do me hearties.")))


;; Handle messages
(defn message-handler [message]
  ;; Ignore message if author is the client
  (if-not (= (.-author message) (.-user client))
    (cond
    ;; Mentioned
    ;; TODO: change the message when someone mentions the bot.
      (-> message (.isMentioned (.-user client)))
      (-> message
          (.-channel)
          (.send "Its a message for me"))
    ;; Specific words
    ;; TODO: add commands for the bot
      (-> message (.-content) (.startsWith "!bot"))
      (-> message
          (.-channel)
          (.send (str (-> message (.-author) (.toString))
                      ", hohoho who's the bot?!")))
    ;; Everything else
    ;; TODO: change what to do when users message between each other
      :else (-> message
                (.-channel)
                (.send "Just reading...")))))


(defn -main []
  (.on client "ready" login-message)
  (.on client "message" message-handler)
  (.login client config/token))
