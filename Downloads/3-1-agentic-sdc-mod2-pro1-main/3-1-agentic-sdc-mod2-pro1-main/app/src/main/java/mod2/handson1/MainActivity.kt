package mod2.handson1

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var editMessage: EditText
    private lateinit var sendButton: ImageButton

    private lateinit var adapter: ChatAdapter

    private val chatList = mutableListOf<ChatMessage>()

    private val repository = ChatRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        editMessage = findViewById(R.id.editMessage)
        sendButton = findViewById(R.id.btnSend)

        adapter = ChatAdapter(chatList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        addBotMessage("Hello 👋")
        addBotMessage("I'm your AI Assistant.")
        addBotMessage("Ask me anything.")

        sendButton.setOnClickListener {

            val userMessage = editMessage.text.toString().trim()

            if (userMessage.isEmpty()) return@setOnClickListener

            addUserMessage(userMessage)

            editMessage.text.clear()

            repository.sendMessage(userMessage) { reply ->

                runOnUiThread {

                    addBotMessage(reply)

                }

            }

        }
    }

    private fun addUserMessage(message: String) {

        chatList.add(ChatMessage(message, true))

        adapter.notifyItemInserted(chatList.size - 1)

        recyclerView.scrollToPosition(chatList.size - 1)
    }

    private fun addBotMessage(message: String) {

        chatList.add(ChatMessage(message, false))

        adapter.notifyItemInserted(chatList.size - 1)

        recyclerView.scrollToPosition(chatList.size - 1)
    }
}