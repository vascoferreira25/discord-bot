# Discord Bot

A Discord Bot made with Clojurescript.

## Steps

1. Clone this repo

    ``` shell
    git clone https://github.com/vascoferreira25/
    ```

2. Edit the config file and change your bot token and channel id.
    You can get a token in the discord bot page and the channel id
    can be seen by the admin of a server by right clicking the chanel
    and selecting `Copy ID`.

3. Edit the login message, the commands and the interactions with users
4. Have fun with your bot, make a game, handle questions or make several bots
talk to each other.

## How to run

1. Compile the program to js

    For some reason `release` doesn't work so use `compile` instead.

    ``` shell
    shadow-cljs compile app
    ```

2. Run with node

    ``` shell
    node target/main.js
    ```

3. Have fun with your bot