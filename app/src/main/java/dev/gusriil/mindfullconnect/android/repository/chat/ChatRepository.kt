package dev.gusriil.mindfullconnect.android.repository.chat

import dev.gusriil.mindfullconnect.android.dto.message.MessageModel
import dev.gusriil.mindfullconnect.android.dto.message.MessageResponseModel
import dev.gusriil.mindfullconnect.android.dto.post.PostResponseModel
import dev.gusriil.mindfullconnect.android.utils.Result
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    suspend fun initSession(
        room: Long
    ): Result<Boolean>

    suspend fun sendMessage(message: String)

    fun observeIncomingMessages(): Flow<MessageModel>

    suspend fun closeSession()

    suspend fun getAllRoomMessages(roomId: Long): Result<MessageResponseModel>

    suspend fun getAllChats(): Result<PostResponseModel>

    suspend fun addUserToRoom(roomId: Long): Result<Boolean>

    suspend fun removeUserFromRoom(roomId: Long): Result<Boolean>

    sealed class Endpoints(val url: String) {
        object CHAT_SOCKET : Endpoints("/chat-socket")
        object GET_ALL_ROOM_MESSAGES : Endpoints("/chat/messages")
        object GET_ALL_ROOMS : Endpoints("/chats")
        object JOIN_LEAVE_ROOM : Endpoints("/chat")
    }
}