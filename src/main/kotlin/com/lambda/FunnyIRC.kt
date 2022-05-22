package com.lambda
import IRC
import IRCCommand
import com.lambda.client.plugin.api.Plugin

internal object FunnyIRC: Plugin() {

    override fun onLoad() {
        modules.add(IRC)
        commands.add(IRCCommand)

    }

    override fun onUnload() {}
}