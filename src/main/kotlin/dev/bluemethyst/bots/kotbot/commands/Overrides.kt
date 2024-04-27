package dev.bluemethyst.bots.kotbot.commands

import me.jakejmattson.discordkt.commands.commands

fun info() = commands("info") {
    text("help"){ execute { } }
    text("info"){ execute { } }
}