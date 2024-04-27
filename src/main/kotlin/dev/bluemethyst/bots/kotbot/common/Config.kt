package dev.bluemethyst.bots.kotbot.common

import kotlinx.serialization.Serializable
import io.github.xn32.json5k.Json5
import java.io.File
import java.io.FileNotFoundException
import kotlin.system.exitProcess

@Serializable
data class BotConfig(
    val token: String,
    val endpoint: String
)

@Serializable
data class Config(
    val botConfig: BotConfig
)

fun loadConfig(): Config {
    try {
        val file = File("config.json5")
        val fileData = file.readText()
        println("Config found... loading...")
        return Json5.decodeFromString(Config.serializer(), fileData)
    } catch (e: FileNotFoundException) {
        println("Config file not found. Creating default config. Please edit the config!")
        val file = File("config.json5")
        val defaultConfig = Config(BotConfig("", ""))
        val json = Json5 { prettyPrint = true }
        file.writeText(json.encodeToString(Config.serializer(), defaultConfig))
        exitProcess(0)
    }
}