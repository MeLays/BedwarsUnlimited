![https://i.ibb.co/HhJ7b3G/bwunlimited.png](https://i.ibb.co/HhJ7b3G/bwunlimited.png)
**[B]Need help? Found a bug? Got a nice idea?
Add me on discord! mEMES#0001**[/B]
**[B]≫**⚊ [/B]Youtube Video** ⚊➤**
[INDENT]**[SPOILER="Deutsch (German)"]
[MEDIA=youtube]VgHQdAI2hsw[/MEDIA]
[MEDIA=youtube]8xoUwLa7Id0[/MEDIA]
[/SPOILER]**[/INDENT]
** ≫**⚊ What is "**Bedwars Unlimited**" ? ⚊➤
[INDENT]Bedwars Unlimited doesn't work like your normal spigot gamemode. It works like a "arena on-demand" system.
It is made for BungeeCord networks since it takes a complete spigot server to work but it is also an multi-arena plugin.
Bedwars Unlimited gets configured by providing it "clusters", which are arena presets. Whenever a arena is needed it will generate a new one by copying the cluster to a different world.
With the mechanic the plugin is able to let 1000 player play on your server in different arenas and you only needed to setup it once.
[SPOILER="Deutsch (German)"][/SPOILER][SPOILER="Deutsch (German)"]
[COLOR=rgb(0, 179, 0)]Bedwars Unlimited funktioniert nicht wie jeder andere Spigot Spielmodus. Es ist eher ein "Arena auf Abruf"-System.
Es wurde für BungeeCord Server entwickelt, da es einen gesamten Spigot Server einnimmt, ist jedoch trotzdem ein Multiarena Plugin.[/COLOR]
Bedwars Unlimited funktioniert mit "Clustern", was quasi Vorlagen für Arenen sind. Wenn eine Arena benötigt wird, wird der Cluster in eine andere Welt kopiert und eine neue Arena auf dieser Map erstellt.
[COLOR=rgb(0, 0, 0)]Mit dieser Technik kannst du eine Arena einrichten und 1000 Spieler darauf spielen lassen![/COLOR]
[/SPOILER][/INDENT]
**≫**⚊ What are the core features ? ⚊➤
[INDENT]
* Its **FREE **and Open Source!
* Unlimited arenas on one server with **no extra work**!
* Unlimited teams and team sizes!
* 1vs1, 2vs2, ... Challenger System
* Sign System that automatically provides new arenas when needed
* A settings menu to let you players customize their experience
* Super efficient map generator
* **ALL **messages, items, inventory titles and scoreboards 100% configurable
* A "rewinside.tv"-like configurable shop
* A built-in party/group system

[SPOILER="Deutsch (German)"]
 [/SPOILER][SPOILER="Deutsch (German)"]

* **Kostenlos **und Open-Source!
* Unendlich viele Arenen auf einem Server ohne extra Arbeit!
* Unendlich viele Teams mit unendlicher Größe!
* 1vs1, 2vs2, ... Challenger System
* Ein Schildersystem das automatisch neue Arenen bereitstellt wenn diese benötigt werden.
* Ein Einstellungsmenü dass Spieler ihr eigenes Spiel einstellen lässt.
* Ein extrem effizienter Map-Generator.
* **ALLE **Nachrichten, Items, Inventare und Scoreboard komplett einstellbar.
* Ein "rewinside.tv" ähnlicher Shop (einstellbar)
* Ein eingebautes Party / Group - System

[/SPOILER][/INDENT]
**≫**⚊ How to setup ⚊➤

[INDENT]What you** need to know:**
[INDENT]Bedwars Unlimited already contains a lot of stuff. You don't need a lot of extra plugins. **Dont **use a multiword plugin. **Dont **use a Tablist plugin. **Dont **use a scoreboard plugin. **Dont **use a chat plugin. **Dont **install other gamemodes on the server where Bedwars Unlimited is installed.
[/INDENT]
The 3 worlds used by the plugin:
[INDENT]![https://i.ibb.co/MGzhCPJ/worlsd.jpg](https://i.ibb.co/MGzhCPJ/worlsd.jpg)
[/INDENT]
How to **install**:
[INDENT]
1. Use a clean spigot server.
1. Put the BWUnlimited.jar in the plugins-folder and **restart (no reload)**
1. Build or copy your lobby and your waiting room in the default world.
1. Set the lobby spawn with /bw lobby setlobby
1. Set the waiting room spawn with /bw lobby setgamelobby
1. Restart/reload the server and reconnect
1. You should receive the lobby items (this indicates that the plugin is ready)
[/INDENT]
Create a cluster:

1. Teleport to the cluster world (/bw worldtp presets)
1. **If you already have the map** you want to add to the game, paste the map in the world. Use /bw cluster gettool to receive a WorldEdit-like wand. Use this wand to mark you arenas region. **Important**: Leave space between the map and the border you select because the area you select is also the playing-arena. Players cant leave this area. When you are done use /bw cluster create <name> to save it.
1. **If you want to build a map **I added a handy tool the generates a border for you with preset recommendations for spawn points. Use /bw cluster createWithTemplate to view the help on how the command works. You **dont **need to use /bw cluster create <name> to save it.
1. Continue when the preset is complete and you built everything. Now we will create teams. Teams are global so if you already created a green team for 2 players you can use that on all clusters. Create a team by entering /bw teams create <name> <displayname> <color> <max-players>. The <name> will only be used internally. The display name will be shown the the players (dont add Colorcodes there). The list of available colors: /bw colorlist.
1. After you created all the teams you need, you add them to the cluster by doing /bw setup addteam <cluster> <team>
1. Then you set the team spawns. Your head-rotation will be saved too. Do /bw setup setteamspawn <cluster> <team> for all teams.
1. Then add shops. This is easy. Just do /bw setup addshop <cluster> at the desired locations.
1. The last thing you need are the item spawners. The command is /bw setup addspawner <cluster> <Material> <Ticks> <Displayname>. The Material is the [Spigot Material']('http://docs.codelanx.com/Bukkit/1.8/org/bukkit/Material.html')s name. The ticks is the time between the spawns.
1. **Optional steps:** Add a custom displayname to the cluster using /bw setup setdisplayname and a custom displayitem using /bw setup setdisplayitem.
1. Enable the cluster using /bw cluster enable <cluster>
1. **Optional**: If you want your cluster to show up in the challenger menu use: /bw lobby addchallengercluster <cluster>. This only works with clusters that have 2 even teams.

Create a **sign**:
[INDENT]Creating signs is super easy. Just put a sign in your lobby and write "[Template]" in the fist line. Put you cluster name in the second line and you are done.
[/INDENT]
[SPOILER="ADVANCED: The category system"]
This plugin gives every arena it starts an category. The defaults are the "template_sign"-category for sign started games and the "challenger"-category for games started using the challenger item.
If you add a 3rd line to your sign you can define its category. For example putting there "no_bows" would start the arena in the category "no_bows".

So what ? Categories can be used to filter items and drops from certain arenas. In the shop.yml you can disable shop-categories and single items for some categories. So lets say you disable the category "no_bows" in the shop-category "Bows" you wont be able to buy Bows in arenas that were started using signs in the category "no_bows". The same is for itemspawners in the clusters.yml. You can give them the flag  "disable_in_categories" and add categories in which the spawners wont drop.
[/SPOILER]
[INDENT][/INDENT][/INDENT]
**[B]≫**[/B]⚊ Commands and Permissions ⚊➤
[INDENT]
* /bw reload - "bwunlimited.reload"
* /bw - (all setup commands) "bwunlimited.setup"
* /spectate - (this is an Admin / Moderator command!) "bwunlimited.spectatecommand"
* /start - (for VIPs and Staff etc.) "bwunlimited.start"
* /group - no permission needed
* /leave - no permission needed

Other permissions:

* In the config you can set permissions for individual group sizes: (* means infinite)
    group_size_permission:
    - bw.group.4->4
    - bw.group.8->8
    - bw.group.*->*
[/INDENT]
**
≫**⚊ Questions and Answers ⚊➤
[INDENT][SPOILER="Am I able to disable the Challenger Item ?"]
Yes you are. In config.yml in "lobby -> challenger" you can set enabled to false.
[/SPOILER]
[SPOILER="Am I able to disable the Settings Item ?"]
Yes you are. In config.yml in "lobby -> settings" you can set enabled to false.
[/SPOILER]
[SPOILER="The special characters don't show up as expected"]
If the special characters in chat and tab look strange and your config contains stuff like "\xbb" you need to change the Java file-encoding to UTF8. You can do this by adding "-Dfile.encoding=UTF-8" to your startfile.

The command look like this: java ... -Dfile.encoding=UTF-8 -jar spigot...jar

Unfortunately you need to reset the config files to restore the working string messages.
[/SPOILER][/INDENT]

**≫**⚊ Known Bugs and TODO list ⚊➤
[INDENT][SPOILER="Known Bugs"]

* When somebody gets killed the hearts in the killing message can be completely wrong. Hotfix: Remove the "%lifes%" variable from the death_killed message in messages.yml

[/SPOILER]
[SPOILER="TODO"]

* Add a "/stats"-Command
* Finish the game-queue (currently not working)
* Add the ability to customize the category of the signs which allows you for example to enable/disable shop items on certain arenas or it allows you to better organize the spectate menu
* Add a "itemdrop on death" flag

[/SPOILER][/INDENT]
