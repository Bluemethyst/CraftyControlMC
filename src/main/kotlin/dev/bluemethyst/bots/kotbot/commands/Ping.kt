package dev.bluemethyst.bots.kotbot.commands

import me.jakejmattson.discordkt.arguments.AnyArg
import me.jakejmattson.discordkt.arguments.IntegerArg
import me.jakejmattson.discordkt.commands.commands
import me.jakejmattson.discordkt.conversations.slashConversation
import me.jakejmattson.discordkt.conversations.conversation
import me.jakejmattson.discordkt.dsl.menu
import kotlin.math.roundToInt

fun basics() = commands("Basics") {
    slash("Ping", "Check the bots latency") {
        execute {
            val ping = discord.kord.gateway.averagePing
            val pingInFloat = ping?.inWholeMilliseconds?.toFloat()
            val roundedPing = pingInFloat?.roundToInt()
            respondPublic {
                title = "Bot Latency: ${roundedPing}ms"
                color = discord.configuration.theme
            }
        }
    }
    slash("Info", "Get information about the bot") {
        execute {
            val bot = discord.kord.getSelf()
            respondPublic {
                title = "Bot Information"
                description = "Name: ${bot.username}\nID: ${bot.id}"
                color = discord.configuration.theme
            }
        }
    }
}

/*fun demoConversation() = slashConversation(exitString = "exit") {
    val name = promptMessage(AnyArg, "What is your name?")
    val age = promptMessage(IntegerArg, "How old are you?")

    respond("Nice to meet you $name! $age is a great age.")
}*/
