package mod2.handson1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(
    private val messages: MutableList<ChatMessage>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val USER = 1
        const val BOT = 2
    }

    override fun getItemViewType(position: Int): Int {
        return if (messages[position].isUser) USER else BOT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == USER) {

            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user, parent, false)

            UserViewHolder(view)

        } else {

            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_bot, parent, false)

            BotViewHolder(view)
        }
    }

    override fun getItemCount(): Int = messages.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val message = messages[position]

        if (holder is UserViewHolder) {

            holder.userMessage.text = message.message

        } else if (holder is BotViewHolder) {

            holder.botMessage.text = message.message
        }
    }

    class UserViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val userMessage: TextView =
            itemView.findViewById(R.id.txtUserMessage)
    }

    class BotViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val botMessage: TextView =
            itemView.findViewById(R.id.txtBotMessage)
    }
}