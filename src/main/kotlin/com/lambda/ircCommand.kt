import com.lambda.client.command.ClientCommand
import com.lambda.IRC
import com.lambda.IRC.sendString
import com.lambda.client.util.text.MessageSendHelper

object IRCCommand : ClientCommand(
    name = "irc",
    description = "Talk on the IRC channel"
) {
    init {
        greedy("message") { messageArg ->
            executeSafe {
                if(IRC.isEnabled){
                    sendString(IRC.bwriter, "PRIVMSG ${IRC.channel} :${messageArg.value}")
                    MessageSendHelper.sendChatMessage("IRC <${IRC.nickname}>: $messageArg.value")
                }
                else MessageSendHelper.sendChatMessage("IRC Module is not enabled")

            }

        }
    }
}