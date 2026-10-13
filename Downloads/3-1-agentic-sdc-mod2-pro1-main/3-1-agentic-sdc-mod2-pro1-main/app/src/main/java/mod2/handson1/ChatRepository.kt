package mod2.handson1

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatRepository {

    fun sendMessage(
        message: String,
        callback: (String) -> Unit
    ) {

        val request = ChatRequest(message)

        ApiClient.api.sendMessage(request)
            .enqueue(object : Callback<ChatResponse> {

                override fun onResponse(
                    call: Call<ChatResponse>,
                    response: Response<ChatResponse>
                ) {

                    if (response.isSuccessful) {

                        callback(
                            response.body()?.reply
                                ?: "No response."
                        )

                    } else {

                        callback("Server Error")
                    }

                }

                override fun onFailure(
                    call: Call<ChatResponse>,
                    t: Throwable
                ) {

                    callback("Connection Failed")
                }

            })

    }

}