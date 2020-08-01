# SimpleSleep
## Intro
Exactly what it says on the tin. A simple sleep plugin without unnecessary/unwanted/unused features.<br>
All configurable from a single config file.<br>
It is aimed to be all pretty self explanatory.<br>
Please let me know if you have any issues.
<br>
## Default Config
    #---Configuration Options---
    #You can either use a percentage of players online, or an absolute number.
    #sleeping_type can be set to either PERCENTAGE or ABSOLUTE
    sleeping_type: "PERCENTAGE"
    percentage_amount: 10
    absolute_amount: 1
    
    #World name for the main world. This will generally just be "world"`
    world_name: "world"
    
    #---Chat Messages---
    #'[player]' will be replaced by the player's name.
    #For example:
    #If player OffJosh_ gets into a bed the bed_entered_message will go from '&3[player] has entered bed.' and become '&3OffJosh_ has entered bed.'
    bed_entered_message: "&3[player] has entered bed."
    bed_left_message: "&3[player] has left bed."
    skipped_night_message: "&3Skipped the Night."
    
    #<sleepingPlayers> is the amount of players sleeping at the time.
    #<neededPlayers> is the amount of players needed to skip the night.
    sleeping_needed_message: "&3<sleepingPlayers>/<neededPlayers> sleeping."
